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

        int actual[] = {summator.summ(1,2),summator.summ(3,5)};

        int expected[] = {3,8};

        for (int i = 0; i < 2; i++) {
            assertEquals(actual[i],expected[i]);
        }
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testOnNegative() throws Exception {
        summator.summ(-10, 1);
    }
}


