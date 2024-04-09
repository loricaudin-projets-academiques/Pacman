package controller;

import model.MusicPlayer;
import view.HomeWindow;

public class HomeController {
    private MusicPlayer musicPlayer;
    private HomeWindow homeWindow;

    public HomeController(MusicPlayer musicPlayer, HomeWindow homeWindow) {
        this.musicPlayer = musicPlayer;
        this.homeWindow = homeWindow;

        playBackgroundMusic();
    }

    public void playBackgroundMusic() {
        musicPlayer.playMusic("src/main/ressources/sound/pacman_music.wav");
    }
}
