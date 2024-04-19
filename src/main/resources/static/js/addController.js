var App = angular.module('myApp', []);

App.controller('addController', ['$scope','$http', function ($scope, $http) {
  const appUrl = "api/abattements";
  const urlLoadAbattements = appUrl ;
  const urlLoadClients= "api/clients";
  const urlLoadParametres= "api/parametres";
  const urlCreateAbattement = appUrl + "/create";
  const urlUpdateAbattement = appUrl + "/update";
  const urlDeleteAbattement = appUrl + "/delete";
  const urlFindAbattement = appUrl + "/find";

  $scope.listeAbattements = [];
  $scope.abattementMasterObjectDTO = { id: null, client: {id:null, numeroOp:null}, date: new Date(), journee: null, vente: null, paiement: null, solde_a_verser: null,reg: null,nonReg: null,total: null, heure:null, parametres:[]};
  $scope.abattementObjectDTO = { id: null, client: {id:null, numeroOp:null}, date: new Date(), journee: null, vente: null, paiement: null, solde_a_verser: null,reg: null,nonReg: null,total: null, heure:null, parametres:[]};
  $scope.listeClients = [];
  $scope.listeParametres = [];

   // Fonction pour charger la liste des clients
   $scope.loadClients = function () {
    $http.get(urlLoadClients)
        .then(
            function (res) {
                $scope.listeClients = res.data;
                console.log("LISTE DES CLIENTS : ", $scope.listeClients);
            },
            function (error) {
                console.log("ERREUR DE RECUPERATION DES CLIENTS : ", error);
            }
        );
    };
    // Chargez la liste des clients au chargement de la page
    $scope.loadClients();

    // Fonction pour charger la liste des parametres
    $scope.loadParametres = function () {
    $http.get(urlLoadParametres)
        .then(
            function (res) {
                $scope.listeParametres = res.data;
                console.log("LISTE DES PARAMETRES : ", $scope.listeParametres);
            },
            function (error) {
                console.log("ERREUR DE RECUPERATION DES PARAMETRES : ", error);
            }
        );
    };
    // Chargez la liste des clients au chargement de la page
    $scope.loadParametres();

    // Fonction pour trouver une client par son ID
    $scope.findAbattementById = function (id) {
        $http.get(urlFindAbattement + '/' + id)
            .then(
                function (res) {
                    console.log("Abattement TROUVEE : ", res.data);
                    $scope.abattementMasterDTO = res.data;
                    $scope.modalShow();
                },
                function (error) {
                    console.log("ERREUR DE RECHERCHE DU Abattement : ", error);
                }
            );
    };


  // Fonction pour charger la liste des Abattements
  $scope.loadAbattements = function () {
      $http.get(urlLoadAbattements)
          .then(
              function (res) {
                  $scope.listeAbattements = res.data;
                  console.log("LISTE DES AbattementS : ", $scope.listeAbattements);
              },
              function (error) {
                  console.log("ERREUR DE RECUPERATION DES AbattementS : ", error);
              }
          );
  };

    // Fonction pour créer une Abattement
    $scope.createAbattement = function () {
        var AbattementJson = angular.toJson($scope.abattementMasterObjectDTO);
    
        console.log(urlCreateAbattement, $scope.abattementMasterObjectDTO);
        // Envoyer les données JSON dans la requête POST
        $http.post(urlCreateAbattement, $scope.abattementMasterObjectDTO)
            .then(
                function (res) {
                    $scope.modalHide();
                    console.log("Abattement CREE : ", res.data);
                    $scope.loadAbattements();
                    swal({
                        title: "Succès",
                        text: "Abattement crée avec succès!",
                        icon: "success",
                        button: "OK!",
                      });
                    // Réinitialisez l'objet AbattementMasterDTO après la création
                    $scope.abattementMasterDTO = $scope.abattementDTO ;               },
                function (error) {
                    console.log("ERREUR DE CREATION DE L'Abattement : ", error);
                }
            );
    };
    

    // Fonction pour mettre à jour une 
    $scope.updateAbattement = function () {
        $http.put(urlUpdateAbattement+'/'+$scope.abattementMasterObjectDTO.id, $scope.abattementMasterObjectDTO)
            .then(
                function (res) {
                    console.log("Abattement MISE A JOUR : ", res.data);
                    $scope.loadAbattements();
                    // Réinitialisez l'objet AbattementDTO après la mise à jour
                    $scope.abattementMasterDTO = $scope.abattementDTO ;     
                    $scope.modalHide();
                    $scope.successSwal("Mise a jour éffectué avec succès");

                },
                function (error) {
                    console.log("ERREUR DE MISE A JOUR DE L'Abattement : ", error);
                }
            );
    };
   // Fonction pour supprimer une client
$scope.deleteAbattement = function (id) {
    // Afficher la boîte de dialogue de confirmation
    swal({
        title: "Êtes-vous sûr?",
        text: "Une fois supprimé, vous ne pourrez pas récupérer ce Abattement!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
    .then((willDelete) => {
        // Si l'abattement clique sur le bouton "Supprimer"
        if (willDelete) {
            // Envoyer la requête de suppression au serveur
            $http.delete(urlDeleteAbattement + '/' + id)
                .then(
                    function (res) {
                        // Afficher un message de succès
                        swal("Le Abattement a été supprimée avec succès!", {
                            icon: "success",
                        });
                        // Recharger la liste des clients
                        $scope.loadAbattements();
                    },
                    function (error) {
                        // Afficher un message d'erreur en cas d'échec de la suppression
                        swal("Erreur lors de la suppression du Abattement : " + error.message, {
                            icon: "error",
                        });
                    }
                );
        } else {
            // Si l'abattement clique sur le bouton "Annuler", ne rien faire
            swal("Le Abattement n'a pas été supprimée!");
        }
    });
};

  // Chargez la liste des Abattements au chargement de la page
  $scope.loadAbattements();

  $scope.valider = function () {
    var parametresSelectionnes = [];
    for (var key in $scope.abattementMasterObjectDTO.parametres) {
        if ($scope.abattementMasterObjectDTO.parametres[key]) {
            parametresSelectionnes.push(key);
        }
    }
    $scope.abattementMasterObjectDTO.parametres = parametresSelectionnes;

    console.log($scope.abattementMasterObjectDTO);
    $scope.abattementMasterObjectDTO.solde_a_verser = parseFloat(document.getElementById('solde_a_verser').value);
    if($scope.abattementMasterObjectDTO.heure)
        $scope.abattementMasterObjectDTO.heure = $scope.abattementMasterObjectDTO.heure.toISOString().substring(11, 19);
    // Vérifiez si les champs requis sont remplis
    if (!$scope.abattementMasterObjectDTO.client || !$scope.abattementMasterObjectDTO.journee || !$scope.abattementMasterObjectDTO.date || !$scope.abattementMasterObjectDTO.vente || !$scope.abattementMasterObjectDTO.paiement || !$scope.abattementMasterObjectDTO.journee) {
        console.log("Veuillez remplir tous les champs obligatoires.");
        swal({
            title: "Erreur",
            text: "Veuillez remplir tous les champs obligatoires.!",
            icon: "error",
            button: "OK!",
          });
        return;
    }

    if ($scope.abattementMasterObjectDTO.id) {
        // Appel de la fonction de mise à jour
        $scope.updateAbattement();
    } else {
        // Appel de la fonction de création
        $scope.createAbattement();
    }
};

$scope.successSwal = function(string){
    swal({
        title: "Succès",
        text: string,
        icon: "success",
        button: "OK!",
      });
};
$scope.errorSwal = function(string){
    swal({
        title: "Erreur",
        text: string,
        icon: "error",
        button: "OK!",
      });
};

$scope.modalShow = function(){
    $('#myModal').modal('show');
};
$scope.modalHide = function(){
    $('#myModal').modal('hide');
};
}]);

