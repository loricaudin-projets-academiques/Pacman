package controller;

import model.MusicPlayer;

/**
 * Contrôleur pour gérer la musique de Pacman.
 */
public class MusicController {
    private MusicPlayer musicPlayer;

    /**
     * Instancier la classe.
     * @param musicPlayer
     */
    public MusicController(final MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;

        playBackgroundMusic();
    }

    /**
     * Jouer la musique de démarrage de Pacman en arrière-plan.
     */
    public void playBackgroundMusic() {
        musicPlayer.playMusic("src/main/resources/sound/pacman_music.wav");
    }
}
