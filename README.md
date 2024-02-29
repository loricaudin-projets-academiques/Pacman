# Qdev_TP1_mvn

L'idée de ce TP est de vous lancer sur l'utilisation de Maven dans un premier temps. Puis dans un second temps, 
d'utiliser l'intégration continue sur la forge. 
Une petite base de code vous est fournie et vous allez devoir appliquer quelques éléments vus en Qdev S2 et S3 sur ce 
code. 
Ce TP est une introduction au projet de cette UE. Vous risquez d'avoir des difficultés plus tard si vous ne le réalisez 
pas correctement.

## Setup 

Ce TP a été testé sous Unix (macos et ubuntu) avec l'IDE IntelliJ ET les lignes de commande. Il est néanmoins possible de le réaliser sous windows. Il est encore 
temps de faire un double boot sur vos machines persos...

Java et Maven installés sur votre machine
```sh
java --version
mvn --version
```
Si ce n'est pas le cas, sous ubuntu, faire :
```sh
apt install maven
```
## Sujet

1. Commencez par faire un fork de ce dépot (vous pouvez utiliser la fonctionnalité disponible sur la forge directement 
ou par ligne de commande). Votre dépot doit être privé (un malus sera donné à votre classe entière si votre dépot est 
en public). Ajoutez moi (theo.rabut) en tant que reporter. 
2. Je vous ai fourni un morceau de code. Ce projet utilise maven pour la compilation.
Vous pouvez compiler le projet en utilisant la commande :
```sh
mvn compile
```
ou pour executer :
```sh
mvn exec:java
```
Chargez ce projet dans votre IDE préféré. La plupart intégrent directement les fonctionnalités de Maven.

3. Après un 
```sh
git status
```
vous pouvez voir que certains fichiers (de votre IDE, de Maven, de votre OS, etc.) n'ont aucun interêt à être sur la 
forge. Certains fichiers sont spécifiques à votre environnement. Il deviendrait problèmatique de versionner ces fichiers
avec vos collègues. 

Commencez par créer une issue sur la forge "ignorer le répertoire target et les fichiers des IDE”.

Créez donc un .gitignore pour ignorer certains fichiers. Vous pouvez ajouter ces lignes :

```gitignore
# Ignore les fichiers de configurations de VS code
.vscode/

# Ignore les fichiers de configuration d'Eclipse
.classpath
.project
.settings/

# Ignore les fichiers de configuration d'Intellij
.idea/
*.iml
*.iws

# Ignore les fichiers produits par Maven pour ne versionner que le code,
# pas les executables ou les logs.
log/
target/
```
4. Vous pouvez donc envoyer ces modifs sur votre répo de la forge. 

```sh
git status
```

n’affiche à présent plus les fichiers dans `target/`, mais affiche le
fichier `.gitignore`. Ajoutez ce fichier dans les fichiers versionnés :

```sh
git add .gitignore
```

puis valider en indiquant `fixes \#1` dans le message de commit (en remplaçant
`1` par le vrai numéro de l'issue si besoin) :

```sh
git commit -m "Gestion des fichier à ignorer (fixes #1)"
```

puis faire le push

```sh
git push
```
5. Essayez de comprendre ce que fait le code et de jouer avec en utilisant une autre image par exemple. 
6. Vous pouvez aller voir sur la forge l'onglet "build" puis "pipelines". Une intégration continue a été mis en place. 
Cette intégration continue est décrite par le fichier .gitlab-ci.yml. Il y a un lien fort entre ce dernier fichier et 
le pom.xml. 

Lisez les messages d'erreurs et corrigez votre code en conséquence. 
7. Faites une interface graphique en utilisant Javafx pour afficher l'image.
8. Réflechissez à l'architecture du code. Vous pouvez vous poser les questions suivantes (entre autres):
   - Est-ce qu'il est facile de modifier certaines fonctionnalités sans créer d'autres bug ? 
   - Si vous deviez afficher dans l'interface graphique l'image en version texte, est-ce que vous pourriez sans
   dupliquer du code ?
   - Est-ce que les principes SOLID sont respectés ? 
9. Proposez donc une architecture et ecrivez des tests pour la partie "model" de votre code.
10. Vous pouvez testez votre code avec maven en local avec la commande 
```sh
mvn test
```
11. Maven peut générer un site web pour votre projet, qui inclue les informations de
    base (nom, version, etc) et les dépendances en fonction du contenu du `pom.xml`.
    Le `pom.xml` fourni active également JavaDoc, la documentation d'API de votre
    projet sera donc visible dans une section « Project reports » du site web.

Pour lancer la génération du site, faites simplement :

```sh
mvn site
```

Le site est visible en local dans `target/site/`

