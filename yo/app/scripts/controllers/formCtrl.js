'use strict';

/**
* @ngdoc function
* @name commentsCtrl
* @description
* Controller de la page index pour la gestion des commentaires
* Tous les messages, pseudos, heure viennent d'un uri
*/
angular.module('lolChampsApp')
.controller('formCtrl', function ($scope, $http) {
  // Obtenir tous les infos des personnes qui ont commenté à partir d'un json dispo dans une uri
  // L'uri est dispo grâce à la partie Java en faisant tourné le serveur Tomcat7
  $http({
    method: 'GET',
    url: "rest/msg/all"}).then(function successCallback(response) {
      $scope.msg = response.data;
    });
  });

/**
* Fonction qui vérifie les champ du formulaire ajout commentaire
*/
function check(champ) {
  if (champ.value.length < 2 || champ.value.length > 500) {
    return false;
  } else {
    return true;
  }
}

/**
* Fonction qui vérifie le formulaire d'ajout comentaire
* et décide d'ajouter dans la bd ou pas
*/
function checkForm(f) {
  var name = check(f.name);
  var content = check(f.content);

  if (name && content) {
    alert("Membre ajouté avec succès.");
    return true;
  } else {
    alert("Veuillez remplir correctement tous les champs.");
    return false;
  }
}

/**
* Fonction qui vérifie le formulaire d'ajout comentaire
* et décide d'ajouter dans la bd ou pas
*/
function checkContactForm(f) {
  var name = check(f.name);
  var fName = check(f.fName);
  var email = check(f.mail);
  var sexe = check(f.sexe);
  var facebook = check(f.facebook);

  if (name && sexe && email && fName && facebook) {
    alert("Votre demande de contact a bien été enregistré et reçu.");
    return true;
  } else {
    alert("Veuillez remplir correctement tous les champs.");
    return false;
  }
}
