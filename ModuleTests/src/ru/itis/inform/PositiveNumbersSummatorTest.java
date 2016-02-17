package ru.itis.inform;

/**
 * Created by Тимур on 17.02.2016.
 */
    import java.io.IOException;

    import static org.junit.Assert.*;

public class PositiveNumbersSummatorTest {

    PositiveNumbersSummator summator;

    @org.junit.Before

    public void setUp() throws Exception {
        this.summator = new PositiveNumbersSummator();
    }

    @org.junit.Test
    public void testSumm() throws Exception {

        int actual = summator.summ(10, 6);

        int expected = 16;

        assertEquals(expected, actual);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testOnNegative() throws Exception {
        summator.summ(-10, 1);
    }
}

}
