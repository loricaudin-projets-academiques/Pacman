package model;

import java.util.ArrayList;

public class Monster extends Character {
    
    public Monster(final ArrayList<Integer[]> freeBoxes) {
        super(freeBoxes, "src/main/ressources/monstre.png");

        this.setIcon(getImageIcon());
    }
}
