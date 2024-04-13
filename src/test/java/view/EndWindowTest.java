package view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import model.Score;

/**
 * classe de teste de la fenetre EndWindow.
 */
public class EndWindowTest {

    /**
     * test creation Panel.
     */
    @Test
    public void testCreatePanel() {
        Score score = new Score(10);
        EndWindow endWindow = new EndWindow(true, score, "01:30");

        // Vérifie que le label des points est correctement configuré
        assertEquals("Vos points : 0/10", endWindow.getLabelScore().getText());
        assertTrue(endWindow.getLabelScore().getForeground().equals(new Color(255, 255, 0)));
        assertTrue(endWindow.getLabelScore().getBorder() != null);

        // Vérifie que le label du temps est correctement configuré
        assertEquals("Votre temps : 01:30", endWindow.getLabelTime().getText());
        assertTrue(endWindow.getLabelTime().getForeground().equals(new Color(255, 255, 0)));
        assertTrue(endWindow.getLabelTime().getBorder() != null);

        // Vérifie que le label du titre est correctement configuré
        assertTrue(endWindow.getLabelTitre().getText().equals("Gagne !"));
        assertTrue(endWindow.getLabelTitre().getForeground().equals(new Color(255, 255, 0)));
    }

    /**
     * Test de l'état gagnant et perdant.
     */
    @Test
    public void testWinLoseState() {
        Score score = new Score(10);

        // Test de l'état gagnant
        EndWindow winWindow = new EndWindow(true, score, "01:30");
        assertTrue(winWindow.isWon());
        assertTrue(winWindow.getLabelTitre().getText().equals("Gagne !"));

        // Test de l'état perdant
        EndWindow loseWindow = new EndWindow(false, score, "01:30");
        assertTrue(!loseWindow.isWon());
        assertTrue(loseWindow.getLabelTitre().getText().equals("Perdu..."));
    }

}
