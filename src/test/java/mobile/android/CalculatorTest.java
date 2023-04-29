package mobile.android;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.appium.SelenideAppium.$;
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
        $(AppiumBy.id("com.google.android.calculator:id/digit_3")).click();
        $(AppiumBy.id("com.google.android.calculator:id/op_sub")).click();
        $(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
        $(AppiumBy.id("com.google.android.calculator:id/result_preview")).shouldBe(Condition.text("2"));
        log.info("Stopping running minus test");
    }

    @Test
    public void checkComplexPlusFunctionality() {
        log.info("Starting running complex plus test");
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_4")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        WebElement results = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview"));
        assertEquals("10", results.getText(), "Result should be equals 10");
        log.info("Stopping running complex plus test");
    }

    @Test
    public void checkComplexMinusFunctionality() {
        log.info("Starting running complex minus test");
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        WebElement results = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview"));
        assertEquals("5", results.getText(), "Result should be equals 5");
        log.info("Stopping running complex minus test");
    }
}
