# runtrack_java_spring

Pour lancez le projet sur VScode allez ouvrez le terminal et deplacez vous dans le dossier contenant mvnw.cmd puis lancez la commande `.\mvnw.cmd spring-boot:run`

## Reponse Question Jour 1 :

- job01 :
    Spring Initializr est un site qui permet de générer rapidement la structure initiale d'un projet spring boot en choisisan sa version de spring boot ,de Java et si on veux utiliiser maeven ou gradle. Cela marche aussie pour un projet kotlin.

- job02 :
    Le fichier pom.xml est crucial dans un projet Maven car il permet de gerer les dépendances (bibliothèque et framework), les plugins et les information du projet (Le groupe, l'artifact, la version ...)

- job03 :
    Dans Spring MVC, un contrôleur est une classe qui reçoit les requêtes HTTP, les traite et renvoie les réponses appropriées. Typiquement annotée avec @Controller ou @RestController, elle mappe des endpoints (à l'aide d'annotations comme @GetMapping, @PostMapping, etc.) aux méthodes qui contiennent la logique de traitement. Le contrôleur fait souvent appel à d'autres composants (services, repositories) pour réaliser son traitement et prépare le modèle de données à retourner à l'utilisateur.

- job04 :
    Spring injecte des propriétés depuis les fichiers de configuration (comme application.properties ou application.yml) en lisant ces fichiers lors du démarrage de l'application. Si on a une seule propriété on utilise l'annotation @Value("${property.key}").
    Ces mécanismes permettent à Spring de centraliser et de gérer la configuration de l'application de manière flexible et dynamique.

- job05 :
    Avoir différents profils dans une application Spring permet d'adapter la configuration en fonction de l'environnement d'exécution (développement, test, production, etc.). Cela permet de définir des propriétés spécifiques (base de données, endpoints, logs) pour chaque contexte, de ne charger que les beans pertinents à un environnement donné et de simplifier le déploiement en évitant de modifier manuellement la configuration lors du passage d'un environnement à un autre.

- job06 :
    Lors de l'exécution de l'application en mode développement, DevTools surveille les modifications sur le classpath et redémarre automatiquement l'application. On peux ainsi modifier notre code (par exemple, changer le message dans HelloController ou dans application.yml) et observer que le changement est pris en compte sans redémarrage manuel complet de l'application.

## Reponse Question Jour 2 :

- job01 :
    Le modèle MVC structure une application web en séparant clairement les responsabilités :
    - Modèle (Model) : Gère les données et la logique métier.
    - Vue (View) : S'occupe de l'affichage et de l'interface utilisateur.
    - Contrôleur (Controller) : Interprète les requêtes de l'utilisateur, interagit avec le modèle et choisit la vue à afficher.

    Cette séparation facilite la maintenance, le développement et les tests en rendant le code plus modulaire et réutilisable.

- job02 :
    Thymeleaf est un moteur de templates qui permet d'intégrer des expressions et des fragments de logique directement dans des fichiers HTML tout en restant valide en tant que HTML. Les differences principales sont le Dynamisme intégré ( Thymeleaf permet d'insérer des données dynamiques via des attributsdirectement dans le code HTML, sans nécessiter de transformation externe ) , Edition simplifiée ( Les templates Thymeleaf sont des fichiers HTML valides, ce qui facilite le prototypage et la modification avec des outils graphiques ).

- job03 :
    Dans Spring, on peux transmettre des données d'un contrôleur à une vue en utilisant le modèle. Par exemple, on peux ajouter des attributs au modèle via l'interface Model.

