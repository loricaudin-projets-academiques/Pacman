/**
 * Classe App pour notre application.
 */
public final class App {
    /**
     * Permet d'éviter que cette classe ne puisse être instancié.
     */
    private App() {
        throw new AssertionError();
    }

    /**
     * Début de l'application.
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println("Bonjour, ça va ?");
    }
}
