package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.InitialisationMatrice;
import model.Monster;
import model.Pacman;
import model.Score;
import view.Chrono;
import view.Labyrinthe;

/**
 * class playControllerTest.
 */
public class PlayControllerTest {

    private PlayController playController;
    private Labyrinthe labyrinthe;
    private Score score;
    private Chrono chrono;
    private Pacman pacman;
    private ArrayList<Monster> monsters;
    private ArrayList<Integer[]> freeBoxes;

    /**
     * BeforeEach.
     */
    @BeforeEach
    public void setUp() {
        String path = "src/main/resources/maps/level1.txt";
        InitialisationMatrice matrice = new InitialisationMatrice(path);
        matrice.lecture();
        pacman = new Pacman(matrice.getFreeBoxes());
        freeBoxes = matrice.getFreeBoxes();
        PacmanController controller = new PacmanController(pacman);
        ArrayList<Monster> listMonsters = new ArrayList<>();
        ArrayList<MonsterController> listMonstersControllers = new ArrayList<>();
        labyrinthe = new Labyrinthe(
            matrice, 
            controller, 
            pacman, 
            listMonsters, 
            listMonstersControllers
            );
        score = new Score(freeBoxes.size());
        chrono = new Chrono();
        monsters = new ArrayList<>();
        playController = new PlayController(labyrinthe, score, chrono, pacman, monsters);
    }

    /**
     * test testControlWin.
     */
    @Test
    public void testControlWin() {
        assertEquals(0, score.getCount());

        playController.controlWin();
        assertEquals(1, score.getCount());
    }
    
    /**
     * test ControlLooseNotLoose.
     */
    @Test
    public void testControlLooseNotLoose() {

        assertFalse(playController.controlLoose());


        monsters.add(new Monster(freeBoxes));
        monsters.add(new Monster(freeBoxes));
        assertFalse(playController.controlLoose());
    }


}