- job04 :
    Spring facilite la gestion des formulaires en fournissant :
    - Data Binding Automatique : Les données du formulaire sont automatiquement liées à un objet Java (par exemple, via l'annotation @ModelAttribute).
    - Validation Intégrée : Avec l’annotation @Valid (ou @Validated) et une implementation de Bean Validation (ex : Hibernate Validator), Spring permet de valider les entrées du formulaire et d’afficher dynamiquement des messages d’erreur via BindingResult.
    - Gestion des Erreurs : En combinant BindingResult et des utilitaires Thymeleaf (comme th:errors), il est simple d’afficher les messages d’erreur directement dans la vue.
    Configuration Simplifiée : Spring MVC centralise la configuration des formulaires et fournit des convertisseurs pour manipuler les données envoyées par le formulaire.

- job05 :
    Spring intègre la validation des données du formulaire en s'appuyant sur l'API Bean Validation (comme Hibernate Validator). Voici comment cela fonctionne :
    - Annotations sur le bean : on ajoute des annotations de validation (comme @NotBlank, @Size, @Min, etc.) sur les attributs de votre bean.
    - @Valid et BindingResult dans le contrôleur : Dans la méthode du contrôleur qui reçoit le formulaire, on utilise l'annotation @Valid sur l'objet, accompagnée d'un objet BindingResult afin de capturer d'éventuelles erreurs.
    - Affichage des erreurs dans la vue : Avec Thymeleaf, on peux utiliser l'attribut th:errors pour afficher les messages d'erreur associés à chaque champ

## Reponse Question Jour 3 :

- job01 :
    JPA (Java Persistence API) est une spécification Java qui standardise l'ORM (Object-Relational Mapping) pour transformer les données des bases relationnelles en objets Java. Elle permet d'éviter d'écrire du SQL directement en utilisant des annotations sur les entités pour définir le mapping avec les tables, de simplifier le CRUD.

- job02 :
    Les bases de données en mémoire, comme H2, sont utiles pendant le développement car elles offrent :

    - Installation Simplifiée : Aucune configuration ou installation de serveur externe n'est nécessaire.
    - Performance Optimale : Elles sont extrêmement rapides pour tester et itérer.
    - Éphémérité : Les données sont volatiles, permettant de repartir d'un état vierge à chaque démarrage.
    - Simplicité de Test : Idéal pour réaliser des tests d'intégration sans affecter une base de données de production.

    Ces avantages facilitent et accélèrent le processus de développement et de test.

- job03 :
    Les annotations comme @Entity indiquent à JPA que la classe annotée représente une entité persistante, c'est-à-dire une table dans la base de données.

- job04 :
    Grâce à la convention de nommage, Spring génère automatiquement l'implémentation des requêtes (par exemple, findByName, findByAgeGreaterThan) sans avoir besoin d'écrire du SQL manuellement. Il offre la possibilité d'utiliser des requêtes personnalisées via les annotations @Query ou en définissant des méthodes avec des critères complexes.

- job05 :
    Pour créer et lire des entités avec Spring Data JPA, on procédez ainsi :
    1. Définissez une classe d'entité annotée avec @Entity.
    2. Créez une interface de repository qui étend JpaRepository.
    3. Dans un contrôleur, utilisez les méthodes du repository pour créer une entité (avec save) ou lire des entités (avec findAll ou findById).

- job06 :
    Si l'entité à sauvegarder n'a pas d'identifiant (ou si l'id est null), elle sera considérée comme nouvelle et sera insérée dans la base de données. En revanche, si l'objet possède un identifiant existant, la méthode save procède à une fusion (merge) de l'entité et met à jour les champs correspondants dans la base de données.

## Reponse Question Jour 4 :

- job01 :
    Séparer la logique métier des contrôleurs présente plusieurs avantages :
    - Le contrôleur se charge uniquement de la gestion de la requête et de la navigation, tandis que la logique métier est isolée dans des services.
    - En isolant la logique métier, il est plus simple d'écrire des tests unitaires pour vérifier le comportement des services.
    - La logique métier encapsulée dans des services peut être utilisée par différents contrôleurs ou d’autres composants, évitant ainsi la duplication de code.

- job02 :
    Spring Security offre de nombreux avantages pour protéger une application, tels que :
    - Authentification et autorisation robustes : Il fournit des mécanismes configurables pour vérifier l'identité des utilisateurs et restreindre l'accès aux ressources en fonction de leurs rôles ou permissions.
    - Personnalisation aisée : Vous pouvez personnaliser la page de connexion, les règles d’accès par URL et définir des stratégies de gestion de sessions et de "remember-me" pour adapter la sécurité aux besoins spécifiques de votre application.
    - Protection intégrée contre les vulnérabilités : Spring Security inclut des protections contre les attaques courantes, comme le CSRF, les attaques par injection et autres vulnérabilités web.
    - Intégration avec divers systèmes d'authentification : Il permet l'intégration avec des services d'authentification externes (OAuth2, LDAP, etc.) et la gestion centralisée des utilisateurs.
    - Extensibilité et flexibilité : Grâce à ses filtres de sécurité et son modèle de configuration basé sur des beans, il est facile d'étendre ou d'adapter la sécurité à l'évolution des besoins de l'application.

- job03 :
    En Creant un Fichier Html pour la page de login.

- job04 :
    Spring Security gère les autorisations basées sur les rôles en associant à chaque utilisateur des rôles (par exemple, USER, ADMIN) et en comparant ces rôles aux règles d'accès définies dans la configuration de sécurité (via des méthodes comme hasRole ou hasAuthority). Lorsqu'une requête arrive, le filtre de sécurité vérifie si l'utilisateur authentifié possède le rôle requis pour accéder à la ressource, et autorise ou refuse l'accès en conséquence.

