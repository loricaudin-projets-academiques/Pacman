package controller;

import model.MusicPlayer;
import view.HomeWindow;

/**
 * class controller view Home.
 */
public class HomeController {
    private MusicPlayer musicPlayer;
    private HomeWindow homeWindow;

    /**
     * 
     * @param musicPlayer
     * @param homeWindow
     */
    public HomeController(final MusicPlayer musicPlayer, final HomeWindow homeWindow) {
        this.musicPlayer = musicPlayer;
        this.homeWindow = homeWindow;

        playBackgroundMusic();
    }

    /**
     * 
     * lancement de la musique de fond.
     */
    public void playBackgroundMusic() {
        musicPlayer.playMusic("src/main/ressources/sound/pacman_music.wav");
    }
}
