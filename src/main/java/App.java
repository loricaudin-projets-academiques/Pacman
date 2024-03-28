import view.HomeWindow;

/**
 *
 */
public final class App {

    /**
     * 
     */
    private App() { }
    
    /**
     * @param args
     */
    public static void main(final String[] args) {
        HomeWindow window = new HomeWindow();
        window.setVisible(true);
    }
}
