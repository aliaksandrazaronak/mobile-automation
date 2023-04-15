package mobile.android;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest extends BaseTest {

    @Test
    public void checkPlusFunctionality() {
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3")).click();
        WebElement results = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview"));
        assertEquals("5", results.getText(), "Result should be equals 5");
    }

    @Test
    public void checkMinusFunctionality() {
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
        WebElement results = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview"));
        assertEquals("1", results.getText(), "Result should be equals 1");
    }
}
