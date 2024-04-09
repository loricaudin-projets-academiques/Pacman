package view;

import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 * 
 */
public class ChronoTest extends JLabel {
    private Timer timer;
    private JLabel label;
    private int sec;

    /**
     * update toutes les secondes avec la nouvelle valeur du chrono.
     */
    public ChronoTest() {
        super("00:00");
        super.setForeground(Color.white);
        this.label = this;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                sec++;
                int minutes = sec / 60;
                int remainingSeconds = sec % 60;
                label.setText(String.format("%02d:%02d", minutes, remainingSeconds));
            }
        });
    }

    /**
     * début du chrono.
     */
    public void start() {
        timer.start();
    }

    /**
     * arret du chrono.
     */
    public void stop() {
        timer.stop();
    }
}
