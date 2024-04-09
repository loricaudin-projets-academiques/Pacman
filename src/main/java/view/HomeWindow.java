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

import model.RoundButton;

/**
 * 
 */
public class HomeWindow extends JFrame implements ActionListener, Observer {

    /**
     * 
     */
    public HomeWindow() {
        this.setTitle("Pac Man");
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
    private JButton buttonStart;
    private JButton buttonExit;
    private JLabel labelTitre;

    /**
     * @return JPanel
     */
    private JPanel createPanel() {
        panel = (JPanel) getContentPane();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_START;

        labelTitre = new JLabel("Pac-Man");
        panel.add(labelTitre, c);

        // Boutons panel
        panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout());
        panelButton.setBackground(Color.BLACK);

        buttonStart = new RoundButton("Jouer");
        buttonStart.addActionListener(this);
        buttonStart.setForeground(
                new Color(255, 255, 0));
        buttonStart.setBackground(Color.BLACK);
        panelButton.add(buttonStart);

        buttonExit = new RoundButton("Quitter");
        buttonExit.addActionListener(this);
        buttonExit.setForeground(
                new Color(255, 255, 0));
        buttonExit.setBackground(Color.BLACK);
        buttonExit.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLUE, 2),
                new EmptyBorder(10, 20, 10, 20)));
        panelButton.add(buttonExit);

        buttonStart.setPreferredSize(buttonExit.getPreferredSize());

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        panel.add(panelButton, c);

        /* Instructions pour créer des widgets */

        return panel;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == buttonStart) {
            LevelsWindow levelsWindow = new LevelsWindow(this);
            levelsWindow.setVisible(true);
        } else {
            // this.dispose();
            System.exit(0);
        }

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
