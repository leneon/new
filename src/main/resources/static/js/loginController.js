var App = angular.module('myApp', []);

App.controller('garantieController', ['$scope', '$http', function ($scope, $http) {
    const urlLoadRedirect = "appUrl";
    const urlLogin =  "/login";
   

    $scope.authDTO = {identiication:null,password:null};

    $scope.authDTOMaster = angular.copy($scope.authDTO);

    // Fonction pour créer la connexion
    $scope.login = function () {
        var authJson = angular.toJson($scope.garantieMasterDTO);

        console.log(urlLogin, authJson);
        // Envoyer les données JSON dans la requête POST
        $http.post(urlLogin, authJson)
            .then(
                function (res) {
                    console.log("Connexion reussi: ", res.data);
                    
                },
                function (error) {
                    console.log("ERREUR DE CONNEXION : ", error);
                }
            );
    };


    $scope.valider = function () {
        // Vérifiez si les champs requis sont remplis
        if (!$scope.authDTO.identification || !$scope.authDTO.password ) {
            console.log("Veuillez remplir tous les champs obligatoires.");
            $scope.errorSwal("Veuillez remplir tous les champs obligatoires !");
            return;
        }
            $scope.login();
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
}]);
