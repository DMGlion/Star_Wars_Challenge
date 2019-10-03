import ModelObjects.ResupplyPerSpaceShipPerDistance;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserActionScannerTest {
    UserActionScanner userActionScanner = new UserActionScanner();


    //This test will pass eventually if they don't change the quantity of spaceships on the API
    @Test
    public void callCalculation() {
        List<ResupplyPerSpaceShipPerDistance> result = userActionScanner.callCalculation("10000");
        Assert.assertEquals(result.size(), 37);
    }

    @Test
    public void callCalculationIndividualExpectedResults() {
        List<ResupplyPerSpaceShipPerDistance> result = userActionScanner.callCalculation("10000000");
        Assert.assertEquals(result.get(0).getResuply(), "4.0");
        Assert.assertEquals(result.get(1).getResuply(), "195.0");
        Assert.assertEquals(result.get(2).getResuply(), "38.0");
        Assert.assertEquals(result.get(3).getResuply(), "91.0");
        Assert.assertEquals(result.get(4).getResuply(), "744.0");
        Assert.assertEquals(result.get(5).getResuply(), "595.0");
        Assert.assertEquals(result.get(6).getResuply(), "793.0");
        Assert.assertEquals(result.get(7).getResuply(), "195.0");
        Assert.assertEquals(result.get(8).getResuply(), "136.0");
        Assert.assertEquals(result.get(9).getResuply(), "14.0");
        Assert.assertEquals(result.get(10).getResuply(), "9.0");
        Assert.assertEquals(result.get(11).getResuply(), "496.0");
        Assert.assertEquals(result.get(12).getResuply(), "654.0");
        Assert.assertEquals(result.get(13).getResuply(), "unknown");
        Assert.assertEquals(result.get(14).getResuply(), "unknown");
        Assert.assertEquals(result.get(15).getResuply(), "unknown");
        Assert.assertEquals(result.get(16).getResuply(), "unknown");
        Assert.assertEquals(result.get(17).getResuply(), "unknown");
        Assert.assertEquals(result.get(18).getResuply(), "unknown");
        Assert.assertEquals(result.get(19).getResuply(), "unknown");
        Assert.assertEquals(result.get(20).getResuply(), "unknown");
        Assert.assertEquals(result.get(21).getResuply(), "9.0");
        Assert.assertEquals(result.get(22).getResuply(), "unknown");
        Assert.assertEquals(result.get(23).getResuply(), "unknown");
        Assert.assertEquals(result.get(24).getResuply(), "unknown");
        Assert.assertEquals(result.get(25).getResuply(), "114.0");
        Assert.assertEquals(result.get(26).getResuply(), "unknown");
        Assert.assertEquals(result.get(27).getResuply(), "unknown");
        Assert.assertEquals(result.get(28).getResuply(), "unknown");
        Assert.assertEquals(result.get(29).getResuply(), "unknown");
        Assert.assertEquals(result.get(30).getResuply(), "unknown");
        Assert.assertEquals(result.get(31).getResuply(), "unknown");
        Assert.assertEquals(result.get(32).getResuply(), "833.0");
        Assert.assertEquals(result.get(33).getResuply(), "unknown");
        Assert.assertEquals(result.get(34).getResuply(), "unknown");
        Assert.assertEquals(result.get(35).getResuply(), "19.0");
        Assert.assertEquals(result.get(36).getResuply(), "unknown");
    }

    @Test
    public void validateUserInputMGLT() {
        boolean result = userActionScanner.validateUserInput("10000");
        Assert.assertTrue(result);
    }

    @Test
    public void validateUserInputMGLTBellowZero() {
        boolean result = userActionScanner.validateUserInput("-1");
        Assert.assertFalse(result);
    }

    @Test
    public void validateUserInputMGLTOverMaxInt() {
        boolean result = userActionScanner.validateUserInput("2147483648");
        Assert.assertFalse(result);
    }

    @Test
    public void validateUserInputMGLTNotNumerical() {
        boolean result = userActionScanner.validateUserInput("testing");
        Assert.assertFalse(result);
    }

    @Test
    public void validateUserInputMGLTMixNumericalAndOTherCharacters() {
        boolean result = userActionScanner.validateUserInput("b6987ceb678");
        Assert.assertFalse(result);
    }

    @Test
    public void validateFunctionInputUserInvalidString() {
        boolean result =userActionScanner.validateFunctionInputUser("start1");
        Assert.assertFalse(result);
    }

    @Test
    public void validateFunctionInputUserValidString() {
        boolean result =userActionScanner.validateFunctionInputUser("start");
        Assert.assertTrue(result);
    }

    //This is a valid input but we don'' want to execute the calculation
    @Test
    public void validateFunctionInputUserValidStringQuit() {
        boolean result =userActionScanner.validateFunctionInputUser("quit");
        Assert.assertFalse(result);
    }

    @Test
    public void validateFunctionInputUserValidStringOnlyNumbers() {
        boolean result =userActionScanner.validateFunctionInputUser("quit");
        Assert.assertFalse(result);
    }
}
