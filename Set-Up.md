# TP Web-Serveur

Vous pouvez démarrer avec la commande `./gradlew run`.

Et voir le résultat à l'adresse localhost:8081

+ d'infos sur https://unicorn.artheriom.fr/


# Les classes

Dans notre projet, Les quatre classes ImmeubleEntity, ImmeubleDAO, ImmeubleGUI et ImmeubleCore travaillent ensemble pour gérer les immeubles dans notre application.

    ImmeubleEntity est une classe d'entité qui représente un immeuble dans notre application. Elle contient des attributs tels que le nom de l'immeuble, l'adresse, le nom du syndicat, le pourcentage de l'immeuble qui est loué, etc.

    ImmeubleDAO est une classe Data Access Object qui gère la persistance des données pour les immeubles. Elle contient des méthodes pour créer, lire, mettre à jour et supprimer des immeubles dans notre base de données.

    ImmeubleGUI est une classe Graphical User Interface qui gère l'interface utilisateur pour les immeubles. Elle récupère une liste de tous les immeubles, met à jour le pourcentage de chaque immeuble qui est loué, puis génère une représentation HTML de ces immeubles à l'aide de FreeMarker.

    ImmeubleCore est une classe de service qui contient la logique métier pour les immeubles. Elle utilise ImmeubleDAO pour effectuer des opérations de base de données. Voici les méthodes qu'elle fournit :

        getAllImmeuble() : Récupère tous les immeubles de la base de données.
        createImmeuble(ImmeubleEntity immeuble) : Crée un nouvel immeuble dans la base de données.
        deleteImmeuble(ImmeubleEntity immeuble) : Supprime un immeuble de la base de données.
        ChangePourcentageEstLoue(String adresse, double pourcentage) : Met à jour le pourcentage d'un immeuble qui est loué.




Les quatre classes AppartementEntity, AppartementDAO, AppartementGUI et AppartementCore travaillent ensemble pour gérer les appartements dans notre application.

    AppartementEntity est une classe d'entité qui représente un appartement dans notre application. Elle contient des attributs tels que l'adresse de l'appartement, le nom du locataire, le loyer, etc.

    AppartementDAO est une classe Data Access Object qui gère la persistance des données pour les appartements. Elle contient des méthodes pour créer, lire, mettre à jour et supprimer des appartements dans notre base de données.

    AppartementGUI est une classe Graphical User Interface qui gère l'interface utilisateur pour les appartements. Elle récupère une liste de tous les appartements, puis génère une représentation HTML de ces appartements à l'aide de FreeMarker. De plus, elle fournit une méthode pour obtenir un appartement spécifique en fonction de son adresse.

    AppartementCore est une classe de service qui contient la logique métier pour les appartements. Elle utilise AppartementDAO pour effectuer des opérations de base de données. Voici les méthodes qu'elle fournit :

        getAllAppartement() : Récupère tous les appartements de la base de données.
        createAppartement(AppartementEntity appartement) : Crée un nouvel appartement dans la base de données.
        deleteAppartement(AppartementEntity appartement) : Supprime un appartement de la base de données.
        getAppartement(String adresse) : Récupère un appartement spécifique en fonction de son adresse.



les quatre classes UserEntity, UserDAO, UserGUI et UserCore servent à gérer les utilisateurs.

    UserEntity est une classe d'entité qui représente un utilisateur dans notre application. Elle contient des attributs tels que le prénom (firstName), le nom (lastName) et l'identifiant (id) de l'utilisateur.

    UserDAO serait une classe Data Access Object qui gère la persistance des données pour les utilisateurs. Elle contiendrait des méthodes pour créer, lire, mettre à jour et supprimer des utilisateurs dans notre base de données.

    UserGUI serait une classe Graphical User Interface qui gère l'interface utilisateur pour les utilisateurs. Elle récupérerait une liste de tous les utilisateurs, puis générerait une représentation HTML de ces utilisateurs à l'aide de FreeMarker. De plus, elle fournirait une méthode pour obtenir un utilisateur spécifique en fonction de son identifiant.

    UserCore serait une classe de service qui contient la logique métier pour les utilisateurs. Elle utiliserait UserDAO pour effectuer des opérations de base de données. Voici les méthodes qu'elle fournirait :

        getAllUser() : Récupère tous les utilisateurs de la base de données.
        createUser(UserEntity user) : Crée un nouvel utilisateur dans la base de données.
        deleteUser(UserEntity user) : Supprime un utilisateur de la base de données.
        getUser(int id) : Récupère un utilisateur spécifique en fonction de son identifiant.



