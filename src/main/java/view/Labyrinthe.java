package view;

import controller.MonsterController;
import controller.MusicController;
import controller.PacmanController;
import controller.PlayController;
import model.Pacman;
import model.Score;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
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

import model.Monster;
import model.Character;
/**
 * Crée la fenêtre principale avec le labyrinthe chargé.
 */
public class Labyrinthe extends JFrame implements KeyListener, Observer {

    private InitialisationMatrice matrice;
    private PacmanController pacmanController;
    private Pacman pacman;
    private CharacterView pacmanView;

    private ArrayList<MonsterController> listMonstersControllers;
    private ArrayList<Monster> listMonsters;
    private ArrayList<CharacterView> monstersViews;

    private Timer timer;
    private ArrayList<Integer[]> positionsFoods = new ArrayList<>();
    private ArrayList<Integer[]> positionsFreeBoxes;

    private MusicPlayer musicPlayer = new MusicPlayer();
    private MusicController musicController;

    private Score score;
    private PlayController playController;

    private Chrono chrono;

    /**
     * Constructeur de la classe Labyrinthe.
     */
    public Labyrinthe(
            final InitialisationMatrice matrice,
            final PacmanController pacmanController,
            final Pacman pacman,
            final ArrayList<Monster> listMonsters,
            final ArrayList<MonsterController> listMonstersControllers
            ) {
        this.matrice = matrice;
        //matrice.addObserver(this);

        this.pacman = pacman;
        this.pacmanView = new CharacterView(pacman);
        pacman.addObserver(this);
        this.pacmanController = pacmanController;

        this.listMonsters = listMonsters;
        this.monstersViews = new ArrayList<>();
        this.listMonstersControllers = listMonstersControllers;

        for (Monster monster: listMonsters) {
            this.monstersViews.add(new CharacterView(monster));
        }

        this.timer = new Timer(100, e -> moveCharacters());
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

        this.score = new Score(positionsFreeBoxes.size());
        this.chrono = new Chrono();
        this.playController = new PlayController(
            this,
            this.score,
            this.chrono,
            this.pacman,
            this.listMonsters
        );


        this.jlabelScore = new JLabel();
        this.setContentPane(this.createPanel());
        jlabelScore.setForeground(
                new Color(255, 255, 0));
    }

    private JPanel myPanel;
    private JLabel jlabelScore;
    private int tailleCarre = 50;
    private int sizeCircle = 10;

    // private ArrayList<Integer[]> positionsFoods = matrice.getFreeBoxes();

    /**
     * Récupération du JPanel.
     * @return JPanel
     */
    public JPanel getMyPanel() {
        return this.myPanel;
    }

    /**
     * Création d'un JPanel.
     * @return JPanel
     */
    JPanel createPanel() {
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

                drawCharacter(g, pacman, pacmanView);

                for (int ii = 0; ii < listMonsters.size(); ii++) {
                    drawCharacter(g, listMonsters.get(ii), monstersViews.get(ii));
                }

            }
        };
        chrono.start();
        myPanel.setBackground(Color.black);
        myPanel.setLayout(null);
        chrono.setForeground(Color.yellow);
        chrono.setFont(new Font("Serif", Font.BOLD, 16));
        chrono.setBounds(10, tailleCarre * matrice.getMatrice().size() - 20, 50, 100);
        myPanel.add(chrono);
        jlabelScore.setText("Points : " + score.getCount() + "/" + score.getScoreTotal());
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

    /**
     * Dessiner un carré dans l'écran.
     * @param g
     * @param x
     * @param y
     */
    private void drawSquare(final Graphics g, final int x, final int y) {
        int padding = 5;
        g.setColor(Color.blue);
        g.fillRect(x + padding, y + padding, tailleCarre, tailleCarre);
    }

    /**
     * Dessiner un cercle dans l'écran.
     * @param g
     * @param x
     * @param y
     */
    private void drawCircle(final Graphics g, final int x, final int y) {
        int padding = tailleCarre / 2;
        g.setColor(Color.YELLOW);
        g.fillOval(x + padding, y + padding, sizeCircle, sizeCircle);
    }

    /**
     * Dessiner un personnage.
     * @param g
     * @param character
     * @param characterView
     */
    private void drawCharacter(
            final Graphics g,
            final Character character,
            final CharacterView characterView
        ) {
        int padding = 5;
        g.drawImage(
            characterView.getImageIcon().getImage(),
            character.getCharacterX() + padding,
            character.getCharacterY() + padding,
            tailleCarre,
            tailleCarre,
            null
        );
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
                pacmanController.handlePause();
                break;
            default:
                return;
        }

        if (pacman.getDirection() == pressedDirection) {
            return;
        } else {
            pacmanController.handleDirection(pressedDirection);
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
        myPanel.repaint();
    }

    private void moveCharacters() {
        pacmanController.handleMovement(pacman.getDirection());
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
                playController.controlWin();
                
                jlabelScore.setText("Points : " + score.getCount() + "/" + score.getScoreTotal());
                myPanel.add(jlabelScore);
            }
        }

        for (MonsterController monsterController : listMonstersControllers) {
            monsterController.updatePosition();
        }
        if (!chrono.isStoped()) {
            playController.controlLoose();
        }
    }
}
