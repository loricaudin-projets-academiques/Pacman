package model;

/**
 * Classe Pacman qui contient la position de Pacman
 * et qui implémente la logique de mouvement.
 */
public class Pacman {

    /**
     * 
     */
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private Direction direction;
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
     * Méthode pour le mouvement de pacman en fonction
     * de la direction.
     */
    public void move() {
        switch (direction) {
            case UP:
                pacmanY--;
                break;
            case DOWN:
                pacmanY++;
                break;
            case LEFT:
                pacmanX--;
                break;
            case RIGHT:
                pacmanX++;
                break;
            default:
                break;
        }
    }

    /**
     * Setter pour la direction.
     * @param direction
     */
    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

}
