package mobile.android;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest extends BaseTest {

    @Test
    public void checkCalculatorFunctionality() {
        WebElement buttonTwo = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2"));
        buttonTwo.click();

        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3")).click();
        WebElement results = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview"));
        assertEquals("5", results.getText(), "Result should be equals 5");
    }
}
