'use strict';

/**
 * @ngdoc overview
 * @name yoApp
 * @description
 * # yoApp
 *
 * Main module of the application.
 */
angular
  .module('lolChampsApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  // Enleve le hash-bang :  passer de '#!' à '#' pour les href
  .config(['$locationProvider', function($locationProvider) {
        $locationProvider.hashPrefix('');
    }])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'formCtrl'
      })
      .when('/membreList', {
        templateUrl: 'views/membreList.html',
        controller: 'membreListCtrl',
        controllerAs: 'membreList'
      })
      .when('/about', {
        templateUrl: 'views/about.html'
      })
      .when('/form', {
        templateUrl: 'views/form.html',
        controller: 'formCtrl'
      })
      .when('/404', {
        templateUrl: 'views/404.html',
      })
      .otherwise({
        redirectTo: '/'
      });
  });
