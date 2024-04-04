import model.InitialisationMatrice;

/**
 *
 */
public final class App {

    private App() {
    }

    /**
     * 
     * @param args
     */
    public static void main(final String[] args) {
        InitialisationMatrice initial = new InitialisationMatrice();

        initial.lecture("src/main/ressources/map.txt");
    }
}
