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

        this.setDirection(this.direction);

        this.setIcon(getImageIcon());
    }

    /**
     * Setter pour la direction.
     * @param direction
     */
    public void setDirection(final Direction direction) {
        this.direction = direction;

        if (this.direction == Direction.DOWN) {
            this.filename = "src/main/ressources/pacman/pacman_bottom.png";
        }
        // Vérifier si on peut aller en bas
        if (this.direction == Direction.UP) {
            this.filename = "src/main/ressources/pacman/pacman_top.png";
        }
        // Vérifier si on peut aller à gauche
        if (this.direction == Direction.LEFT) {
            this.filename = "src/main/ressources/pacman/pacman_left.png";
        }
        // Vérifier si on peut aller à droite
        if (this.direction == Direction.RIGHT) {
            this.filename = "src/main/ressources/pacman/pacman_right.png";
        }
    }
}
