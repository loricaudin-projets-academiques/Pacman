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
        super(freeBoxes, "src/main/ressources/pacman/pacman.png");

        this.setDirection(this.getDirection());

        this.setIcon(getImageIcon());
    }

    /**
     * Setter pour la direction.
     * @param direction
     */
    public void setDirection(final Direction direction) {
        super.setDirection(direction);

        if (this.getDirection() == Direction.DOWN) {
            this.setFilename("src/main/ressources/pacman/pacman_bottom.png");
        }
        // Vérifier si on peut aller en bas
        if (this.getDirection() == Direction.UP) {
            this.setFilename("src/main/ressources/pacman/pacman_top.png");
        }
        // Vérifier si on peut aller à gauche
        if (this.getDirection() == Direction.LEFT) {
            this.setFilename("src/main/ressources/pacman/pacman_left.png");
        }
        // Vérifier si on peut aller à droite
        if (this.getDirection() == Direction.RIGHT) {
            this.setFilename("src/main/ressources/pacman/pacman_right.png");
        }
    }
}
