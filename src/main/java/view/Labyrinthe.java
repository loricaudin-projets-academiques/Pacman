package view;

import controller.PacmanController;
import model.Pacman;

import java.awt.Graphics;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.Timer;

import model.InitialisationMatrice;
import model.Monster;
/**
 * Crée la fenetre principal.
 * @return Le fenetre principal. créé, avec le labyrinthe chargé.
 */
public class Labyrinthe extends JFrame implements KeyListener, Observer {

    private InitialisationMatrice matrice;
    private PacmanController controller;
    private Pacman pacman;
    private ArrayList<Monster> listMonsters;

    private Timer timer;
    /**
     * Constructeur de la classe Labyrinthe.
     */
    public Labyrinthe(
            final InitialisationMatrice matrice,
            final PacmanController controller,
            final Pacman pacman,
            final ArrayList<Monster> listMonsters
            ) {
        this.matrice = matrice;

        this.pacman = pacman;
        this.listMonsters = listMonsters;
        this.controller = controller;

        this.timer = new Timer(100, e -> movePacman());
        this.timer.start();

        this.setContentPane(this.createPanel());
        this.setTitle("Pac Man");
        this.setSize(
                tailleCarre * matrice.getMatrice().get(0).size() + 25,
                tailleCarre * matrice.getMatrice().size() + 50);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel myPanel;
    private int tailleCarre = 50;

    public JPanel getMyPanel() {
        return this.myPanel;
    }

    // private void setMyPanel(final JPanel myPanel) {
    // this.myPanel = myPanel;
    // }

    /**
     * Création d'un JPanel.
     *
     * @return JPanel
     */
    private JPanel createPanel() {
        myPanel = new JPanel() {
            @Override
            protected void paintComponent(final Graphics g) {
                super.paintComponent(g);
                ArrayList<Integer[]> positionsSquares = matrice.getPositionsSquares();

                for (int ii = 0; ii < positionsSquares.size(); ii++) {
                    drawSquare(g, positionsSquares.get(ii)[0], positionsSquares.get(ii)[1]);
                }
                drawPacman(g, pacman.getCharacterX(), pacman.getCharacterY());
            }
        };
        myPanel.setBackground(Color.black);
        myPanel.setLayout(null);

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

    private void drawSquare(final Graphics g, final int x, final int y) {
        int padding = 5;
        g.setColor(Color.blue);
        g.fillRect(x + padding, y + padding, tailleCarre, tailleCarre);
    }



    private void drawPacman(final Graphics g, final int x, final int y) {
        int padding = 5;
        g.drawImage(
            pacman.getImageIcon().getImage(),
            x + padding,
            y + padding,
            tailleCarre,
            tailleCarre,
            null
        );
    }




    /**
     * classe pour créer le boutton.
     */
    public final void actionPerformed(final ActionEvent e) {

    }

    @Override
    public final void keyPressed(final KeyEvent e) {
        switch (e.getKeyCode()) {
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
            default:
                break;
        }

        myPanel.repaint();
    }

    @Override
    public final void keyReleased(final KeyEvent e) {
        
    }

    @Override
    public void keyTyped(final KeyEvent e) {
        
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    private void movePacman() {
        controller.handleMovement(pacman.getDirection());
        myPanel.repaint();
    }
}
