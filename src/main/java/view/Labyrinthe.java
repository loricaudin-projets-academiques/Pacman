package view;
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
    /**
 * Constructeur de la classe Labyrinthe.
 */
    public Labyrinthe() {
        this.setContentPane(this.createPanel());
        this.setTitle("Pacman");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel myPanel;

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
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            menuPause();
        }
    }

    @Override
    public final void keyReleased(final KeyEvent e) {
        
    }

    @Override
    public void keyTyped(final KeyEvent e) {
        
    }
}
