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