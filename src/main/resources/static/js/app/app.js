'use strict'
var demoApp = angular.module('western', ['ui.bootstrap', 'obolochkova.controller',
    'obolochkova.service'
]);
demoApp.constant("CONSTANTS", {
    getByEmail: "/user/{email}/",
    getAllUsers: "/user/",
    saveUser: "/user/"
});