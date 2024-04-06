package model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Image;

/**
 * Classe Pacman qui contient la position de Pacman
 * et qui implémente la logique de mouvement.
 */
public class Pacman extends JLabel {

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
        super("");
        this.setIcon(getImagePacMan());
        pacmanX = x0;
        pacmanY = y0;

        updatePosition();
        this.setBackground(Color.gray);
    }

    private ImageIcon getImagePacMan() {
        ImageIcon imagePacman = new ImageIcon("src/main/ressources/pacman.png");
        Image imagePacmanEdit = imagePacman.getImage();
        imagePacmanEdit = imagePacmanEdit.getScaledInstance(
            50,
            50,
            Image.SCALE_SMOOTH
        );
        imagePacman = new ImageIcon(imagePacmanEdit);
        return imagePacman;
    }

    private void updatePosition() {
        this.setBounds(pacmanX + 5, pacmanY + 5, 50, 50);
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
        updatePosition();
    }

    /**
     * Setter pour la direction.
     * @param direction
     */
    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

}
