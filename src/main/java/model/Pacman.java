package model;

import java.util.ArrayList;

/**
 * Classe Pacman qui contient la position de Pacman
 * et qui implémente la logique de mouvement.
 */
public class Pacman extends Character {

    /**
     * @param freeBoxes
     */
    public Pacman(final ArrayList<Integer[]> freeBoxes) {
        super(freeBoxes);

        this.setIcon(getImageIcon("src/main/ressources/pacman.png"));
    }
}
