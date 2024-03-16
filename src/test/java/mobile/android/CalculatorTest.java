package mobile.android;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import page.objects.android.MainCalculatorScreen;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CalculatorTest extends BaseAndroidTest {

    @Test
    public void checkPlusFunctionality() {
        var mainCalculatorScreen = page(MainCalculatorScreen.class);
        String operationResult = mainCalculatorScreen.clickOnDigitTwoButton()
                                     .clickOnPlusButton()
                                     .clickOnDigitThreeButton()
                                     .geOperationResultValue();
        assertEquals("5", operationResult, "Result should be equals 5");
    }

    @Test
    public void checkMinusFunctionality() {
        var mainCalculatorScreen = page(MainCalculatorScreen.class);
        String operationResult = mainCalculatorScreen.clickOnDigitThreeButton()
                                     .clickOnMinusButton()
                                     .clickOnDigitTwoButton()
                                     .geOperationResultValue();
        assertEquals("1", operationResult, "Result should be equals 1");
    }
}
