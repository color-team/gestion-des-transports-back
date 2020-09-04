# Projet Backend

Pour tester le code initial :

* Démarrer l'application (en ligne de commande comme suit ou via un IDE) :

```
mvn spring-boot:run
```

* Lancer Postman.

* Importer le fichier `backend.postman_collection.json`.

* Tester la requête d'authentification `POST http://localhost:8080/login`.

* Tester la requête `GET http://localhost:8080/versions`.

## Déploiement Heroku

L'API est disponible à l'adresse suivante :

https://gestion-des-transports-back.herokuapp.com/



* GET /reservations-covoiturage
-   Lister toutes les annonces de covoiturages dans le futur

```
[
    {
        "id": 1,
        "dateDepart": "2020-09-17T09:10:00",
        "infosDepart": "31 Rue de la paix, Paris",
        "infosDestination": "Gare de Marseille-St-Charles, Marseille",
        "infosVehiculeParticulier": "Ford Focus",
        "infosConducteur": "DEV USER",
        "nbPlacesDisponibles": 2
    },
    {
        "id": 2,
        "dateDepart": "2020-09-25T12:30:00",
        "infosDepart": "31 Rue de la paix, Paris",
        "infosDestination": "Gare de Toulouse-Matabiau, Toulouse",
        "infosVehiculeParticulier": "Ford Focus",
        "infosConducteur": "DEV USER",
        "nbPlacesDisponibles": 2
    }
]
```

* GET /reservations-covoiturage/me
-   Lister toutes les réservations de covoiturage de l'utilisateur connecté

```
[
    {
        "dateDepart": "2020-09-25T12:30:00",
        "infosDepart": "31 Rue de la paix, Paris",
        "infosDestination": "Gare de Toulouse-Matabiau, Toulouse",
        "statutReservationCovoiturage": "DEMANDEE",
        "infosVehiculeParticulier": "Ford Focus",
        "infosConducteur": "DEV USER"
    },
    {
        "dateDepart": "2020-08-19T14:00:00",
        "infosDepart": "31 Rue de la paix, Paris",
        "infosDestination": "Gare de Toulouse-Matabiau, Toulouse",
        "statutReservationCovoiturage": "TERMINEE",
        "infosVehiculeParticulier": "Ford Focus",
        "infosConducteur": "DEV USER5"
    }
]
```

* GET /reservations-covoiturage/matricule
-   Lister toutes les réservation de covoiturage de l'utilisateur dont le matricule a été passé en paramètre


```
[
    {
        "dateDepart": "2020-09-17T09:10:00",
        "infosDepart": "31 Rue de la paix, Paris",
        "infosDestination": "Gare de Marseille-St-Charles, Marseille",
        "statutReservationCovoiturage": "DEMANDEE",
        "infosVehiculeParticulier": "Ford Focus",
        "infosConducteur": "DEV USER"
    },
    {
        "dateDepart": "2020-09-25T12:30:00",
        "infosDepart": "31 Rue de la paix, Paris",
        "infosDestination": "Gare de Toulouse-Matabiau, Toulouse",
        "statutReservationCovoiturage": "DEMANDEE",
        "infosVehiculeParticulier": "Ford Focus",
        "infosConducteur": "DEV USER"
    },
    {
        "dateDepart": "2020-08-19T14:00:00",
        "infosDepart": "31 Rue de la paix, Paris",
        "infosDestination": "Gare de Toulouse-Matabiau, Toulouse",
        "statutReservationCovoiturage": "TERMINEE",
        "infosVehiculeParticulier": "Ford Focus",
        "infosConducteur": "DEV USER5"
    }
]
```

* POST /reservations-covoiturage
-   Créer une annonce de covoiturage

-   Request :
```
 {
    "conducteur": "AD-667-09-KK",
    "dateDepart":"2020-09-13T11:26",
    "depart":"Paris",
    "destination":"Marseille",
    "nbPassager":3,
    "vehicule":{
        "immatriculation":"AAA-AAA-AAA",
        "marque":"Opel",
        "modele":"Corsa",
        "places":4
        }
}
```

-   Response :
```
{
    "dateDepart": "2020-09-13T11:26:00",
    "infosDepart": "Paris",
    "infosDestination": "Marseille",
    "statutReservationCovoiturage": null,
    "infosVehiculeParticulier": "Opel Corsa",
    "infosConducteur": "AD-667-09-KK"
}
```

* PUT /reservations-covoiturage
-   Ajouter l'utilisateur connecté comme passager d'une annonce de covoiturage

-   Request :
```
{
    "id": 1,
    "dateDepart": "2020-09-17T09:10:00",
    "infosDepart": "31 Rue de la paix, Paris",
    "infosDestination": "Gare de Marseille-St-Charles, Marseille",
    "infosVehiculeParticulier": "Ford Focus",
    "infosConducteur": "DEV USER",
    "nbPlacesDisponibles": 4
}
```

- Response :
```
{
    "id": 1,
    "dateDepart": "2020-09-17T09:10:00",
    "infosDepart": "31 Rue de la paix, Paris",
    "infosDestination": "Gare de Marseille-St-Charles, Marseille",
    "infosVehiculeParticulier": "Ford Focus",
    "infosConducteur": "DEV USER",
    "nbPlacesDisponibles": 3
}
```

* // PUT /reservations-covoiturage/matricule (Administrateur)
-   Ajouter l'utilisateur dont le matricule est passé en paramètre comme passager d'une annonce de covoiturage

-   Request:
```
{
    "id": 1,
    "dateDepart": "2020-09-17T09:10:00",
    "infosDepart": "31 Rue de la paix, Paris",
    "infosDestination": "Gare de Marseille-St-Charles, Marseille",
    "infosVehiculeParticulier": "Ford Focus",
    "infosConducteur": "DEV USER",
    "nbPlacesDisponibles": 4
}
```

- Response :
```
{
    "id": 1,
    "dateDepart": "2020-09-17T09:10:00",
    "infosDepart": "31 Rue de la paix, Paris",
    "infosDestination": "Gare de Marseille-St-Charles, Marseille",
    "infosVehiculeParticulier": "Ford Focus",
    "infosConducteur": "DEV USER",
    "nbPlacesDisponibles": 3
}
```
