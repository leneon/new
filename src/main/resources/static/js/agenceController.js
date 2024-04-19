
var App = angular.module('myApp', []);

var appUrl;
App.controller('agenceController', ['$scope','$http', function ($scope,$http) {
    const appUrl = 'api/agences'; // Make sure you define the appUrl variable
    const urlLoadAgences = appUrl;
    const urlCreateAgence = appUrl + "/create";
    const urlUpdateAgence = appUrl + "/update";
    const urlDeleteAgence = appUrl + "/delete";
    const urlFindAgence  = appUrl + "/find";


    $scope.listeAgences = [];
    $scope.agenceDTO = { id: null, nom: null, adresse: null, ville: null, localisation: null};
    $scope.agenceMasterDTO = { id: null, nom: null, adresse: null, ville: null, localisation: null};

    // Fonction pour charger la liste des agences
    $scope.loadAgences = function () {
        $http.get(urlLoadAgences)
            .then(
                function (res) {
                    $scope.listeAgences = res.data;
                    console.log("LISTE DES AGENCES : ", $scope.listeAgences);
                },
                function (error) {
                    console.log("ERREUR DE RECUPERATION DES AGENCES : ", error);
                }
            );
    };
    // Chargez la liste des agences au chargement de la page
    $scope.loadAgences();

    // Fonction pour créer une agence
    $scope.createAgence = function () {
        var agenceJson = angular.toJson($scope.agenceMasterDTO);
    
        console.log(urlCreateAgence, agenceJson);
        // Envoyer les données JSON dans la requête POST
        $http.post(urlCreateAgence, agenceJson)
            .then(
                function (res) {
                    console.log("AGENCE CREE : ", res.data);
                    $scope.loadAgences();
                    // Réinitialisez l'objet agenceMasterDTO après la création
                    $scope.agenceMasterDTO = { id: null, nom: null, adresse: null, ville: null, localisation: null };
                    $scope.modalHide();
                    $scope.successSwal("Agence ajouter avec succès.");
                },
                function (error) {
                    console.log("ERREUR DE CREATION DE L'AGENCE : ", error);
                }
            );
    };
    

    // Fonction pour mettre à jour une agence
    $scope.updateAgence = function () {
        $http.put(urlUpdateAgence+'/'+$scope.agenceMasterDTO.id, $scope.agenceMasterDTO)
            .then(
                function (res) {
                    console.log("AGENCE MISE A JOUR : ", res.data);
                    $scope.loadAgences();
                    // Réinitialisez l'objet agenceDTO après la mise à jour
                    $scope.agenceMasterDTO = { id: null, nom: null, adresse: null, ville: null, localisation: null };
                    $scope.successSwal("Agence modifier avec succès.");
                },
                function (error) {
                    console.log("ERREUR DE MISE A JOUR DE L'AGENCE : ", error);
                }
            );
    };

 // Fonction pour supprimer une agence
$scope.deleteAgence = function (id) {
    // Afficher la boîte de dialogue de confirmation
    swal({
        title: "Êtes-vous sûr?",
        text: "Une fois supprimé, vous ne pourrez pas récupérer cette agence!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
    .then((willDelete) => {
        // Si l'utilisateur clique sur le bouton "Supprimer"
        if (willDelete) {
            // Envoyer la requête de suppression au serveur
            $http.delete(urlDeleteAgence + '/' + id)
                .then(
                    function (res) {
                        // Afficher un message de succès
                        swal("L'agence a été supprimée avec succès!", {
                            icon: "success",
                        });
                        // Recharger la liste des agences
                        $scope.loadAgences();
                    },
                    function (error) {
                        // Afficher un message d'erreur en cas d'échec de la suppression
                        swal("Erreur lors de la suppression de l'agence : " + error.message, {
                            icon: "error",
                        });
                    }
                );
        } else {
            // Si l'utilisateur clique sur le bouton "Annuler", ne rien faire
            swal("L'agence n'a pas été supprimée!");
        }
    });
};

    // Fonction pour trouver une agence par son ID
    $scope.findAgenceById = function (id) {
        $http.get(urlFindAgence + '/' + id)
            .then(
                function (res) {
                    console.log("AGENCE TROUVEE : ", res.data);
                    $scope.agenceMasterDTO = res.data;
                    $scope.modalShow();
                },
                function (error) {
                    console.log("ERREUR DE RECHERCHE DE L'AGENCE : ", error);
                }
            );
    };


    $scope.valider = function () {
        
        // Vérifiez si les champs requis sont remplis
        if (!$scope.agenceMasterDTO.nom || !$scope.agenceMasterDTO.adresse || !$scope.agenceMasterDTO.ville || !$scope.agenceMasterDTO.localisation) {
            console.log("Veuillez remplir tous les champs obligatoires.");
            $scope.errorSwal("Veuillez remplir tous les champs obligatoires.!");
            return;
        }

        if ($scope.agenceMasterDTO.id) {
            // Appel de la fonction de mise à jour
            $scope.updateAgence();
        } else {
            // Appel de la fonction de création
            $scope.createAgence();
            $scope.modalHide();

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
