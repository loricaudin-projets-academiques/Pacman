# <img src="./src/main/resources/pacman/pacman.png" width="32px"> Pacman

Pacman est un jeu réalisé par Loric Audin, Elven Doher, David Douangmarath et Camille Morfin.
Il consiste à manger tous les pac-gommes présents dans le labyrinthe sans se faire toucher par les monstres.

## Comment on joue à Pacman ?
Pacman avance tout seul dans l'écran jusqu'à ce qu'il rencontre un mur.
À l'aide des flèches du clavier, vous pouvez changer la direction de Pacman.
Essayez de récolter tous les pac-gommes du labyrinthe, sans vous faire toucher par les monstres.

## Fonctionnalités réalisées
- Importation d'une matrice à partir d'un fichier représentant un labyrinthe
- Choix du niveau parmi les fichiers stockés dans l'application contenant des labyrinthes différents
- Affichage du temps et du nombre de Pac-gommes mangés
- Ajout d'une petite musique au démarrage d'une partie
- Animation mouvement du Pacman
- Ajout de la nourriture
- Choix du nombre de monstres (entre 0 et 5)

## Designs Patterns utilisé
- MVC (séparation des Modèles, des Vues et des Contrôleurs)
- Observer et Observable