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

    private JOptionPane menuPause() {
        JFrame pauseMenu = new JFrame();
        JOptionPane.showMessageDialog(pauseMenu,
                "Fenetre en pause", "Pause",
                JOptionPane.INFORMATION_MESSAGE);
        return menuPause();
    }

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.VK_ESCAPE);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }
}
