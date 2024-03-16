package ui;

import business.objects.MobileDevice;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;

import static driver.DriverManagerFactory.*;

@Slf4j
public abstract class BaseUITest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        log.info("Start webdriver");
        setDriver(MobileDevice.builder().build());
        driver = getDriver();
    }

    @AfterEach
    public void cleanUp() {
        log.info("Close webdriver");
        takeScreenshot();
        getDriver().quit();
        removeDriver();
    }

    private void takeScreenshot() {
        Allure.addAttachment("Page failure screenshot", new ByteArrayInputStream(((TakesScreenshot)
                getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
