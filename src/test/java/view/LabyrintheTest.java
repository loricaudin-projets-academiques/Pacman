package view;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import javax.swing.JPanel;

import controller.MonsterController;
import controller.PacmanController;
import model.InitialisationMatrice;
import model.Monster;
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
                ArrayList<Monster> listMonsters = new ArrayList<>();
                ArrayList<MonsterController> listMonstersControllers = new ArrayList<>();
                int tailleCarre = 50;
                Monster monster = new Monster(matrice.getFreeBoxes());
                listMonsters.add(monster);
                listMonstersControllers.add(new MonsterController(monster));
                Labyrinthe labyrinthe = new Labyrinthe(
                                matrice,
                                controller,
                                pacman,
                                listMonsters,
                                listMonstersControllers);
                JPanel panel = labyrinthe.createPanel();
                /*
                 * assertEquals(
                 * tailleCarre * matrice.getMatrice().get(0).size() + 25,
                 * panel.getWidth());
                 * assertEquals(
                 * tailleCarre * matrice.getMatrice().size() + 100,
                 * panel.getHeight());
                 */
        }
}
