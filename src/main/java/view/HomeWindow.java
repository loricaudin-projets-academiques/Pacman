package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */
public class HomeWindow extends JFrame implements ActionListener {
    
    /**
     * 
     */
    public HomeWindow() {
        this.setTitle("Pac Man");
        //this.setIconImage(new ImageIcon("src/icone.png").getImage());

        this.setSize(700, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setContentPane(this.createPanel());
    }

    private JPanel panel;
    private JButton buttonStart;
    private JButton buttonExit;

    /**
     * @return JPanel
     */
    private JPanel createPanel() {
        panel = (JPanel) getContentPane();
        panel.setLayout(new FlowLayout());

        buttonStart = new JButton("Jouer");
        buttonStart.addActionListener(this);
        panel.add(buttonStart);

        buttonExit = new JButton("Quitter");
        buttonExit.addActionListener(this);
        panel.add(buttonExit);


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
            this.dispose();
        }
    }
}
