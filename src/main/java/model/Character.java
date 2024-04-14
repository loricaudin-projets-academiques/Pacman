package model;

import java.util.ArrayList;

/**
 * Classe représentant les différents personnages du jeu.
 */
public class Character extends Observable {
    /**
     * Énumération des directions possibles du personnage.
     */
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private Direction direction;
    private int characterX;
    private int characterY;
    private ArrayList<Integer[]> freeBoxes;

    private String filename;

    /**
     * Constructeur pour la classe Pacman.
     * @param freeBoxes
     * @param filename
     */
    public Character(final ArrayList<Integer[]> freeBoxes, final String filename) {
        super();
        this.filename = filename;
        this.freeBoxes = freeBoxes;

        // Position de départ
        int indexStart = (int) (Math.random() * ((this.freeBoxes.size())));
        this.characterX = freeBoxes.get(indexStart)[0];
        this.characterY = freeBoxes.get(indexStart)[1];

        // Direction de départ
        ArrayList<Direction> possibleDirections = checkPossibleDirections();
        int indexStartDirection = (int) (Math.random() * ((possibleDirections.size())));
        this.direction = possibleDirections.get(indexStartDirection);

        this.notifyObservers();
    }
    
    /**
     * Récupérer la coordonnée x.
     * @return characterX
     */
    public int getCharacterX() {
        return characterX;
    }
    /**
     * Récupérer la coordonnée y.
     * @return characterY
     */
    public int getCharacterY() {
        return characterY;
    }
    /**
     * Changer la coordonnée x.
     * @param characterX
     */
    public void setCharacterX(final int characterX) {
        this.characterX = characterX;
    }
    /**
     * Changer la coordonnée y.
     * @param characterY
     */
    public void setCharacterY(final int characterY) {
        this.characterY = characterY;
    }

    /**
     * Récupérer la direction.
     * @return Direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Récupérer le lien vers l'image du personnage.
     * @return String
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Changer le lien vers l'image du personnage.
     * @param filename
     */
    public void setFilename(final String filename) {
        this.filename = filename;
    }

    /**
     * Setter pour la direction.
     * @param direction
     */
    public void setDirection(final Direction direction) {
        this.direction = direction;
    }


    /**
     * Vérifier les directions possibles selon la position du personnage dans le labyrinthe.
     * @return liste des directions possibles
     */
    public ArrayList<Direction> checkPossibleDirections() {
        ArrayList<Direction> listDirections = new ArrayList<Direction>();
        if (characterX % 50 == 0 && characterY % 50 == 0) {
            for (int ii = 0; ii < this.freeBoxes.size(); ii++) {
                Integer[] zone = this.freeBoxes.get(ii);
                // Vérifier si on peut aller en haut
                if (characterX == zone[0] && characterY - 50 == zone[1]) {
                    listDirections.add(Direction.UP);
                }
                // Vérifier si on peut aller en bas
                if (characterX == zone[0] && characterY + 50 == zone[1]) {
                    listDirections.add(Direction.DOWN);
                }
                // Vérifier si on peut aller à gauche
                if (characterX - 50 == zone[0] && characterY == zone[1]) {
                    listDirections.add(Direction.LEFT);
                }
                // Vérifier si on peut aller à droite
                if (characterX + 50 == zone[0] && characterY == zone[1]) {
                    listDirections.add(Direction.RIGHT);
                }
            }
        } else {
            listDirections.add(this.direction);
            if (this.direction == Direction.DOWN) {
                listDirections.add(Direction.UP);
            }
            // Vérifier si on peut aller en bas
            if (this.direction == Direction.UP) {
                listDirections.add(Direction.DOWN);
            }
            // Vérifier si on peut aller à gauche
            if (this.direction == Direction.RIGHT) {
                listDirections.add(Direction.LEFT);
            }
            // Vérifier si on peut aller à droite
            if (this.direction == Direction.LEFT) {
                listDirections.add(Direction.RIGHT);
            }
        }

        return listDirections;
    }
}