- job05 :
    Pour stocker les mots de passe de manière sécurisée, Spring Security recommande d'utiliser un encodeur de mots de passe, comme BCryptPasswordEncoder. Voici les points clés :
    - Utilisation d'un hachage sécurisé : BCrypt génère un hachage sécurisé avec un sel aléatoire intégré, ce qui rend l'attaque par rainbow tables pratiquement impossible.
    - Encodage avant stockage : Avant de sauvegarder le mot de passe en base, encodez-le avec BCrypt. Cela garantit que même si la base est compromise, les mots de passe restent illisibles.
    - Intégration via PasswordEncoder : Déclarez un bean PasswordEncoder et utilisez-le pour encoder les mots de passe lors de l'inscription.

## Reponse Question Jour 5 :

- job01 :
    Le principal avantage de Thymeleaf est qu'il permet de créer des templates HTML valides et « naturels ». Cela signifie que vous pouvez ouvrir les fichiers Thymeleaf directement dans un navigateur pour les visualiser comme des pages statiques. Cette approche facilite la collaboration entre développeurs et designers, car le code reste lisible et éditable avec des outils HTML standard, contrairement à JSP qui nécessite un environnement serveur pour être affiché correctement.

- job02 :
    Pour lier une liste d'objets à une vue Thymeleaf, on peux ajouter cette liste au modèle dans votre contrôleur, puis utiliser l'attribut dans le template avec l'attribut Thymeleaf th:each pour itérer sur les objets.

- job03 :
    Pour lier un objet à un formulaire Thymeleaf, on doit :
    1. Ajouter l'objet au modèle dans votre contrôleur.
    2. Utiliser l'attribut th:object dans la balise form du template.
    3. Utiliser th:field pour lier chaque champ du formulaire aux propriétés de l'objet.

- job04 :
    Thymeleaf utilise l'attribut th:errors en combinaison avec les macros de validation (comme #fields) pour afficher automatiquement les messages d'erreur associés aux champs du formulaire qui n'ont pas passé la validation.

- job05 :
    On peux accéder à l'utilisateur actuellement connecté via le dialecte Spring Security pour Thymeleaf.

- job06 :
    Spring Web Flow s'avère particulièrement utile dans les scénarios où on doit gérer des processus ou des chemins de navigation complexes au sein de votre application.

- job07 :
    Dans Spring Web Flow, les états représentent les différentes étapes du processus (affichage d'une vue, exécution d'une action, prise de décision, etc.) et les transitions déterminent le passage d'un état à un autre en réponse à un événement.

- job08 :
    Pour lier une vue Thymeleaf à une étape spécifique d'un flux Spring Web Flow, on déclare un view-state dans le fichier de définition du flux et spécifiez la vue (par exemple, le nom du template) via l'attribut view. Le view-resolver intégré se charge ensuite de résoudre le fichier Thymeleaf associé.

- job09 :
    Pour configurer une page d'erreur personnalisée avec Thymeleaf et Spring Boot, procédez comme suit :
    1. Créez un fichier Thymeleaf nommé « error.html » dans le dossier src/main/resources/templates. Ce fichier sera utilisé par défaut pour gérer les erreurs générales.
    2. (Optionnel) Pour définir des pages spécifiques à certains codes HTTP (comme 404 ou 500), créez des fichiers dans le sous-dossier « error » (ex. src/main/resources/templates/error/404.html).
    3. Désactivez la page blanche par défaut dans application.properties en ajoutant : `server.error.whitelabel.enabled=false`

- job10 :
    Pour inclure un fragment Thymeleaf, on peux utiliser l'attribut th:replace ou th:include. Par exemple :
    `<div th:replace="fragments/header :: header"></div>`
    Ici, Thymeleaf remplace cette div par le contenu du fragment nommé header défini dans le fichier header.html. on peux également utiliser th:include pour insérer le fragment sans remplacer l'élément parent.

- job11 :
    Dans un projet Spring Boot, les ressources statiques (CSS, JavaScript, images, etc.) doivent être placées dans le dossier src/main/resources/static (ou alternativement dans src/main/resources/public, src/main/resources/resources, ou META-INF/resources). Spring Boot se charge ensuite de les servir automatiquement depuis le chemin racine.

- job12 :
    Thymeleaf est un moteur de templates côté serveur et ne fournit pas nativement de mécanisme asynchrone. Cependant, vous pouvez combiner Thymeleaf avec des appels AJAX pour charger du contenu de manière asynchrone.