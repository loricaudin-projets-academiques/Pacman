package model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Modèle pour jouer de la musique
 */
public class MusicPlayer extends Observable {
    /**
     * Démarrer une musique à partir du chemin passé en paramètre
     * @param filePath
     */
    public void playMusic(final String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture de la musique : " + e.getMessage());
        }
    }
}
