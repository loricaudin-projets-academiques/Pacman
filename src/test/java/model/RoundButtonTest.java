package model;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Test;

/**
 * classe test de RoundButton.
 */
public class RoundButtonTest {
    /**
     * test creation Button.
     */
    @Test
    public void testRoundButtonCreation() {
        RoundButton roundButton = new RoundButton("Round Button");
        assertNotNull(roundButton);
    }

    /**
     * Test de la méthode paintComponent pour le remplissage du rectangle arrondi.
     */
    @Test
    public void testPaintComponent() {
        // Création d'un RoundButton pour le test
        RoundButton roundButton = new RoundButton("Test");
        roundButton.setSize(100, 50);
        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        roundButton.paintComponent(g2d);

    }

    /**
     * Test de la méthode paintBorder pour le dessin du rectangle arrondi.
     */
    @Test
    public void testPaintBorder() {
        // Création d'un RoundButton pour le test
        RoundButton roundButton = new RoundButton("Test");
        roundButton.setSize(100, 50);

        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        roundButton.paintBorder(g2d);

    }

    /**
     * Test de la méthode contains pour vérifier les coordonnées.
     */
    @Test
    public void testContains() {

        RoundButton roundButton = new RoundButton("Test");
        roundButton.setSize(100, 50); 
        assertTrue(roundButton.contains(50, 25)); 

        assertFalse(roundButton.contains(0, 0)); 
        assertFalse(roundButton.contains(100, 0)); 
        assertFalse(roundButton.contains(0, 50)); 
        assertFalse(roundButton.contains(100, 50)); 
    }
}
