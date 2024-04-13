package model;

import java.util.ArrayList;

public class Monster extends Character {
    
    public Monster(final ArrayList<Integer[]> freeBoxes) {
        super(freeBoxes, "/monstre.png");

        this.setIcon(getImageIcon());
    }
}
