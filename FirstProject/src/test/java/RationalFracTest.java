import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itis.inform.RationalFrac;

/**
 * Created by Timur Mardanov on 08.06.2017.
 * ITIS
 */

//JUNIT 4
public class RationalFracTest {

    private RationalFrac expectedSummRationalFrac;
    private RationalFrac expectedNormalizeFrac;
    private RationalFrac expectedMultipleFrac;
    private String expectedFracResult = "8/3";

    @Before
    public void init() {
        expectedNormalizeFrac = new RationalFrac(2, 3, 2);
        expectedSummRationalFrac = new RationalFrac(22, 15);
        expectedMultipleFrac = new RationalFrac(8,15);
    }

    @Test
    public void fracShouldNormalize() {
        RationalFrac actualNormalizeRationalFrac = new RationalFrac(5, 3, 1);
        actualNormalizeRationalFrac.getNormalize();
        Assert.assertEquals(0, expectedNormalizeFrac.compareTo(actualNormalizeRationalFrac));
    }

    @Test
    public void fracShouldPrint() {
        RationalFrac actualNormalizeRationalFrac = new RationalFrac(5, 3, 1);
        String actualResult = actualNormalizeRationalFrac.getResult();
        Assert.assertEquals(expectedFracResult, actualResult);
    }

    @Test
    public void summTwoFracs() {
        RationalFrac firstFrac = new RationalFrac(2,3);
        RationalFrac secondFrac = new RationalFrac(4,5);
        RationalFrac actualSumm = RationalFrac.summ(firstFrac,secondFrac);
        Assert.assertEquals(0, actualSumm.compareTo(expectedSummRationalFrac));
    }

    @Test
    public void multipleTwoFracs() {
        RationalFrac firstFrac = new RationalFrac(2,3);
        RationalFrac secondFrac = new RationalFrac(4,5);
        RationalFrac actualMultiple = RationalFrac.multiple(firstFrac,secondFrac);
        Assert.assertEquals(0, actualMultiple.compareTo(expectedMultipleFrac));
    }

}
