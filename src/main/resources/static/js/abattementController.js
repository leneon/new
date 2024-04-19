var App = angular.module('myApp', []);

App.controller('abattementController', ['$scope','$http', function ($scope, $http) {
  const appUrl = "api/abattements";
  const urlLoadAbattements = appUrl ;
  const urlDeleteAbattements = appUrl + "/delete";
  const urlFindAbattement = appUrl + "/find";

    $scope.listeabattements = [];
    $scope.abattementParametre = null;

    // Fonction pour trouver une agence par son ID
    $scope.findAbattementById = function (id) {
        $http.get(urlFindAbattement + '/' + id)
            .then(
                function (res) {
                    console.log("abattement TROUVEE : ", res.data);
                    $scope.abattementMasterDTO = res.data;
                    $scope.modalShow();
                },
                function (error) {
                    console.log("ERREUR DE RECHERCHE DU abattement : ", error);
                }
            );
    };


  // Fonction pour charger la liste des abattements
  $scope.loadAbattements = function () {
      $http.get(urlLoadAbattements)
          .then(
              function (res) {
                  $scope.listeAbattements = res.data;
                  console.log("LISTE DES abattements : ", $scope.listeAbattements);
              },
              function (error) {
                  console.log("ERREUR DE RECUPERATION DES abattements : ", error);
              }
          );
  };
  $scope.loadAbattements ();

   // Fonction pour supprimer une agence
    $scope.deleteAbattement = function (id) {
        // Afficher la boîte de dialogue de confirmation
        swal({
            title: "Êtes-vous sûr?",
            text: "Une fois supprimé, vous ne pourrez pas récupérer ce abattement!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
        .then((willDelete) => {
            // Si l'abattement clique sur le bouton "Supprimer"
            if (willDelete) {
                // Envoyer la requête de suppression au serveur
                $http.delete(urlDeleteAbattements + '/' + id)
                    .then(
                        function (res) {
                            // Afficher un message de succès
                            swal("Le abattement a été supprimée avec succès!", {
                                icon: "success",
                            });
                            // Recharger la liste des agences
                            $scope.loadabattements();
                        },
                        function (error) {
                            // Afficher un message d'erreur en cas d'échec de la suppression
                            swal("Erreur lors de la suppression du abattement : " + error.message, {
                                icon: "error",
                            });
                        }
                    );
            } else {
                // Si l'abattement clique sur le bouton "Annuler", ne rien faire
                swal("Le abattement n'a pas été supprimée!");
            }
        });
    };

$scope.showParametre = function(ap){
    $scope.abattementParametre = ap;
    console.log(ap);
    $scope.modalShow();
};

$scope.modalShow = function(){
    $('#myModal').modal('show');
};
$scope.modalHide = function(){
    $('#myModal').modal('hide');
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

}]);

