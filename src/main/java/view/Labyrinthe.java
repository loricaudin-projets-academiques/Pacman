package view;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Labyrinthe extends JFrame implements KeyListener {
    public Labyrinthe() {
        this.setContentPane(this.createPanel());
        this.setTitle("Pacman");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    JPanel myPanel;

    private JPanel createPanel() {
        myPanel = (JPanel) getContentPane();
        this.addKeyListener(this);
        return myPanel;
    }

    private void menuPause() {
        JOptionPane.showMessageDialog(this,
                "Fenêtre en pause", "Pause",
                JOptionPane.INFORMATION_MESSAGE);

    }

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            menuPause();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    // public static void main(String[] args) {
    //     Labyrinthe labyrinth = new Labyrinthe();
    //     labyrinth.setVisible(true);
    // }
}
