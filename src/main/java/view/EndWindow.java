package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Score;

/**
 * Fenêtre de fin d'une partie.
 */
public class EndWindow extends JFrame implements ActionListener {

    private boolean won;

    private Score score;

    private String time;

    /**
     * Constructeur de EndWindow.
     * @param won (true affiche la fenêtre "gagné", false affiche la fenêtre "perdu")
     * @param score
     * @param time
     */
    public EndWindow(final boolean won, final Score score, final String time) {
        this.won = won;
        this.score = score;

        this.time = time;

        this.labelTitre = new JLabel();

        this.setTitle("Pac Man - Fin de partie");
        this.setIconImage(new ImageIcon("src/main/resources/pacman/pacman.png").getImage());

        this.setSize(700, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setContentPane(this.createPanel());
        try {
            File fontStyle = new File("src/main/resources/fonts/PAC-FONT.TTF");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(50f);
            labelTitre.setFont(font);
            labelTitre.setForeground(
                    new Color(255, 255, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getContentPane().setBackground(
                new Color(0, 0, 0));
    }

    private JPanel panel;
    private JPanel panelButton;
    private JPanel panelScore;
    private JPanel panelPoint;
    private JButton buttonRestart;
    private JButton buttonExit;
    private JLabel labelTitre;

    private JLabel labelScore;

    private JLabel labelTime;

    /**
     * Création d'un JPanel.
     * @return JPanel
     */
    private JPanel createPanel() {
        panel = (JPanel) getContentPane();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 4;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;

        // score pannel
        panelPoint = new JPanel();
        panelPoint.setLayout(new FlowLayout());
        panelPoint.setBackground(Color.BLACK);

        labelScore = new JLabel(score.getCount() + "/" + score.getScoreTotal());
        labelScore.setFont(new Font("Serif", Font.BOLD, 18));
        labelScore.setText("Vos points : " + labelScore.getText());
        panelPoint.add(labelScore);
        labelScore.setForeground(
                new Color(255, 255, 0));
        labelScore.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.YELLOW, 1),
                new EmptyBorder(10, 30, 10, 30)));

        if (won) {
            labelTitre.setText("Gagne !");
        } else {
            labelTitre.setText("Perdu...");
            panel.add(panelPoint, c);
        }

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_START;

        panel.add(labelTitre, c);

        // Boutons panel
        panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout());
        panelButton.setBackground(Color.BLACK);

        buttonRestart = new RoundButton("Rejouer");
        buttonRestart.addActionListener(this);
        buttonRestart.setForeground(
                new Color(255, 255, 0));
        buttonRestart.setBackground(Color.BLACK);
        panelButton.add(buttonRestart);

        buttonExit = new RoundButton("Quitter");
        buttonExit.addActionListener(this);
        buttonExit.setForeground(
                new Color(255, 255, 0));
        buttonExit.setBackground(Color.BLACK);
        buttonExit.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLUE, 2),
                new EmptyBorder(10, 20, 10, 20)));
        panelButton.add(buttonExit);
        buttonRestart.setPreferredSize(buttonExit.getPreferredSize());

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        panel.add(panelButton, c);

        // score pannel
        panelScore = new JPanel();
        panelScore.setLayout(new FlowLayout());
        panelScore.setBackground(Color.BLACK);

        labelTime = new JLabel(time);
        labelTime.setFont(new Font("Serif", Font.BOLD, 18));
        labelTime.setText("Votre temps : " + labelTime.getText());
        panelScore.add(labelTime);
        labelTime.setForeground(
                new Color(255, 255, 0));
        labelTime.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.YELLOW, 1),
                new EmptyBorder(10, 30, 10, 30)));

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 4;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_START;
        panel.add(panelScore, c);

        return panel;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == buttonRestart) {
            LevelsWindow levelsWindow = new LevelsWindow(this);
            levelsWindow.setVisible(true);
        } else {
            // this.dispose();
            System.exit(0);
        }
    }
}
