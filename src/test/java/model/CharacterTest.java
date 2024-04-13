package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * classe CharacterTest.
 */
public class CharacterTest {

    /**
     * test GetFilename.
     */
    @Test
    public void testGetFilename() {

        String path = "src/main/resources/maps/level1.txt";

        InitialisationMatrice matrice = new InitialisationMatrice(path);
        matrice.lecture();

        ArrayList<Integer[]> freeBoxes = matrice.getFreeBoxes();

        String expectedFilename = "pacman.png";
        Character character = new Character(freeBoxes, expectedFilename);

        String actualFilename = character.getFilename();
        assertEquals(expectedFilename, actualFilename);
    }
}
