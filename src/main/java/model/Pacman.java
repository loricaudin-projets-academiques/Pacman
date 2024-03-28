package model;

/**
 * Classe Pacman qui contient la position de Pacman
 * et qui implémente la logique de mouvement
 */
public class Pacman {
    public int direction = 0;
    public int pacmanX;
    public int pacmanY;

    /**
     * Constructeur pour la classe Pacman
     * @param x0
     * @param y0
     */

    public Pacman(final int x0,final int y0){
        pacmanX = x0;
        pacmanY = y0;
    }

    public int getDirection() {
        return direction;
    }

    /**
     * Méthode pour le mouvement de pacman en fonction
     * de la direction
     */

    public void move() {
        if (direction == 0) pacmanX++;
        if (direction == 1) pacmanY++;
        if (direction == 2) pacmanX--;
        if (direction == 3) pacmanY--;

    }

    /**
     * Setter pour la direction
     * @param direction
     */

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
