package controller;

import model.InitialisationMatrice;
import model.Pacman;
import view.Labyrinthe;
import view.Observer;

import java.util.ArrayList;

/**
 * 
 */
public class StartController {

    private int level;
    
    /**
     * @param level
     */
    public StartController(final int level) {
        this.level = level;
    }

    /**
     * 
     */
    public void control() {
        final String path = "src/main/ressources/maps/level" + this.level + ".txt";
        InitialisationMatrice matrice = new InitialisationMatrice(path);
        matrice.lecture();

        ArrayList<Integer[]> freeBoxes = matrice.getFreeBoxes();
        Pacman pacman = new Pacman(freeBoxes);
        PacmanController pacmanController = new PacmanController(pacman);

        Labyrinthe labyrinthe = new Labyrinthe(matrice, pacmanController, pacman);
        matrice.addObserver((Observer) labyrinthe);
        labyrinthe.setVisible(true);

        

    }
}
