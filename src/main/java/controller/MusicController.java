package controller;

import model.MusicPlayer;

/**
 * 
 */
public class MusicController {
    private MusicPlayer musicPlayer;

    /**
     * @param musicPlayer
     */
    public MusicController(final MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;

        playBackgroundMusic();
    }

    /**
     * 
     */
    public void playBackgroundMusic() {
        musicPlayer.playMusic("src/main/resources/sound/pacman_music.wav");
    }
}
