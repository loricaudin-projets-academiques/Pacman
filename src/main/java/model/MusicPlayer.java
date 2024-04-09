package model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * class gestion musique de fond.
 */
public class MusicPlayer extends Observable {

    /**
     * 
     * @param filePath
     */
    public void playMusic(final String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture de la musique : " + e.getMessage());
        }
    }
}
