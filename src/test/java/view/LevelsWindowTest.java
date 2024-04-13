package view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * classe LevelsWindowsTest.
 */
public class LevelsWindowTest {
    private LevelsWindow levelsWindow;

    /**
     * BeforeEach initialisation.
     */
    @BeforeEach
    void setUp() {
        levelsWindow = new LevelsWindow(new JFrame());
    }

    /**
     * test countFile.
     */
    @Test
    void testCountFile() {
        // Test du nombre de fichiers dans le dossier de niveaux
        int nbLevels = levelsWindow.countFile();
        assertTrue(nbLevels > 0);
    }

    /**
     * test comboboxLevels.
     */
    @Test
    void testComboBoxLevels() {
        // Vérification du contenu de la JComboBox après l'initialisation
        JComboBox<String> comboBox = levelsWindow.getComboxBoxLevels();
        int expectedItemCount = levelsWindow.countFile();
        assertEquals(expectedItemCount, comboBox.getItemCount());
    }

}
