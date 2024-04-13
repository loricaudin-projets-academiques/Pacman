package controller;

import model.Monster;

/**
 * Classe controller de Monster.
 */
public class MonsterController extends CharacterController {
    
    /**
     * Constructeur pour MonsterController.
     * @param model
     */
    public MonsterController(final Monster model) {
        super(model);
    }

    /**
     * Méthode pour mettre à jour la position du monstre.
     */
    public void updatePosition() {
        if (!this.isPaused()) {
            ((Monster) this.getModel()).move();
        }
    }
}
