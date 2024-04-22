var App = angular.module('myApp', []);

App.controller('garantieController', ['$scope', '$http', function ($scope, $http) {
    const appUrl = 'api/garanties'; // Assurez-vous de définir la variable appUrl
    const urlLoadGaranties = appUrl;
    const urlCreateGarantie = appUrl + "/create";
    const urlUpdateGarantie = appUrl + "/update";
    const urlDeleteGarantie = appUrl + "/delete";
    const urlFindGarantie = appUrl + "/find";
    const urlImportgaranties = appUrl + "/import";

    $scope.listeGaranties = [];
    $scope.garanties = [];

    $scope.garantieDTO = {
        id: null,
        fromDate: null,
        toDate: null,
        agence: null,
        garantie: null,
        totalSales: null,
        commissionOnSales: null,
        totalPayments: null,
        commissionOnPayments: null,
        totalCommission: null
    };
    $scope.garantieMasterDTO = angular.copy($scope.garantieDTO);

    // Fonction pour charger la liste des garanties
    $scope.loadGaranties = function () {
        $http.get(urlLoadGaranties)
            .then(
                function (res) {
                    $scope.listeGaranties = res.data;
                    console.log("LISTE DES GARANTIES : ", $scope.listeGaranties);
                },
                function (error) {
                    console.log("ERREUR DE RECUPERATION DES GARANTIES : ", error);
                }
            );
    };
    // Chargez la liste des garanties au chargement de la page
    $scope.loadGaranties();

    // Fonction pour créer une garantie
    $scope.createGarantie = function () {
        var garantieJson = angular.toJson($scope.garantieMasterDTO);

        console.log(urlCreateGarantie, garantieJson);
        // Envoyer les données JSON dans la requête POST
        $http.post(urlCreateGarantie, garantieJson)
            .then(
                function (res) {
                    console.log("GARANTIE CREE : ", res.data);
                    $scope.loadGaranties();
                    // Réinitialisez l'objet garantieMasterDTO après la création
                    $scope.garantieMasterDTO = angular.copy($scope.garantieDTO);
                    $scope.modalHide();
                    $scope.successSwal("Garantie ajoutée avec succès.");
                },
                function (error) {
                    console.log("ERREUR DE CREATION DE LA GARANTIE : ", error);
                }
            );
    };

    // Fonction pour mettre à jour une garantie
    $scope.updateGarantie = function () {
        $http.put(urlUpdateGarantie + '/' + $scope.garantieMasterDTO.id, $scope.garantieMasterDTO)
            .then(
                function (res) {
                    console.log("GARANTIE MISE A JOUR : ", res.data);
                    $scope.loadGaranties();
                    // Réinitialisez l'objet garantieDTO après la mise à jour
                    $scope.garantieMasterDTO = angular.copy($scope.garantieDTO);
                    $scope.successSwal("Garantie modifiée avec succès.");
                },
                function (error) {
                    console.log("ERREUR DE MISE A JOUR DE LA GARANTIE : ", error);
                }
            );
    };

    
    $scope.importExcel = function(){
        var fileInput = document.getElementById('excelFile');
        var file = fileInput.files[0];
        var reader = new FileReader();

        reader.onload = function (e) {
            var data = new Uint8Array(e.target.result);
            var workbook = XLSX.read(data, { type: 'array' });

            // Récupérer la première feuille de calcul
            var sheetName = workbook.SheetNames[0];
            var sheet = workbook.Sheets[sheetName];

            // Convertir les données de la feuille de calcul en format JSON
            var jsonData = XLSX.utils.sheet_to_json(sheet, { header: 1 });
            for (var i = 1; i < jsonData.length; i++) {
                var rowData = jsonData[i];
               
                var garantieData = {
                    fromDate: new Date(rowData[0]), 
                    toDate: new Date(rowData[1]), 
                    agence: rowData[2], 
                    bankCode: rowData[3], 
                    client: rowData[4], 
                    totalSales: parseFloat(rowData[5]), 
                    commissionOnSales: parseFloat(rowData[6]), 
                    totalPayements: parseFloat(rowData[7]), 
                    commissionOnPayements: parseFloat(rowData[8]) ,
                    totalCommission: parseFloat(rowData[9]) 
                };  
                $scope.garanties.push(garantieData);
            }
            
            console.log($scope.garanties);
    
        // Envoyer les données JSON dans la requête POST
        $http.post(urlImportgaranties, $scope.garanties)
            .then(
                function (res) {
                    console.log("garantie CREE : ", res.data);
                    $scope.loadgaranties();
                    fileInput = null;
                    $scope.successSwal("Importations efectué avec succès");
                },
                function (error) {
                    console.log("ERREUR D'IMPORTATION : ", error);
                }
        )}
    

        reader.readAsArrayBuffer(file);
    };


    // Fonction pour supprimer une garantie
    $scope.deleteGarantie = function (id) {
        // Afficher la boîte de dialogue de confirmation
        swal({
            title: "Êtes-vous sûr?",
            text: "Une fois supprimée, vous ne pourrez pas récupérer cette garantie!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
            .then((willDelete) => {
                // Si l'utilisateur clique sur le bouton "Supprimer"
                if (willDelete) {
                    // Envoyer la requête de suppression au serveur
                    $http.delete(urlDeleteGarantie + '/' + id)
                        .then(
                            function (res) {
                                // Afficher un message de succès
                                swal("La garantie a été supprimée avec succès!", {
                                    icon: "success",
                                });
                                // Recharger la liste des garanties
                                $scope.loadGaranties();
                            },
                            function (error) {
                                // Afficher un message d'erreur en cas d'échec de la suppression
                                swal("Erreur lors de la suppression de la garantie : " + error.message, {
                                    icon: "error",
                                });
                            }
                        );
                } else {
                    // Si l'utilisateur clique sur le bouton "Annuler", ne rien faire
                    swal("La garantie n'a pas été supprimée!");
                }
            });
    };

    // Fonction pour trouver une garantie par son ID
    $scope.findGarantieById = function (id) {
        $http.get(urlFindGarantie + '/' + id)
            .then(
                function (res) {
                    console.log("GARANTIE TROUVEE : ", res.data);
                    $scope.garantieMasterDTO = res.data;
                    $scope.modalShow();
                },
                function (error) {
                    console.log("ERREUR DE RECHERCHE DE LA GARANTIE : ", error);
                }
            );
    };

    $scope.valider = function () {

        // Vérifiez si les champs requis sont remplis
        if (!$scope.garantieMasterDTO.fromDate || !$scope.garantieMasterDTO.toDate || !$scope.garantieMasterDTO.agence || !$scope.garantieMasterDTO.garantie || !$scope.garantieMasterDTO.totalSales || !$scope.garantieMasterDTO.commissionOnSales || !$scope.garantieMasterDTO.totalPayments || !$scope.garantieMasterDTO.commissionOnPayments || !$scope.garantieMasterDTO.totalCommission) {
            console.log("Veuillez remplir tous les champs obligatoires.");
            $scope.errorSwal("Veuillez remplir tous les champs obligatoires !");
            return;
        }

        if ($scope.garantieMasterDTO.id) {
            // Appel de la fonction de mise à jour
            $scope.updateGarantie();
        } else {
            // Appel de la fonction de création
            $scope.createGarantie();
            $scope.modalHide();

        }
    };


    $scope.successSwal = function (string) {
        swal({
            title: "Succès",
            text: string,
            icon: "success",
            button: "OK!",
        });
    };
    $scope.errorSwal = function (string) {
        swal({
            title: "Erreur",
            text: string,
            icon: "error",
            button: "OK!",
        });
    };

    $scope.modalShow = function () {
        $('#myModal').modal('show');
    };
    $scope.modalHide = function(){
        $('#myModal').modal('hide');
    };
}]);
