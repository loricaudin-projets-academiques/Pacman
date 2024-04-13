package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * classe test score.
 */
public class ScoreTest {
    
    /**
     * test control.
     */
    @Test
    void testControl() {
        Score score = new Score(10);

        score.setCount(5);
        assertFalse(score.control());

        score.setCount(5);
        assertTrue(score.control());

        score.setCount(1);
        assertTrue(score.control());
    }
    /**
     * test getCount.
     */
    @Test
    void testGetCount() {
        Score score = new Score(10);
        assertEquals(0, score.getCount());
        score.setCount(5);
        assertEquals(5, score.getCount());
    }

    /**
     * test setCount.
     */
    @Test
    void testSetCount() {
        Score score = new Score(10);

        assertEquals(0, score.getCount());
        score.setCount(5);
        assertEquals(5, score.getCount());
        score.setCount(3);
        assertEquals(8, score.getCount());
    }

    /**
     * test getScoreTotal.
     */
    @Test
    void testGetScoreTotal() {
        Score score = new Score(10);

        assertEquals(10, score.getScoreTotal());
        score.setScoreTotal(20);
        assertEquals(20, score.getScoreTotal());
    }

    /**
     * Test setScoreTotal.
     */
    @Test
    void testSetScoreTotal() {
        Score score = new Score(10);
        assertEquals(10, score.getScoreTotal());
        score.setScoreTotal(20);
        assertEquals(20, score.getScoreTotal());
    }
}
