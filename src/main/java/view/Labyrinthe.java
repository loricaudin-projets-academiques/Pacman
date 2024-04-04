package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Classe Labyrinthe.
 */

public class Labyrinthe extends JFrame implements KeyListener {

    /**
     * Constructeur pour Labyrinthe.
     */
    public Labyrinthe() {
        this.setContentPane(this.createPanel());
        this.setTitle("Pacman");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel myPanel;

    public JPanel getMyPanel() {
        return this.myPanel;
    }

    private void setMyPanel(final JPanel myPanel) {
        this.myPanel = myPanel;
    }

    /**
     * Création d'un JPanel.
     * @return JPanel
     */
    private JPanel createPanel() {
        myPanel = (JPanel) getContentPane();
        this.addKeyListener(this);
        return myPanel;
    }

    /**
     * Création d'un JOptionPane pour le menuPause.
     * @return JOptionPane
     */
    private JOptionPane menuPause() {
        JFrame pauseMenu = new JFrame();
        JOptionPane.showMessageDialog(pauseMenu,
                "Fenetre en pause", "Pause",
                JOptionPane.INFORMATION_MESSAGE);
        return menuPause();
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        System.out.println(e.VK_ESCAPE);
    }

    @Override
    public void keyTyped(final KeyEvent e) {
        System.out.println(e.getKeyCode());
    }
}
