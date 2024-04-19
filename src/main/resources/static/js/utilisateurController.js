var App = angular.module('myApp', []);

App.controller('utilisateurController', ['$scope','$http', function ($scope, $http) {
  const appUrl = "api/utilisateurs";
  const urlLoadUtilisateurs = appUrl ;
  const urlLoadAgences = "api/agences";
  const urlCreateUtilisateur = appUrl + "/create";
  const urlUpdateUtilisateur = appUrl + "/update";
  const urlDeleteUtilisateur = appUrl + "/delete";
  const urlFindUtilisateur = appUrl + "/find";

  $scope.listeUtilisateurs = [];
  $scope.utilisateurDTO = { id: null, nom: null, prenoms: null, email: null, telephone: null, username: null, agence: { id: null, nom: "" } };
  $scope.utilisateurMasterDTO = { id: null, nom: null, prenoms: null, email: null, telephone: null, username: null, agence: { id: null, nom: "" } };
  $scope.listeAgences = [];

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
    // Fonction pour trouver une agence par son ID
    $scope.findUtilisateurById = function (id) {
        $http.get(urlFindUtilisateur + '/' + id)
            .then(
                function (res) {
                    console.log("Utilisateur TROUVEE : ", res.data);
                    $scope.utilisateurMasterDTO = res.data;
                    $scope.modalShow();
                },
                function (error) {
                    console.log("ERREUR DE RECHERCHE DU Utilisateur : ", error);
                }
            );
    };


  // Fonction pour charger la liste des Utilisateurs
  $scope.loadUtilisateurs = function () {
      $http.get(urlLoadUtilisateurs)
          .then(
              function (res) {
                  $scope.listeUtilisateurs = res.data;
                  console.log("LISTE DES UtilisateurS : ", $scope.listeUtilisateurs);
              },
              function (error) {
                  console.log("ERREUR DE RECUPERATION DES UtilisateurS : ", error);
              }
          );
  };

    // Fonction pour créer une Utilisateur
    $scope.createUtilisateur = function () {
        var UtilisateurJson = angular.toJson($scope.utilisateurMasterDTO);
    
        console.log(urlCreateUtilisateur, UtilisateurJson);
        // Envoyer les données JSON dans la requête POST
        $http.post(urlCreateUtilisateur, UtilisateurJson)
            .then(
                function (res) {
                    $scope.modalHide();
                    console.log("Utilisateur CREE : ", res.data);
                    $scope.loadUtilisateurs();
                    swal({
                        title: "Succès",
                        text: "Utilisateur crée avec succès!",
                        icon: "success",
                        button: "OK!",
                      });
                    // Réinitialisez l'objet UtilisateurMasterDTO après la création
                    $scope.utilisateurMasterDTO = $scope.utilisateurDTO ;               },
                function (error) {
                    console.log("ERREUR DE CREATION DE L'Utilisateur : ", error);
                }
            );
    };
    

    // Fonction pour mettre à jour une 
    $scope.updateUtilisateur = function () {
        $http.put(urlUpdateUtilisateur+'/'+$scope.utilisateurMasterDTO.id, $scope.utilisateurMasterDTO)
            .then(
                function (res) {
                    console.log("Utilisateur MISE A JOUR : ", res.data);
                    $scope.loadUtilisateurs();
                    // Réinitialisez l'objet UtilisateurDTO après la mise à jour
                    $scope.utilisateurMasterDTO = $scope.utilisateurDTO ;     
                    $scope.modalHide();
                    $scope.successSwal("Mise a jour éffectué avec succès");

                },
                function (error) {
                    console.log("ERREUR DE MISE A JOUR DE L'Utilisateur : ", error);
                }
            );
    };
   // Fonction pour supprimer une agence
$scope.deleteUtilisateur = function (id) {
    // Afficher la boîte de dialogue de confirmation
    swal({
        title: "Êtes-vous sûr?",
        text: "Une fois supprimé, vous ne pourrez pas récupérer ce Utilisateur!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
    .then((willDelete) => {
        // Si l'utilisateur clique sur le bouton "Supprimer"
        if (willDelete) {
            // Envoyer la requête de suppression au serveur
            $http.delete(urlDeleteUtilisateur + '/' + id)
                .then(
                    function (res) {
                        // Afficher un message de succès
                        swal("Le Utilisateur a été supprimée avec succès!", {
                            icon: "success",
                        });
                        // Recharger la liste des agences
                        $scope.loadUtilisateurs();
                    },
                    function (error) {
                        // Afficher un message d'erreur en cas d'échec de la suppression
                        swal("Erreur lors de la suppression du Utilisateur : " + error.message, {
                            icon: "error",
                        });
                    }
                );
        } else {
            // Si l'utilisateur clique sur le bouton "Annuler", ne rien faire
            swal("Le Utilisateur n'a pas été supprimée!");
        }
    });
};

  // Chargez la liste des Utilisateurs au chargement de la page
  $scope.loadUtilisateurs();

  $scope.valider = function () {
        
    // Vérifiez si les champs requis sont remplis
    if (!$scope.utilisateurMasterDTO.agence || !$scope.utilisateurMasterDTO.nom || !$scope.utilisateurMasterDTO.prenoms || !$scope.utilisateurMasterDTO.email || !$scope.utilisateurMasterDTO.telephone || !$scope.utilisateurMasterDTO.username) {
        console.log("Veuillez remplir tous les champs obligatoires.");
        swal({
            title: "Erreur",
            text: "Veuillez remplir tous les champs obligatoires.!",
            icon: "error",
            button: "OK!",
          });
        return;
    }

    if ($scope.utilisateurMasterDTO.id) {
        // Appel de la fonction de mise à jour
        $scope.updateUtilisateur();
    } else {
        // Appel de la fonction de création
        $scope.createUtilisateur();
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

