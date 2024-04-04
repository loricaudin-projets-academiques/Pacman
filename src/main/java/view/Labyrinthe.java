package view;
import controller.PacmanController;
import model.Pacman;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * Crée la fenetre principal.
 * @return Le fenetre principal. créé, avec le labyrinthe chargé.
 */
public class Labyrinthe extends JFrame implements KeyListener {
    private PacmanController controller;
    private Pacman pacman;
    /**
 * Constructeur de la classe Labyrinthe.
 */
    public Labyrinthe(PacmanController controller, Pacman pacman) {
        this.controller = controller;
        this.pacman = pacman;

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
 * Affiche une boîte de dialogue pour mettre en pause la fenêtre.
 */
    private void menuPause() {
        JOptionPane.showMessageDialog(this,
                "Fenêtre en pause", "Pause",
                JOptionPane.INFORMATION_MESSAGE);

    }
/**
 * class pour crée le boutton.
 */
    public final void actionPerformed(final ActionEvent e) {

    }

    @Override
    public final void keyPressed(final KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                controller.handleMovement(Pacman.Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                controller.handleMovement(Pacman.Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                controller.handleMovement(Pacman.Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                controller.handleMovement(Pacman.Direction.RIGHT);
                break;
            case KeyEvent.VK_ESCAPE:
                controller.handlePause();
                break;
        }
    }

    @Override
    public final void keyReleased(final KeyEvent e) {
        
    }

    @Override
    public void keyTyped(final KeyEvent e) {
        
    }
}
