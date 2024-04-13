package view;

import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 * Vue du chronomètre.
 */
public class Chrono extends JLabel {
    private Timer timer;
    private JLabel label;
    private int sec;
    private boolean stoped;

    /**
     * update toutes les secondes avec la nouvelle valeur du chrono.
     */
    public Chrono() {
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
        this.stoped = true;
    }

    /**
     * début du chrono.
     */
    public void start() {
        timer.start();
        stoped = false;
    }

    /**
     * arrêt du chrono.
     */
    public void stop() {
        timer.stop();
        stoped = true;
    }

    /**
     * getter du temps.
     * @return
     */
    public String getTime() {
        return this.getText();
    }
    
    /**
     * Vérifie si le chrono est arrêté.
     * @return stoped
     */
    public boolean isStoped() {
        return stoped;
    }
}
