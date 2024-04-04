package controller;

import model.InitialisationMatrice;
import view.Labyrinthe;

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

        Labyrinthe labyrinthe = new Labyrinthe();
        //matrice.addObserver((Observer) labyrinthe);
        labyrinthe.setVisible(true);

        

    }
}
