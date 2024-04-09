package view;

import controller.MusicController;
import controller.PacmanController;

import model.Pacman;
import model.Score;

import java.awt.Graphics;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.InitialisationMatrice;
import model.MusicPlayer;

/**
 * Crée la fenetre principal.
 * 
 * @return Le fenetre principal. créé, avec le labyrinthe chargé.
 */
public class Labyrinthe extends JFrame implements KeyListener, Observer {

    private InitialisationMatrice matrice;
    private PacmanController controller;
    private Pacman pacman;

    private Timer timer;
    private ArrayList<Integer[]> positionsFoods = new ArrayList<>();
    private ArrayList<Integer[]> positionsFreeBoxes;

    private MusicPlayer musicPlayer = new MusicPlayer();
    private MusicController musicController;

    private Score score;

    /**
     * Constructeur de la classe Labyrinthe.
     */
    public Labyrinthe(
            final InitialisationMatrice matrice,
            final PacmanController controller,
            final Pacman pacman) {
        this.matrice = matrice;

        this.pacman = pacman;
        this.controller = controller;

        this.timer = new Timer(100, e -> movePacman());
        this.timer.start();

        this.setTitle("Pac Man");
        this.setIconImage(new ImageIcon("src/main/resources/pacman/pacman.png").getImage());
        this.setSize(
                tailleCarre * matrice.getMatrice().get(0).size() + 25,
                tailleCarre * matrice.getMatrice().size() + 100);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.positionsFreeBoxes = matrice.getFreeBoxes();

        for (int ii = 0; ii < positionsFreeBoxes.size(); ii++) {
            Integer[] posTmp = {
                    positionsFreeBoxes.get(ii)[0],
                    positionsFreeBoxes.get(ii)[1]
            };

            this.positionsFoods.add(posTmp);
        }
        this.musicPlayer.addObserver(this);
        this.musicController = new MusicController(musicPlayer);

        this.score = new Score();
        this.jlabelScore = new JLabel();
        this.setContentPane(this.createPanel());
        jlabelScore.setForeground(
                new Color(255, 255, 0));
    }

    private JPanel myPanel;
    private JLabel jlabelScore;
    private int tailleCarre = 50;
    private int sizeCircle = 10;
    private ChronoTest chrono = new ChronoTest();

    // private ArrayList<Integer[]> positionsFoods = matrice.getFreeBoxes();

    public JPanel getMyPanel() {
        return this.myPanel;
    }

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

                for (int ii = 0; ii < positionsFreeBoxes.size(); ii++) {
                    if (positionsFreeBoxes.get(ii)[0] == positionsFoods.get(ii)[0]
                            && positionsFreeBoxes.get(ii)[1] == positionsFoods.get(ii)[1]) {
                        drawCircle(g, positionsFreeBoxes.get(ii)[0], positionsFreeBoxes.get(ii)[1]);
                    }
                }

                drawPacman(g, pacman.getCharacterX(), pacman.getCharacterY());
            }
        };
        chrono.start();
        myPanel.setBackground(Color.black);
        myPanel.setLayout(null);
        chrono.setBounds(10, tailleCarre * matrice.getMatrice().size() - 20, 50, 100);
        myPanel.add(chrono);
        jlabelScore.setText("Points : " + score.getCount() + "/" + positionsFreeBoxes.size());
        jlabelScore.setBounds(tailleCarre * matrice.getMatrice().get(0).size() - 100,
                tailleCarre * matrice.getMatrice().size() - 20, 100, 100);
        myPanel.add(jlabelScore);
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

    private void drawCircle(final Graphics g, final int x, final int y) {
        int padding = tailleCarre / 2;
        g.setColor(Color.YELLOW);
        g.fillOval(x + padding, y + padding, sizeCircle, sizeCircle);
    }

    private void drawPacman(final Graphics g, final int x, final int y) {
        int padding = 5;
        g.drawImage(
                pacman.getImageIcon().getImage(),
                x + padding,
                y + padding,
                tailleCarre,
                tailleCarre,
                null);
    }

    /**
     * classe pour créer le boutton.
     */
    public final void actionPerformed(final ActionEvent e) {

    }

    @Override
    public final void keyPressed(final KeyEvent e) {
        Pacman.Direction pressedDirection = null;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                pressedDirection = Pacman.Direction.UP;
                break;
            case KeyEvent.VK_DOWN:
                pressedDirection = Pacman.Direction.DOWN;
                break;
            case KeyEvent.VK_LEFT:
                pressedDirection = Pacman.Direction.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                pressedDirection = Pacman.Direction.RIGHT;
                break;
            case KeyEvent.VK_ESCAPE:
                controller.handlePause();
                break;
            default:
                return;
        }

        if (pacman.getDirection() == pressedDirection) {
            return;
        } else {
            controller.handleDirection(pressedDirection);
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
        int pacmanX = pacman.getCharacterX();
        int pacmanY = pacman.getCharacterY();
        boolean notFound = true;
        for (int i = 0; i < positionsFoods.size(); i++) {
            if (positionsFoods.get(i)[0] == pacmanX
                    && positionsFoods.get(i)[1] == pacmanY
                    && notFound) {
                positionsFoods.get(i)[0] = 0;
                positionsFoods.get(i)[1] = 0;
                notFound = false;
                this.score.setCount(1);
                if (score.control(positionsFreeBoxes.size())) {
                    this.dispose();
                    EndWindow endWindow = new EndWindow(true);
                    endWindow.setVisible(true);
                }
                jlabelScore.setText("Points : " + score.getCount() + "/" + positionsFreeBoxes.size());
                myPanel.add(jlabelScore);
            }
        }
        myPanel.repaint();
    }
}
