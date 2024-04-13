package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.net.URL;

import model.Character;

/**
 * Vue pour modéliser un personnage dans le labyrinthe.
 */
public class CharacterView extends JLabel implements Observer {

    private Character character;
    /**
     * Constructeur du CharacterView.
     * @param character
     */
    public CharacterView(final Character character) {
        super("");
        this.character = character;

        this.setIcon(getImageIcon());
    }

    /**
     * Récupérer l'icône de l'image.
     * @return ImageIcon
     */
    public ImageIcon getImageIcon() {
        URL imageURL = getClass().getResource(character.getFilename());
        ImageIcon imageCharacter = new ImageIcon(imageURL);
        return imageCharacter;
    }

    @Override
    public void update() {
        this.setBounds(character.getCharacterX() + 5, character.getCharacterY() + 5, 50, 50);
    }
    
}
