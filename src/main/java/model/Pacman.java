package model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

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
    private ArrayList<Integer[]> freeBoxes;

    /**
     * Constructeur pour la classe Pacman.
     * @param freeBoxes
     */
    public Pacman(final ArrayList<Integer[]> freeBoxes) {
        super("");
        this.setIcon(getImagePacMan());

        this.freeBoxes = freeBoxes;

        // Position de départ
        int indexStart = (int) (Math.random() * ((this.freeBoxes.size())));
        this.pacmanX = freeBoxes.get(indexStart)[0];
        this.pacmanY = freeBoxes.get(indexStart)[1];

        // Direction de départ
        ArrayList<Direction> possibleDirections = checkPossibleDirections();
        int indexStartDirection = (int) (Math.random() * ((possibleDirections.size())));
        this.direction = possibleDirections.get(indexStartDirection);

        updatePosition();
        this.setBackground(Color.gray);
    }

    /**
     * 
     */
    public ImageIcon getImagePacMan() {
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
    /**
     * @return pacmanX
     */
    public int getPacmanX() {
        return pacmanX;
    }
    /**
     * @return pacmanY
     */
    public int getPacmanY() {
        return pacmanY;
    }
    /**
     * @param pacmanX
     */
    public void setPacmanX(final int pacmanX) {
        this.pacmanX = pacmanX;
    }
    /**
     * @param pacmanY
     */
    public void setPacmanY(final int pacmanY) {
        this.pacmanY = pacmanY;
    }

    /**
     * 
     */
    private void updatePosition() {
        this.setBounds(pacmanX + 5, pacmanY + 5, 50, 50);
    }


    /**
     * Méthode pour le mouvement de pacman en fonction
     * de la direction.
     */
    public void move() {
        int afstand = 50;
        switch (direction) {
            case UP:
                pacmanY -= afstand;
                break;
            case DOWN:
                pacmanY += afstand;
                break;
            case LEFT:
                pacmanX -= afstand;
                break;
            case RIGHT:
                pacmanX += afstand;
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

    /**
     * 
     */
    public ArrayList<Direction> checkPossibleDirections() {
        ArrayList<Direction> listDirections = new ArrayList<Direction>();
        if (pacmanX % 50 == 0 && pacmanY % 50 == 0) {
            for (int ii = 0; ii < this.freeBoxes.size(); ii++) {
                Integer[] zone = this.freeBoxes.get(ii);
                // Vérifier si on peut aller en haut
                if (pacmanX == zone[0] && pacmanY - 50 == zone[1] && direction != Direction.DOWN) {
                    listDirections.add(Direction.UP);
                }
                // Vérifier si on peut aller en bas
                if (pacmanX == zone[0] && pacmanY + 50 == zone[1] && direction != Direction.UP) {
                    listDirections.add(Direction.DOWN);
                }
                // Vérifier si on peut aller à gauche
                if (pacmanX - 50 == zone[0] && pacmanY == zone[1] && direction != Direction.RIGHT) {
                    listDirections.add(Direction.LEFT);
                }
                // Vérifier si on peut aller à droite
                if (pacmanX + 50 == zone[0] && pacmanY == zone[1] && direction != Direction.LEFT) {
                    listDirections.add(Direction.RIGHT);
                }
            }
        } else {
            listDirections.add(this.direction);
        }

        return listDirections;
    }

}
