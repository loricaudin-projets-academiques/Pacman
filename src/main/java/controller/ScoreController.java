package controller;

/**
 * class pour le control des scores.
 */
public class ScoreController {

    private Integer count;

    /**
     * 
     */
    public ScoreController() {
        this.count = 0;
    }
    /**
     * 
     * @param nbPoint
     * @return
     */
    public boolean control(final Integer nbPoint) {
        if (this.count < nbPoint) {
            return false;
        } 
        return true;
    }
    /**
     * 
     * @return
     */
    public Integer getCount() {
        return this.count;
    }
    /**
     * 
     * @param count
     */
    public void setCount(final Integer count) {
        this.count += count;
    }
}
