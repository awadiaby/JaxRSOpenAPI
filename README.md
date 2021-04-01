# Tableau KANBAN
## Auteurs :
Tableau Kanban est une application semblable au tableau de bord Kanban. Il fournit les fonctionnalités suivantes :
   * Créer un tableau Kanban
   * Rajouter des fiches au tableau
   * Affecter ses fiches à des collaborateur
   * Créer des sections dans un tableau.

Nous avons commencé le projet par une conception qui nous a permis d'obtenir le diagramme de classe suivant :

![alt text](https://github.com/awadiaby/JaxRSOpenAPI/blob/master/Diagramme_SIR.jpg?raw=true)

Dans ce repository vous trouverez le backend du projet. Il s'agit d'une API, qui fournit l'ensemble des services,
conçu avec le langage Java et le framework JPA/Hibernate.
Nous avons utilisé swagger pour la représentation de notre API.

## Pré-requis pour utiliser le projet
* Java 8+
* Maven 3
* MySql ou autre...
* IDE (Eclipse ou IntelliJ)
* Postman (Optionnel mais facilite les tests)

## Installation et utilisation du projet
 Ouvrir un terminal et tapez les commandes suivantes:
 ```
 $ git clone https://github.com/awadiaby/JaxRSOpenAPI.git
 $ cd JaxRSOpenAPI
 $ mvn install #Intalle les dépendances de Maven
 ```
## Importer le projet dans IntelliJ :
* 1 - Click sur File -> New -> Project From Existing Sources -> Choisir le projet cloner précedemment
* 2 - Click sur File -> New -> Project From Version Control -> mettre ensuite le lien Github dans le champ URL -> cliquez sur Clone.

## Importer les données des tests :
 - Télécharger le fichier **data.sql** qui est à la racine du projet
 - Créer une base de données nommées tpjpa
 - Importer les données du fichier téléchagé précédemment en utilisant phpMyadmin ou l'outil fournir par IntelliJ
 
##### Lancer le projet en éxecutant la classe `RestServer`

Pour acceder à la documentation de l'API tapez l'url suivante sur votre navigateur : http://localhost:8089/api

Vous pouvez tester directement l'API sur l'interface de Swagger accessible via l'url ci-dessus ou sur Postman.
Vous trouverez à la racine du projet un ensemble de collections qui vous facilitera la tâche dans le dossier test-api.


