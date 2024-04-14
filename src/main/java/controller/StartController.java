package controller;

import model.InitialisationMatrice;
import model.Monster;
import model.Pacman;
import view.Labyrinthe;

import java.util.ArrayList;

/**
 * Contrôleur pour le démarrage d'une partie.
 */
public class StartController {

    private int level;
    private int nbMonsters;
    
    /**
     * Constructeur de StartController.
     * @param level
     * @param nbMonsters
     */
    public StartController(final int level, final int nbMonsters) {
        this.level = level;
        this.nbMonsters = nbMonsters;
    }

    /**
     * Méthode pour démarrer le Labyrinthe.
     */
    public void control() {
        final String path = "src/main/resources/maps/level" + this.level + ".txt";
        InitialisationMatrice matrice = new InitialisationMatrice(path);
        matrice.lecture();

        ArrayList<Integer[]> freeBoxes = matrice.getFreeBoxes();
        Pacman pacman = new Pacman(freeBoxes);
        PacmanController pacmanController = new PacmanController(pacman);
        ArrayList<MonsterController> listMonstersControllers = new ArrayList<>();

        ArrayList<Monster> listMonsters = new ArrayList<>();

        String[] gifFilenames = {
                "/monsters/GBlue.gif",
                "/monsters/GYellow.gif",
                "/monsters/GRed.gif",
                "/monsters/GPink.gif",
                "/monsters/GGreen.gif"
        };

        for (int ii = 0; ii < nbMonsters; ii++) {
            Monster monster = new Monster(freeBoxes, gifFilenames[ii % gifFilenames.length]);
            listMonsters.add(monster);
            listMonstersControllers.add(new MonsterController(monster));
        }


        Labyrinthe labyrinthe = new Labyrinthe(
            matrice,
            pacmanController,
            pacman,
            listMonsters,
            listMonstersControllers
        );
        //matrice.addObserver((Observer) labyrinthe);
        labyrinthe.setVisible(true);
    }

    public int getLevel() {
        return level;
    }

    public int getNbMonsters() {
        return nbMonsters;
    }
}
