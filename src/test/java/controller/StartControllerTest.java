package controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.InitialisationMatrice;
import model.Monster;
import model.Pacman;
import view.Labyrinthe;
import view.Observer;
/**
 * classe Test StartController.
 */
public class StartControllerTest {
    /**
     * test control.
     */
    @Test
    public void testControl() {
        int level = 1;
        int nbMonsters = 3; 
        StartController startController = new StartController(level, nbMonsters);
        startController.control();
        assertNotNull(startController);

        String path = "src/main/resources/maps/level1.txt";

        InitialisationMatrice matrice = new InitialisationMatrice(path);
        matrice.lecture();
        assertFalse(matrice.getMatrice().isEmpty()); 
        Pacman pacman = new Pacman(matrice.getFreeBoxes());
        assertNotNull(pacman); 
        ArrayList<Monster> listMonsters = new ArrayList<>();
        String[] gifFilenames = {"/monsters/GBlue.gif", "/monsters/GYellow.gif", "/monsters/GRed.gif", "/monsters/GPink.gif", "/monsters/GGreen.gif"};
        for (int i = 0; i < nbMonsters; i++) {
            Monster monster = new Monster(matrice.getFreeBoxes(), gifFilenames[i % gifFilenames.length]);
            listMonsters.add(monster);
        }

        assertNotNull(new StartController(level, nbMonsters)); 
        Labyrinthe labyrinthe = new Labyrinthe(matrice, null, pacman, listMonsters, null);
        matrice.addObserver((Observer) labyrinthe);
        labyrinthe.setVisible(true);
        assertTrue(labyrinthe.isVisible()); 
    }

    /**
     * test validité level.
     */
    @Test
    public void testInvalidLevel() {
        try {
            StartController startController = new StartController(-1, 2);
            startController.control();
            assertNull(startController);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'exécution du test : " + e.getMessage());
        }
    }
}
