'use strict'
var module = angular.module('obolochkova.controller', []);
module.controller("UserController", ["$scope", "UserService",
    function($scope, UserService) {
        $scope.userDto = {
            firstName: null,
            lastName: null,
            email: null,
            birthDay: null
        };

        UserService.getUserByEmail(1).then(function(value) {
            console.log(value.data);
        }, function(reason) {
            console.log("error occured");
        }, function(value) {
            console.log("no callback");
        });
        $scope.saveUser = function() {
            UserService.saveUser($scope.userDto).then(function() {
                console.log("works");
                UserService.getAllUsers().then(function(value) {
                    $scope.allUsers = value.data;
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });

                $scope.userDto = {
            firstName: null,
            lastName: null,
            email: null,
            birthDay: null
                };
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        }
    }
]);