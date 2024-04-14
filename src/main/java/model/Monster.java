package model;

import java.util.ArrayList;

/**
 * Classe Monster qui contient la position du monstre
 * et qui le déplace aléatoirement.
 */
public class Monster extends Character {

    /**
     * Constructeur du monstre.
     * @param freeBoxes
     */
    public Monster(final ArrayList<Integer[]> freeBoxes, String gifFileName) {
        super(freeBoxes, gifFileName);

        this.setDirection(this.getDirection());
    }

    /**
     * Méthode pour le mouvement du monstre en fonction
     * de la direction.
     */
    public void move() {
        ArrayList<Direction> possibleDirections = checkPossibleDirections();

        //if (!possibleDirections.contains(this.getDirection())) {
        if (possibleDirections.size() > 2 || !possibleDirections.contains(this.getDirection())) {
            int indexStartDirection = (int) (Math.random() * ((possibleDirections.size())));
            this.setDirection(possibleDirections.get(indexStartDirection));
        }

        int afstand = 5;
        switch (this.getDirection()) {
            case UP:
                setCharacterY(this.getCharacterY() - afstand);
                break;
            case DOWN:
                setCharacterY(this.getCharacterY() + afstand);
                break;
            case LEFT:
                setCharacterX(this.getCharacterX() - afstand);
                break;
            case RIGHT:
                setCharacterX(this.getCharacterX() + afstand);
                break;
            default:
                break;
        }
        this.notifyObservers();
    }
}
