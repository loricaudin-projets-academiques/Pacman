import model.InitialisationMatrice;

/**
 *
 */
public class App {
    public static void main(String[] args){
        InitialisationMatrice initial = new InitialisationMatrice();

        initial.lecture("src/main/ressources/map.txt");
    }   
}
