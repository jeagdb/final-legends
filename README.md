# JAVA FINAL LEGENDS - Projet Epita  ![](https://sigl.epita.fr/assets/images/Epita.png =70x)

:::success
Ce projet a été conçu dans le cadre du cours de Java à EPITA. Il a été réalisé par 4 etudiants de MTI, promo 2021 : 
- Feng Chung
- Thomas Franel
- Jeanne Gardebois
- Alister Gracias
***
## **Si vous désirez voir ce document de manière plus propre rendez vous ici : https://hackmd.io/@r55fsu4gQj684gdxq1xD3g/HyhTBbORL**
:::


### Sommaire
- :video_game: [**L'API**](#-L'API)
- :rocket: [**Comment lancer le projet ?**](#-Comment-lancer-le-projet-?)
    * :file_cabinet: [*Etape 1: Créer la database*](#-Etape-1-Créer-la-database)
    * :computer: [*Etape 2: Lancer le projet*](#-Etape-2-Lancer-le-projet)

## :video_game: L'API

Cette API renvoit des ressources pour simuler un RPG. Le but est de pouvoir réutiliser les routes pour récupérer des données de la bdd et de les modifier si besoin.

## :rocket: Comment lancer le projet ?

### :file_cabinet: Etape 1: Créer la database
- Créer une database **mysql** nommée *legendsdb*.
- Run le ddl.sql
- Changer les crédentials dans le fichier *src/main/resources/application.yaml*

```=
server:
  port: 8085

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/legendsdb?serverTimezone=UTC
    username: *VOTRE USERNAME*
    password: *VOTRE PASSWORD*

  jpa:
    properties:
      hibernate:
        show_sql: true
        use_sql_comments: true
        format_sql: true
```

### :computer: Etape 2: Lancer le projet
```
$ mvn exec:java -Dexec.mainClass="com.mti.legend.FinalLegendApplication"
```

## ![](https://www.ixon.cloud/media/ciqpa3f3/api-2x.png =70x) Endpoints
> mti1.Socra.controller

### :arrow_heading_down: Put

:::success
**PUT** /dungeons
:::spoiler infos
:::success
Cette route permet d'attaquer un donjon, en effet chaque donjon possède un pull de monstres à attaquer pour gagner de l'expérience et monter de niveau.
**body** : un AttackDungeonDtoRequest contenant :
```Json
{
    "skillId": 1,
    "monsterId": 2
}
```
**retour** : des informations sur l'attaque envoyée et sur le monstre attaqué pour pouvoir gérer les dégats infligés depuis le moteur de jeu. 
:::

:::success
**PUT** /player/
:::spoiler infos
:::success
Route qui permet de créer un unique joueur ou de le modifier s'il a déjà été créé.
**body** : un PutPlayerDtoRequest contenant :
```Json
{
    "name": "SuperProfAntoine",
    "vocation": "guerrier"
}
```
**retour** : Toutes les informations concernant le joueur : son nom, son niveau, sa vocation, ses stats et son expérience.
:::

### :arrow_left: Get

:::info
**GET** /player/
:::spoiler infos
:::info
Route pour récupérer les informations de l'unique joueur.
**Retour** Toutes les informations concernant le joueur : son nom, son niveau, sa vocation, ses stats et son expérience.
:::

:::info
**GET** /player/{id}/skills
:::spoiler infos
:::info
Routes pour récupérer la liste de tous les skills d'un joueur.
**Paramètre de la route**
- id : id du player

**Retour** La liste des skills du player avec les informations concernant un skill : son nom, ses dégâts et son coût.
:::

:::info
**GET** /skill/vocation
:::spoiler infos
:::info
Route pour récupérer les compétences de toutes les vocations du jeu, afin par exemple de gérer un affichage de suggestion des vocations notamment
**Retour** Une liste comportant le nom des vocations accompagnées de leurs compétences associées.
:::

:::info
**GET** /skill/monster
:::spoiler infos
:::info
Route pour récupérer les compétences de toutes les monstres du jeu, afin par exemple de gérer un affichage des monstres du jeu avec les compétences qu'ils peuvent avoir
**Retour** Une liste comportant les infos des monstres avec les compétences associées à ces monstres.
:::

:::info
**GET** /dungeons/{id}
:::spoiler infos
:::info
Route pour récupérer les informations d'un donjon, à savoir son nom et les monstres présents dans ce donjon.
**Retour** Un objet comportant le nom du donjon et la liste des monstres avec leurs infos.
:::

:::info
**GET** /dungeons
:::spoiler infos
:::info
Route pour récupérer la liste de tous les donjons.
**Retour** La liste de tous les donjons.
:::