package mobile.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.MalformedURLException;

import static driver.DriverManagerFactory.*;

@Slf4j
public abstract class BaseTest {

    protected AndroidDriver driver;
    private AppiumDriverLocalService service;

    @BeforeEach
    public void setUp() throws MalformedURLException {

        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(() -> "--base-path", "/wd/hub")
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error")
                .usingDriverExecutable (new File("C:\\Program Files\\nodejs\\node.exe"))
                .build();
        service.start();

        log.info("Start webdriver");
        setDriver();
        driver = (AndroidDriver) getDriver();
    }

    @AfterEach
    public void cleanUp() {
        log.info("Close webdriver");
        takeScreenshot();
        getDriver().quit();
        removeDriver();
        service.stop();
    }

    private void takeScreenshot() {
            Allure.addAttachment("Page failure screenshot", new ByteArrayInputStream(((TakesScreenshot)
                    getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
