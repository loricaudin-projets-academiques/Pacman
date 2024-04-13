package controller;

import java.util.ArrayList;

import model.Monster;
import model.Pacman;
import model.Score;
import view.Chrono;
import view.EndWindow;
import view.Labyrinthe;

/**
 * Classe pour vérifier si on a gagné ou perdu.
 */
public class PlayController {

    private Labyrinthe windowLabyrinthe;
    private Score score;
    private Chrono chrono;
    private Pacman pacman;
    private ArrayList<Monster> listMonsters;
    
    /**
     * Constructeur du PlayController.
     * @param score
     * @param pacman
     * @param listMonsters
     */
    public PlayController(
        final Labyrinthe windowLabyrinthe,
        final Score score,
        final Chrono chrono,
        final Pacman pacman,
        final ArrayList<Monster> listMonsters
        ) {
            this.windowLabyrinthe = windowLabyrinthe;
            this.score = score;
            this.chrono = chrono;
            this.pacman = pacman;
            this.listMonsters = listMonsters;
    }

    /**
     * Ajouter 1 point et vérifier si on a gagné.
     */
    public void controlWin() {
        this.score.setCount(1);
        if (score.control()) {
            windowLabyrinthe.dispose();
            chrono.stop();
            EndWindow endWindow = new EndWindow(true, score, chrono.getTime());
            endWindow.setVisible(true);
        }
    }

    /**
     * Vérifier si un monstre a touché Pacman et donc si on a perdu.
     */
    public boolean controlLoose() {
        boolean loosed = false;

        for (int ii = 0; ii < listMonsters.size() && !loosed; ii++) {
            if (
                pacman.getCharacterX() - listMonsters.get(ii).getCharacterX() < 50
                && pacman.getCharacterY() - listMonsters.get(ii).getCharacterY() < 50
                && pacman.getCharacterX() - listMonsters.get(ii).getCharacterX() > -50
                && pacman.getCharacterY() - listMonsters.get(ii).getCharacterY() > -50
            ) {
                loosed = true;
            }
        }

        if (loosed) {
            windowLabyrinthe.dispose();
            chrono.stop();
            EndWindow endWindow = new EndWindow(false, score, chrono.getTime());
            endWindow.setVisible(true);
        }
        return loosed;
    }
}
