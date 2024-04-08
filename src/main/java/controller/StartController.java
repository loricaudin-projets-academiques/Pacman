package controller;

import model.InitialisationMatrice;
import model.Monster;
import model.Pacman;
import view.Labyrinthe;
import view.Observer;

import java.util.ArrayList;

/**
 * 
 */
public class StartController {

    private int level;
    private int nbMonsters;
    
    /**
     * @param level
     * @param nbMonsters
     */
    public StartController(final int level, final int nbMonsters) {
        this.level = level;
        this.nbMonsters = nbMonsters;
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

        ArrayList<Monster> listMonsters = new ArrayList<>();
        for (int ii = 0; ii < nbMonsters; ii++) {
            listMonsters.add(new Monster(freeBoxes));
        }

        Labyrinthe labyrinthe = new Labyrinthe(matrice, pacmanController, pacman, listMonsters);
        matrice.addObserver((Observer) labyrinthe);
        labyrinthe.setVisible(true);
    }
}
