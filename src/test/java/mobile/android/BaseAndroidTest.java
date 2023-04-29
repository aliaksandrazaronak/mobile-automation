package mobile.android;

import business_objects.MobileDevice;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ThreadUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.MalformedURLException;

import static driver.DriverManagerFactory.*;

@Slf4j
public abstract class BaseAndroidTest {

    protected AndroidDriver driver;
    private static AppiumDriverLocalService service;

    @RegisterExtension
    static AndroidExtension androidExtension = new AndroidExtension();

    @BeforeAll
    public static void startAppiumServer() {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(() -> "--base-path", "/wd/hub")
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .usingDriverExecutable (new File("C:\\Program Files\\nodejs\\node.exe"))
                .build();
        service.start();
    }

    @BeforeEach
    public void setUp() throws MalformedURLException {
        int deviceIndex = ThreadUtils.getThreadId();
        MobileDevice mobileDevice = androidExtension.getListOfConnectedAndroidMobileDevices().get(deviceIndex);
        log.info("MobileDevice instance for thread " + deviceIndex + " : " + mobileDevice);
        setDriver(mobileDevice);
        driver = (AndroidDriver) getDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterEach
    public void cleanUp() {
        int deviceIndex = ThreadUtils.getThreadId();
        log.info("Close webdriver for thread " + deviceIndex);
        takeScreenshot();
        getDriver().quit();
        removeDriver();
    }

    @AfterAll
    public static void stopAppiumServer() {
        service.stop();
    }

    private void takeScreenshot() {
            Allure.addAttachment("Page failure screenshot", new ByteArrayInputStream(((TakesScreenshot)
                    getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
