package view;

import org.junit.jupiter.api.Test;


import javax.swing.JPanel;

import controller.PacmanController;
import model.InitialisationMatrice;
import model.Pacman;

/**
 * classe Labyrinthetest.
 */
public class LabyrintheTest {

        /**
         * test createPanel.
         */
    @Test
    public void testCreatePanel() {
        String path = "src/main/resources/maps/level1.txt";
        InitialisationMatrice matrice = new InitialisationMatrice(path);
        matrice.lecture();
        Pacman pacman = new Pacman(matrice.getFreeBoxes());
        PacmanController controller = new PacmanController(pacman);

        int tailleCarre = 50;

        Labyrinthe labyrinthe = new Labyrinthe(matrice, controller, pacman);

        JPanel panel = labyrinthe.createPanel();
/* 
        assertEquals(
                tailleCarre * matrice.getMatrice().get(0).size() + 25,
                panel.getWidth());
        assertEquals(
                tailleCarre * matrice.getMatrice().size() + 100,
                panel.getHeight());*/
    }
}
