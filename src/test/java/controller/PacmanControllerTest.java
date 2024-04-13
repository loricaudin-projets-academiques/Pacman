package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.InitialisationMatrice;
import model.Pacman;
/**
 * 
 */
public class PacmanControllerTest {
    /**
     * test pause.
     */
    @Test
    public void testHandlePause() {
        InitialisationMatrice matrice = createTestMatrice();
        matrice.lecture();
        ArrayList<Integer[]> freeBoxes = matrice.getFreeBoxes();
        Pacman pacman = new Pacman(freeBoxes);

        PacmanController pacmanController = new PacmanController(pacman);
        assertFalse(pacmanController.isPaused());

        pacmanController.handlePause();
        assertTrue(pacmanController.isPaused());

        pacmanController.handlePause();
        assertFalse(pacmanController.isPaused());
    }
    /**
     * test mouvement.
     */
    @Test
    public void testHandleMovement() {
        InitialisationMatrice matrice = createTestMatrice();
        matrice.lecture();
        ArrayList<Integer[]> freeBoxes = matrice.getFreeBoxes();
        Pacman pacman = new Pacman(freeBoxes);

        PacmanController pacmanController = new PacmanController(pacman);

        pacman.setCharacterX(50);
        pacman.setCharacterY(50);

        pacmanController.handleMovement(Pacman.Direction.UP);
        assertEquals(50, pacman.getCharacterY());

        pacmanController.handleMovement(Pacman.Direction.DOWN);
        assertEquals(60, pacman.getCharacterY());
    }
    /**
     * test direction.
     */
    @Test
    public void testHandleDirection() {
        InitialisationMatrice matrice = createTestMatrice();
        matrice.lecture();
    }
    
    /**
     * test changement de pacman.
     */
    @Test
    public void testUpdateModel() {
        InitialisationMatrice matrice = createTestMatrice();
        matrice.lecture();
        ArrayList<Integer[]> freeBoxes = matrice.getFreeBoxes();
        Pacman pacman = new Pacman(freeBoxes);

        PacmanController pacmanController = new PacmanController(pacman);

        assertFalse(pacmanController.isPaused());

        pacmanController.updateModel();
    }

    /**
     * 
     * @return
     */
    private InitialisationMatrice createTestMatrice() {
        return new InitialisationMatrice("src/test/resources/test_map.txt");
    }

}
