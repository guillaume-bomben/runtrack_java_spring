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
    -Annotations sur le bean : on ajoute des annotations de validation (comme @NotBlank, @Size, @Min, etc.) sur les attributs de votre bean.
    -@Valid et BindingResult dans le contrôleur : Dans la méthode du contrôleur qui reçoit le formulaire, on utilise l'annotation @Valid sur l'objet, accompagnée d'un objet BindingResult afin de capturer d'éventuelles erreurs.
    - Affichage des erreurs dans la vue : Avec Thymeleaf, on peux utiliser l'attribut th:errors pour afficher les messages d'erreur associés à chaque champ :
