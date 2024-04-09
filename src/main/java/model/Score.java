package model;

/**
 * Class gestion du score.
 */
public class Score {

    private Integer count;
    /**
     * 
     */
    public Score() {
        this.count = 0;
    }

    /**
     * 
     * @param nbPoint
     * @return Boolean
     */
    public boolean control(final Integer nbPoint) {
        return !(this.count < nbPoint);
    }
    /**
     * 
     * @return Integer
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
