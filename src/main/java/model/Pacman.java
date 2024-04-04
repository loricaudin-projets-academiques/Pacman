package model;

/**
 * Classe Pacman qui contient la position de Pacman
 * et qui implémente la logique de mouvement.
 */
public class Pacman {
    private int direction = 0;
    private int pacmanX;
    private int pacmanY;

    /**
     * Constructeur pour la classe Pacman.
     * @param x0
     * @param y0
     */

    public Pacman(final int x0, final int y0) {
        pacmanX = x0;
        pacmanY = y0;
    }

    /**
     * Getter pour la direction.
     * @return la position actuel de pacman
     */

    public int getDirection() {
        return direction;
    }

    /**
     * Méthode pour le mouvement de pacman en fonction
     * de la direction.
     */

    public void move() {
        if (getDirection() == 0) {
            pacmanX++;
        } else if (direction == 1) {
            pacmanY++;
        } else if (direction == 2) {
            pacmanX--;
        } else if (direction == 3) {
            pacmanY--;
        }

    }

    /**
     * Setter pour la direction.
     * @param direction
     */

    public void setDirection(final int direction) {
        this.direction = direction;
    }

}
