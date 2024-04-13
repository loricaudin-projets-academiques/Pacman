package view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * classe test Chrono.
 */
public class ChronoTest {

    /**
     * 
     * @throws InterruptedException
     */
    @Test
    public void testChronoIncrement() throws InterruptedException {
        Chrono chrono = new Chrono();
        chrono.start();
        Thread.sleep(3000);
        assertEquals("00:02", chrono.getTime());
        chrono.stop();
    }
}