les quatre classes PersonneEntity, PersonneDAO, PersonneGUI et PersonneCore gèrent les personnes.

    PersonneEntity est une classe d'entité qui représente une personne dans notre application. Elle contient des attributs tels que le téléphone (Telephone), le statut de propriétaire (Proprietaire) et l'appartement associé (Appartement). Elle fournit des getters et des setters pour ces attributs, ainsi que pour l'adresse, l'étage et le numéro de l'appartement.

    PersonneDAO serait une classe Data Access Object qui gère la persistance des données pour les personnes. Elle contiendrait des méthodes pour créer, lire, mettre à jour et supprimer des personnes dans notre base de données.

    PersonneGUI serait une classe Graphical User Interface qui gère l'interface utilisateur pour les personnes. Elle récupérerait une liste de toutes les personnes, puis générerait une représentation HTML de ces personnes à l'aide de FreeMarker. De plus, elle fournirait une méthode pour obtenir une personne spécifique en fonction de son identifiant.

    PersonneCore serait une classe de service qui contient la logique métier pour les personnes. Elle utiliserait PersonneDAO pour effectuer des opérations de base de données. Voici les méthodes qu'elle fournirait :

        getAllPersonne() : Récupère toutes les personnes de la base de données.
        createPersonne(PersonneEntity personne) : Crée une nouvelle personne dans la base de données.
        deletePersonne(PersonneEntity personne) : Supprime une personne de la base de données.
        getPersonne(int id) : Récupère une personne spécifique en fonction de son identifiant.


les trois classes SyndicatEntity, SyndicatDAO et SyndicatGUI travaillent ensemble pour gérer les syndicats.

    SyndicatEntity est une classe d'entité qui représente un syndicat dans notre application. Elle contient des attributs tels que le nom du syndicat, l'adresse du syndicat, etc.

    SyndicatDAO serait une classe Data Access Object qui gère la persistance des données pour les syndicats. Elle contiendrait des méthodes pour créer, lire, mettre à jour et supprimer des syndicats dans notre base de données.

    SyndicatGUI est une classe Graphical User Interface qui gère l'interface utilisateur pour les syndicats. Elle récupère une liste de tous les syndicats à l'aide de la méthode getAllSyndicat() de SyndicatCore, puis génère une représentation HTML de ces syndicats à l'aide de FreeMarker. De plus, elle fournit une méthode pour obtenir un syndicat spécifique en fonction de son nom.

        getAllSyndicat() : Récupère tous les syndicats de la base de données.
        createSyndicat(SyndicatEntity syndicat) : Crée un nouveau syndicat dans la base de données.
        deleteSyndicat(SyndicatEntity syndicat) : Supprime un syndicat de la base de données.
        getSyndicat(String nom) : Récupère un syndicat spécifique en fonction de son nom.


les classes SignInGUI et LoginGUI sont utilisées l'authentification des utilisateurs.

SignInGUI est une classe qui gère l'interface utilisateur pour l'inscription des utilisateurs. Elle utilise FreeMarker pour générer une représentation HTML du formulaire d'inscription.

LoginGUI est une classe qui gère l'interface utilisateur pour la connexion des utilisateurs. Elle utilise FreeMarker pour générer une représentation HTML du formulaire de connexion. 

(j'ai pas jugé nécessaire de rajouter les ftl s'il y a des choses a rajouter envoie en message je le ferait des que je peux)
