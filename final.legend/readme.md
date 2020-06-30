# JAVA FINAL LEGENDS - Projet Epita  ![](https://sigl.epita.fr/assets/images/Epita.png =70x)

:::success
Ce projet a été conçu dans le cadre du cours de Java à EPITA. Il a été réalisé par 4 etudiants de MTI, promo 2021 : 
- Feng Chung
- Thomas Franel
- Jeanne Gardebois
- Alister Gracias
:::


### Sommaire
- :video_game: [**L'API**](#-L'API)
- :rocket: [**Comment lancer le projet ?**](#-Comment-lancer-le-projet-?)
    * :file_cabinet: [*Etape 1: Créer la database*](#-Etape-1-Créer-la-database)
    * :computer: [*Etape 2: Lancer le projet*](#-Etape-2-Lancer-le-projet)

## :video_game: L'API

Cette API renvoit des ressources pour simuler un RPG.

## :rocket: Comment lancer le projet ?

### :file_cabinet: Etape 1: Créer la database
- Créer une database **mysql** nommée *legendsdb*.
- Run le ddl.sql
- Changer les crédentials dans le fichier *src/main/resources/application.yaml*

### :computer: Etape 2: Lancer le projet
```
$ mvn exec:java -Dexec.mainClass="com.mti.legend.FinalLegendApplication"
```