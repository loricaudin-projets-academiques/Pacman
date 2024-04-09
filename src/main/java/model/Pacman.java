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
        super(freeBoxes, "/PacmanGifs/RightSidePacman.gif");

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
            this.setFilename("/PacmanGifs/BottomSidePacman.gif");
        }
        // Vérifier si on peut aller en bas
        if (this.getDirection() == Direction.UP) {
            this.setFilename("/PacmanGifs/UpSidePacman.gif");
        }
        // Vérifier si on peut aller à gauche
        if (this.getDirection() == Direction.LEFT) {
            this.setFilename("/PacmanGifs/LeftSidePacman.gif");
        }
        // Vérifier si on peut aller à droite
        if (this.getDirection() == Direction.RIGHT) {
            this.setFilename("/PacmanGifs/RightSidePacman.gif");
        }
    }
}
