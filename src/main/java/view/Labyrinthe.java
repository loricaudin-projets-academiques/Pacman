package view;

import controller.MusicController;
import controller.PacmanController;
import controller.ScoreController;
import model.Pacman;

import java.awt.Graphics;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.InitialisationMatrice;
import model.MusicPlayer;

import model.Monster;
import model.Character;
/**
 * Crée la fenetre principal.
 *
 * @return Le fenetre principal. créé, avec le labyrinthe chargé.
 */
public class Labyrinthe extends JFrame implements KeyListener, Observer {

    private InitialisationMatrice matrice;
    private PacmanController controller;
    private Pacman pacman;
    private ArrayList<Monster> listMonsters;

    private Timer timer;
    private ArrayList<Integer[]> positionsFoods = new ArrayList<>();
    private ArrayList<Integer[]> positionsFreeBoxes;
    private ScoreController scoreController;

    private MusicPlayer musicPlayer = new MusicPlayer();
    private MusicController musicController;

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

        this.timer = new Timer(100, e -> moveCharacters());
        this.timer.start();

        this.setContentPane(this.createPanel());
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

        this.scoreController = new ScoreController();
    }

    private JPanel myPanel;
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

                drawCharacter(g, pacman);

                for (Monster monster : listMonsters) {
                    drawCharacter(g, monster);
                }

            }
        };
        chrono.start();
        myPanel.setBackground(Color.black);
        myPanel.setLayout(null);
        chrono.setBounds(10, tailleCarre * matrice.getMatrice().size() - 20, 50, 100);
        myPanel.add(chrono);
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

    private void drawCharacter(final Graphics g, Character character) {
        int padding = 5;
        g.drawImage(
            character.getImageIcon().getImage(),
            character.getCharacterX() + padding,
            character.getCharacterY() + padding,
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

    private void moveCharacters() {
        controller.handleMovement(pacman.getDirection());
        int pacmanX = pacman.getCharacterX();
        int pacmanY = pacman.getCharacterY();
        boolean notFound = true;
        for (int i = 0; i < positionsFoods.size(); i++) {
            if (positionsFoods.get(i)[0] == pacmanX
                    && positionsFoods.get(i)[1] == pacmanY
                    && notFound
                ) {
                positionsFoods.get(i)[0] = 0;
                positionsFoods.get(i)[1] = 0;
                notFound = false;
                this.scoreController.setCount(1);
                if (scoreController.control(positionsFreeBoxes.size())) {
                    this.dispose();
                    EndWindow endWindow = new EndWindow(true);
                    endWindow.setVisible(true);
                }
            }
        }

        for (Monster monster : listMonsters) {
            monster.move();
        }

        myPanel.repaint();
    }


}
