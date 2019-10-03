import org.junit.Assert;
import org.junit.Test;

public class UserActionScannerTest {
    UserActionScanner userActionScanner = new UserActionScanner();

    @Test
    public void callCalculation() {
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
