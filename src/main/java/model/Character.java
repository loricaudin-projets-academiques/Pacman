package model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Image;

import java.util.ArrayList;

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

    /**
     * Constructeur pour la classe Pacman.
     * @param freeBoxes
     */
    public Character(final ArrayList<Integer[]> freeBoxes) {
        super("");
        

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

    public ImageIcon getImageIcon(String filename) {
        ImageIcon imageCharacter = new ImageIcon(filename);
        Image imageCharacterEdit = imageCharacter.getImage();
        imageCharacterEdit = imageCharacterEdit.getScaledInstance(
            50,
            50,
            Image.SCALE_SMOOTH
        );
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
                if (characterX == zone[0] && characterY - 50 == zone[1] && direction != Direction.DOWN) {
                    listDirections.add(Direction.UP);
                }
                // Vérifier si on peut aller en bas
                if (characterX == zone[0] && characterY + 50 == zone[1] && direction != Direction.UP) {
                    listDirections.add(Direction.DOWN);
                }
                // Vérifier si on peut aller à gauche
                if (characterX - 50 == zone[0] && characterY == zone[1] && direction != Direction.RIGHT) {
                    listDirections.add(Direction.LEFT);
                }
                // Vérifier si on peut aller à droite
                if (characterX + 50 == zone[0] && characterY == zone[1] && direction != Direction.LEFT) {
                    listDirections.add(Direction.RIGHT);
                }
            }
        } else {
            listDirections.add(this.direction);
        }

        return listDirections;
    }
}
