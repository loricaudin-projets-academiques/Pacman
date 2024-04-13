package view;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * classe HomeWindowTest.
 */
public class HomeWindowTest {
    private HomeWindow homeWindow;

    /**
     * BeforeEach test.
     */
    @BeforeEach
    public void setup() {
        homeWindow = new HomeWindow();
    }
    
    /**
     * Test createPanel.
     */
    @Test
    public void testCreatePanel() {
        JPanel panel = homeWindow.getPanel();

        // Vérifiez que le panel est non null
        assertNotNull(panel, "Le panel ne devrait pas être null");

        // Vérifiez que le panel contient les composants attendus
        JButton buttonStart = homeWindow.getButtonStart();
        JButton buttonExit = homeWindow.getButtonExit();
        JLabel labelTitre = homeWindow.getLabelTitre();

        assertTrue(panel.isAncestorOf(buttonStart), "Le bouton Jouer devrait être ajouté au panel");
        assertTrue(panel.isAncestorOf(buttonExit), "Bouton Quitter devrait être ajouté au panel");
        assertTrue(panel.isAncestorOf(labelTitre), "Le label Titre devrait être ajouté au panel");
    }
    /**
     * test update.
     */
    @Test
    public void testUpdate() {
        HomeWindow homeWindow = new HomeWindow();

        // Testez que l'appel à la méthode update lance bien une UnsupportedOperationException
        assertThrows(UnsupportedOperationException.class, () -> {
            homeWindow.update();
        });
    }
}
