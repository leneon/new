// 'use strict';
// var App;
// var appUrl;
// App.controller('compteController', ['$scope', 'GenericService', 'StatutService', function ($scope, GenericService) {
//     const urlLoadClients = appUrl + "api/client/list";
//     const urlLoadAgences = appUrl + "api/agence/list";
//     const urlLoadUtilisateurs = appUrl + "api/utilisateur/list";

//     $scope.listClients = [];
//     $scope.listeAgences = [];
//     $scope.listUtilisateurs = [];


    
//     $scope.loadClients = function () {
//         GenericService.get(urlLoadClients)
//                 .then(
//                     function (data) {
//                         $scope.listClients = data.listClients;
//                     },
//                     function (error) {
//                         console.log("ERREUR DE RECUPERATION CLIENTS : ",error);
//                     }
//                 );
//     };
//     $scope.loadClients();

// }]);