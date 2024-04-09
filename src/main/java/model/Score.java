package model;

/**
 * Class gestion du score.
 */
public class Score {

    private Integer count;
    private Integer scoreTotal;
    /**
     * 
     */
    public Score(final Integer scoreTotal) {
        this.count = 0;
        this.scoreTotal = scoreTotal;
    }

    /**
     * 
     * @param nbPoint
     * @return Boolean
     */
    public boolean control() {
        return !(this.count < this.scoreTotal);
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

    /**
     * 
     * @return Integer
     */
    public Integer getScoreTotal() {
        return scoreTotal;
    }

    /**
     * 
     * @param scoreTotal
     */
    public void setScoreTotal(Integer scoreTotal) {
        this.scoreTotal = scoreTotal;
    }
}
