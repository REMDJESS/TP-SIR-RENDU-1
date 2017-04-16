# TP-SIR-RENDU-1

#PARTIE I Back-End
##### objectifs
`Comprendre les mécanismes des servlets`

`Réaliser une application web en combinant JPA et les Servlets`

`Comprendre les principes d'une architecture Rest`

`Comprendre les bénéfices d'un framework come Jersey`

##### Demarrage de la base de données
`sh run-hsqldb-server.sh`
##### Démarrage du manager de la base de données
`sh shwo-hsqldb.sh`
##### parametres de connexion à la base de données:
Type: `HSQL Database Engine Server`

Driver: `org.hsqldb.jdbcDriver`

User: `sa`

Password: `aucun mot de passe`

URL: `jdbc:hsqldb:hsql://localhost/`

:information_source: Supprimez le contenu du répertoire `data`, si vous souhaitez réinitialiser la base de données.

##### Demarrage de l'application
`mvn tomcat7:run`
Lancez http://localhost:8080/index.html pour consulter la page 


# PARTIE II : Front-End
## Objectif
  Le but de ce TP est de construire une interface Web pour notre application développée en Java côté serveur.

## Description/Organisation du projet
* Le projet est composé de deux parties.
	- Il y a 2 frameworks : AngularJs et Bootstrap
	- On a 2 controllers AngularJs : 
		* 1 controller pour afficher sur le site les données du json importé localement disponibles dans une URI
		* 1 controller pour afficher sur le site les données du json qui correspondent aux données de hsqldb disponibles dans une URI
## Informations complémentaires
## Technologies utilisées
* Java
* JPA
* Jersey
* HTML5
* AngularJs v1.6.4 : framework JavaScript
* Bootstrap : framework CSS

## Outils de dévelopment
* [Eclipse Java](https://eclipse.org/)
* [Maven](https://maven.apache.org)
* [Tomcat7](http://tomcat.apache.org/)
* [HSQLDB](http://hsqldb.org/)
* [Atom](https://atom.io/)
* [NodeJS v7.7.1](https://nodejs.org/en/)
* [Npm v4.1.2](https://www.npmjs.com/)
* [Yeoman](http://yeoman.io/) 

## Tuturiel sous Windows 7 pour lancer l'application Web
- Pré-requis : avoir installé tous les outils de dévelopment cités ci-dessus
- Télécharger ou cloner ce dépôt git :

      git clone https://github.com/REMDJESS/TP-SIR-RENDU-1
                       
  * Il manque 2 dossiers dans ce dépôt git et qui sont indispensables pour faire fonctionner le site en local "bower_components" et "node_modules". 
  * Nous allons donc devoir les regénérer en suivant ces étapes suivantes.
  * Créez un dossier au hasard sur votre disque dur et positionnez vous dans ce dossier depuis un cmd
  * Dans ce dossier et depuis un cmd, exécutez les commandes suivantes :
    * npm install -g yo grunt-cli bower (si c'est la 1ère fois que vous utilisez npm)
    * npm install -g generator-angular (si c'est la 1ère fois que vous utilisez npm)
		* yo angular :
      - Répondez No concernant Gulp au lieu de Grunt
        - Répondez No concernant l'utilisation de Sass
        - Répondez Yes concernant l'utilisation de Bootstrap
        - Cochez toutes les cases concernant les modules angular
    * npm install grunt-connect-proxy --save-dev
  * Une fois que toute les commandes sont exécutées, remplacer le dossier app créé par yo par celui contenu dans 'yo/app du projet importé 
  * Lancez un cmd depuis le dossier yo et exécutez la commande : grunt serve
  * L'application web devrait se lancer sur votre navigateur à l'adresse : http://localhost:9000/
