package controller;

/**
 * Contrôleur pour l'affichage du score
 */
public class ScoreController {
    
    private Integer count;
    /**
     * Constructeur de la classe ScoreController
     */
    public ScoreController() {
        this.count = 0;
    }

    /**
     * Vérifier le score
     * @param nbPoint
     * @return boolean
     */
    public boolean control(final Integer nbPoint) {
        return !(this.count < nbPoint);
    }

    /**
     * Récupérer le score
     * @return Integer
     */
    public Integer getCount() {
        return this.count;
    }

    /**
     * Mettre à jour le score
     * @param count
     */
    public void setCount(final Integer count) {
        this.count += count;
    }
}
