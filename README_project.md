# Mini-Projet Qualité de développement

## Setup

L'un de vous peut commencer par créer un dépôt git et :
- Ajouter toutes les personnes du groupe.
- M'ajouter en tant que reporter
- Bien mettre le dépôt en privée.

Puis :
- Récupérer chacun une copie de travail.
- Après validation avec votre encadrant, copier les fichiers nécessaires pour
le départ de votre projet :
  - pom.xml
  - .gitlab-ci.yml
  - Fichiers sources si projet antérieur.

## Objectifs
L'idée de ce miniprojet est de pratiquer tout ce que vous avez vu depuis le début
de qualitédev.
L'objectif principal est d'avoir un code propre, fonctionnel, testé en
permanence sur votre branche principale. Vous allez devoir vous organiser pour
produire ce code rapidement. Certains éléments vous sont demandé (design pattern
et test notamment), leurs développements peut-être long, organisez-vous !


## Eléments de notation

- MVC
- Design PatternS
- Git :
  - Utilisation correcte des branches (rien ne sert de vouloir trop
    en faire !!!).
  - Merge request pour des gros changements.
  - Ticketing (Issues sur la forge)
- Tests automatisés (jUnit + maven)
- Intégration continue
- Checkstyle
- Javadoc

Une présentation est prévue pour la dernière session. Vous allez devoir me faire une
démo, me parler de votre architecture (MVC/Patterns), me dire comment vous vous
êtes organisés (barème TBA), prenez le temps de faire de la veille techno.
Quelques points seront données si vous m'apprenez quelque chose en lien avec votre sujet.

L'autre partie de la note sera la plus automatique possible via maven. (barème TBA)

### MVC
Le MVC vous est imposé. Vous pouvez utiliser une variante si le besoin est la.

### Interfaces graphiques
Vous pouvez commencer par une vue texte simplifié (pratique pour les tests !!).
Dans un second temps, passez par une interface graphique via swing ou javafx (ou
autre). 

### Design Pattern
Le patron de conception le plus couramment utilisé dans ce type de projet est
l'observer. En fonction des projets, ce pattern peut varier, pas de panique.
Si vous pouvez justifier vos choix de conception il n'y a pas de soucis.

### Test
Normalement vous êtes tous à jours sur l'utilisation de jUnit.
Une couverture de code minimale vous sera demandé (TBA).

### BDD ou TDD
Produire l'intégralité de votre code en TDD peut être fastidieux mais faisable.
Il faut vous dire que la partie metier de votre code doit être testé, donc
partir sur du TDD pour cette partie peut-être la meilleure solution.

### Intégration continue
L'intégration continue est setup pour lancer les tests automatisés avec le
fichier .gitlab-ci.yml. Si vous avez besoin de plus, il est possible de rajouter
 d'autres commandes, d'autres scripts.



## Sujet
Plusieurs directions sont possibles. La première étant de continuer le TP1 en
rajoutant des fonctionnalités. On pourra en discuter.
Vous pouvez choisir un autre sujet ou reprendre un projet. Gardez tout de même à
l'idée que ce sujet doit être accessible et doit plaire à vos collègues.
Voila quelques exemples possible :
- ChatBot via librairies/API
- Mini jeux (type chess board, bricks, solitaire, etc.). Quelque chose de simple
que vous pourrez améliorer petit à petit.
- Visualisation de données via API (il existe beaucoup d'API publiques).

Ne vous faites pas prendre par le temps. Votre note ni basée sur
l'originalité de votre projet ni sur la quantité de code produit mais plutôt sur
la qualité de développement et
d'organisation dont vous allez faire preuve pour pouvoir travailler à 4
proprement.
