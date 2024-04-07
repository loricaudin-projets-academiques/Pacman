package controller;

import model.Pacman;

/**
 * Classe controller de Pacman.
 */

public class PacmanController {
    private Pacman model;
    private boolean isPaused;

    /**
     * Constructeur pour PacmanController.
     * @param model
     */

    public PacmanController(final Pacman model) {
        this.model = model;
        this.isPaused = false;
    }

    /**
     * Méthode pour handle les pauses du jeu.
     */

    public void handlePause() {
        this.isPaused = !this.isPaused;
    }

    /**
     * Méthode pour handle les mouvements du jeu.
     * @param direction
     */

    public void handleMovement(Pacman.Direction direction) {
        if (!isPaused) {
            model.setDirection(direction);
        }
    }

    /**
     * Méthode pour mettre à jour le model.
     */

    public void updateModel() {
        if (!isPaused) {
            model.move();
        }
    }

    /**
     * Méthode pour savoir si le jeu est en pause.
     * @return isPaused
     */

    public boolean isPaused() {
        return isPaused;
    }

    

}
