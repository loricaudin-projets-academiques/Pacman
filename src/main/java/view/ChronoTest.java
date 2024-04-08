package view;

import javax.swing.Timer;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ChronoTest extends JFrame {
    private Timer timer;
    private JLabel label;
    private int sec;

    public ChronoTest() {
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.createPanel());
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sec++;
                int minutes = sec / 60;
                int remainingSeconds = sec % 60;
                label.setText(String.format("%02d:%02d", minutes, remainingSeconds));
            }
        });
    }
    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    JPanel myPanel;

    private JPanel createPanel() {
        label = new JLabel("00:00");
        System.out.println("Temps écoulé: " + label.getText());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
        myPanel = (JPanel) getContentPane();
        return myPanel;

    }
}
