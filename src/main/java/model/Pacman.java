package model;

public class Pacman {
    public int direction = 0;
    public int pacmanX;
    public int pacmanY;

    public Pacman(int x0,int y0){
        pacmanX = x0;
        pacmanY = y0;
    }

    public void move() {
        if(direction == 0) pacmanX++;
        if(direction == 1) pacmanY++;
        if(direction == 2) pacmanX--;
        if(direction == 3) pacmanY--;

    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
