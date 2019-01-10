
'use strict'
angular.module('obolochkova.service', []).factory('UserService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.getUserByEmail = function(email) {
        var url = CONSTANTS.getUserByEmailUrl + email;
        return $http.get(url);
    }
    service.getAllUsers = function() {
        return $http.get(CONSTANTS.getAllUsers);
    }
    service.saveUser = function(userDto) {
        return $http.post(CONSTANTS.saveUser, userDto);
    }
    return service;
}]);