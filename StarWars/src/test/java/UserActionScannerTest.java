import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserActionScannerTest {
    UserActionScanner userActionScanner = new UserActionScanner();

    @Test
    public void callCalculation() {
    }

    @Test
    public void validateUserInput() {

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
