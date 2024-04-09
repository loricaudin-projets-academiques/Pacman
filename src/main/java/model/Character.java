package model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Image;

import java.util.ArrayList;

/**
 * 
 */
public class Character extends JLabel {
    /**
     * 
     */
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private Direction direction;
    private int characterX;
    private int characterY;
    private ArrayList<Integer[]> freeBoxes;

    private String filename;

    /**
     * Constructeur pour la classe Pacman.
     * 
     * @param freeBoxes
     */
    public Character(final ArrayList<Integer[]> freeBoxes, final String filename) {
        super("");
        this.filename = filename;

        this.freeBoxes = freeBoxes;

        // Position de départ
        int indexStart = (int) (Math.random() * ((this.freeBoxes.size())));
        this.characterX = freeBoxes.get(indexStart)[0];
        this.characterY = freeBoxes.get(indexStart)[1];

        // Direction de départ
        ArrayList<Direction> possibleDirections = checkPossibleDirections();
        int indexStartDirection = (int) (Math.random() * ((possibleDirections.size())));
        this.direction = possibleDirections.get(indexStartDirection);

        updatePosition();
    }

    /**
     * 
     * @return
     */
    public ImageIcon getImageIcon() {
        ImageIcon imageCharacter = new ImageIcon(this.filename);
        Image imageCharacterEdit = imageCharacter.getImage();
        imageCharacterEdit = imageCharacterEdit.getScaledInstance(
                50,
                50,
                Image.SCALE_SMOOTH);
        imageCharacter = new ImageIcon(imageCharacterEdit);
        return imageCharacter;
    }

    /**
     * @return characterX
     */
    public int getCharacterX() {
        return characterX;
    }

    /**
     * @return characterY
     */
    public int getCharacterY() {
        return characterY;
    }

    /**
     * @param characterX
     */
    public void setCharacterX(final int characterX) {
        this.characterX = characterX;
    }

    /**
     * @param characterY
     */
    public void setCharacterY(final int characterY) {
        this.characterY = characterY;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * 
     */
    private void updatePosition() {
        this.setBounds(characterX + 5, characterY + 5, 50, 50);
    }

    /**
     * Méthode pour le mouvement de pacman en fonction
     * de la direction.
     */
    public void move() {
        int afstand = 50;
        switch (direction) {
            case UP:
                characterY -= afstand;
                break;
            case DOWN:
                characterY += afstand;
                break;
            case LEFT:
                characterX -= afstand;
                break;
            case RIGHT:
                characterX += afstand;
                break;
            default:
                break;
        }
        updatePosition();
    }

    /**
     * Setter pour la direction.
     * 
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
        if (characterX % 50 == 0 && characterY % 50 == 0) {
            for (int ii = 0; ii < this.freeBoxes.size(); ii++) {
                Integer[] zone = this.freeBoxes.get(ii);
                // Vérifier si on peut aller en haut
                if (characterX == zone[0] && characterY - 50 == zone[1]) {
                    listDirections.add(Direction.UP);
                }
                // Vérifier si on peut aller en bas
                if (characterX == zone[0] && characterY + 50 == zone[1]) {
                    listDirections.add(Direction.DOWN);
                }
                // Vérifier si on peut aller à gauche
                if (characterX - 50 == zone[0] && characterY == zone[1]) {
                    listDirections.add(Direction.LEFT);
                }
                // Vérifier si on peut aller à droite
                if (characterX + 50 == zone[0] && characterY == zone[1]) {
                    listDirections.add(Direction.RIGHT);
                }
            }
        } else {
            listDirections.add(this.direction);
            if (this.direction == Direction.DOWN) {
                listDirections.add(Direction.UP);
            }
            // Vérifier si on peut aller en bas
            if (this.direction == Direction.UP) {
                listDirections.add(Direction.DOWN);
            }
            // Vérifier si on peut aller à gauche
            if (this.direction == Direction.RIGHT) {
                listDirections.add(Direction.LEFT);
            }
            // Vérifier si on peut aller à droite
            if (this.direction == Direction.LEFT) {
                listDirections.add(Direction.RIGHT);
            }
        }

        return listDirections;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Integer[]> getFreeBoxes() {
        return freeBoxes;
    }

    /**
     * 
     * @param freeBoxes
     */
    public void setFreeBoxes(final ArrayList<Integer[]> freeBoxes) {
        this.freeBoxes = freeBoxes;
    }

    /**
     * 
     * @return
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 
     * @param filename
     */
    public void setFilename(final String filename) {
        this.filename = filename;
    }
}
