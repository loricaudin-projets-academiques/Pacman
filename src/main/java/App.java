import java.time.temporal.ChronoField;

import view.HomeWindow;
import view.ChronoTest;

/**
 * Classe principale de l'application.
 */
public final class App {
    /**
     * 
     */
    private App() {
    }

    /**
     * Méthode principale de l'application. Lance l'interface utilisateur du Pacman.
     * 
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(final String[] args) {
        ChronoTest window = new ChronoTest();
        window.setVisible(true);
        window.start();
    }
}