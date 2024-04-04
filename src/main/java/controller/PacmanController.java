package controller;

import model.Pacman;

public class PacmanController {
    private Pacman model;
    private boolean isPaused;

    public PacmanController(Pacman model) {
        this.model = model;
        this.isPaused = false;
    }

    public void handlePause() {
        this.isPaused = !this.isPaused;
    }

    public void handleMovement(Pacman.Direction direction) {
        if (!isPaused) {
            model.setDirection(direction);
        }
    }

    public void updateModel() {
        if (!isPaused) {
            model.move();
        }
    }

    public boolean isPaused() {
        return isPaused;
    }

    

}
