package mobile.android;

import io.appium.java_client.AppiumBy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CalculatorTest extends BaseAndroidTest {

    @Test
    public void checkPlusFunctionality() {
        log.info("Starting running plus test");
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3")).click();
        WebElement results = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview"));
        assertEquals("5", results.getText(), "Result should be equals 5");
        log.info("Stopping running plus test");
    }

    @Test
    public void checkMinusFunctionality() {
        log.info("Starting running minus test");
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
        WebElement results = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview"));
        assertEquals("1", results.getText(), "Result should be equals 1");
        log.info("Stopping running minus test");
    }
}
