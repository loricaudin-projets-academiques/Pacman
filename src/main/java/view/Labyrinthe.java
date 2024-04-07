package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.InitialisationMatrice;
import model.Pacman;
/**
 * Crée la fenetre principal.
 * @return Le fenetre principal. créé, avec le labyrinthe chargé.
 */
public class Labyrinthe extends JFrame implements KeyListener, Observer {

    private InitialisationMatrice matrice;
    private ArrayList<Integer[]> positionsSquares;
    private ArrayList<Integer[]> freeBoxes;

    /**
     * Constructeur de la classe Labyrinthe.
     */
    public Labyrinthe(final InitialisationMatrice matrice) {
        this.matrice = matrice;

        this.positionsSquares = new ArrayList<>();
        this.freeBoxes = new ArrayList<>();
        genererPositionsSquares(this.matrice.getMatrice());

        this.setContentPane(this.createPanel());
        this.setTitle("Pac Man");
        this.setSize(
            tailleCarre * matrice.getMatrice().size() + 25,
            tailleCarre * matrice.getMatrice().get(0).size() + 50
        );
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel myPanel;
    private int tailleCarre = 50;
    private Pacman pacman;

    public JPanel getMyPanel() {
        return this.myPanel;
    }

    // private void setMyPanel(final JPanel myPanel) {
    //     this.myPanel = myPanel;
    // }

    /**
     * Création d'un JPanel.
     * @return JPanel
     */
    private JPanel createPanel() {
        myPanel = new JPanel() {
            @Override
            protected void paintComponent(final Graphics g) {
                super.paintComponent(g);
                for (int ii = 0; ii < positionsSquares.size(); ii++) {
                    drawSquare(g, positionsSquares.get(ii)[0], positionsSquares.get(ii)[1]);
                }                
            }
        };
        myPanel.setBackground(Color.black);
        myPanel.setLayout(null);

        pacman = new Pacman(freeBoxes);
        myPanel.add(pacman);

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

    private void genererPositionsSquares(final ArrayList<ArrayList<Integer>> matrice) {
        for (int ii = 0; ii < matrice.size(); ii++) {
            for (int jj = 0; jj < matrice.get(ii).size(); jj++) {
                Integer[] coordsCarres = {
                    tailleCarre * jj,
                    tailleCarre * ii
                };
                if (matrice.get(ii).get(jj) == 1) {
                    this.positionsSquares.add(coordsCarres);
                } else {
                    this.freeBoxes.add(coordsCarres);
                }
            }
        }
    }

    private void drawSquare(final Graphics g, final int x, final int y) {
        int padding = 5;
        g.setColor(Color.blue);
        g.fillRect(x + padding, y + padding, tailleCarre, tailleCarre);
    }
    /**
     * classe pour créer le boutton.
     */
    public final void actionPerformed(final ActionEvent e) {

    }

    @Override
    public final void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            menuPause();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pacman.setDirection(Pacman.Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pacman.setDirection(Pacman.Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            pacman.setDirection(Pacman.Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pacman.setDirection(Pacman.Direction.DOWN);
        }
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
}
