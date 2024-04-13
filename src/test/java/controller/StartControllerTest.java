package controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.InitialisationMatrice;
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
        StartController startController = new StartController(1);
        startController.control();
        assertNotNull(startController);

        String path = "src/main/resources/maps/level1.txt";

        InitialisationMatrice matrice = new InitialisationMatrice(path);
        matrice.lecture();
        assertFalse(matrice.getMatrice().isEmpty()); 
        Pacman pacman = new Pacman(matrice.getFreeBoxes());
        assertNotNull(pacman); 
        assertNotNull(new StartController(1)); 
        Labyrinthe labyrinthe = new Labyrinthe(matrice, null, pacman);
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
            StartController startController = new StartController(-1);
            startController.control();
            assertNull(startController);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'exécution du test : " + e.getMessage());
        }
    }
}
