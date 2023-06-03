package mobile.android;

import business_objects.MobileDevice;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import utils.ThreadUtils;

import java.io.File;
import java.net.MalformedURLException;

import static driver.DriverManagerFactory.*;

@Slf4j
@ExtendWith(AfterTestExecutor.class)
public abstract class BaseAndroidTest {

    protected AndroidDriver driver;
    private static AppiumDriverLocalService service;

    @RegisterExtension
    static MobileDeviceConnector mobileDeviceConnector = new MobileDeviceConnector();

    @BeforeAll
    public static void startAppiumServer() {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(() -> "--base-path", "/wd/hub")
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .withAppiumJS (
                        new File (System.getProperty("user.home") + "\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .usingDriverExecutable (new File("C:\\Program Files\\nodejs\\node.exe"))
                .build();
        service.start();
    }

    @BeforeEach
    public void setUp() throws MalformedURLException {
        int deviceIndex = ThreadUtils.getThreadId();
        MobileDevice mobileDevice = mobileDeviceConnector.getListOfConnectedAndroidMobileDevices().get(deviceIndex);
        log.info("MobileDevice instance for thread " + deviceIndex + " : " + mobileDevice);
        setDriver(mobileDevice);
        driver = (AndroidDriver) getDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterEach
    public void cleanUp() {
        int deviceIndex = ThreadUtils.getThreadId();
        log.info("Close webdriver for thread " + deviceIndex);
        getDriver().quit();
        removeDriver();
    }

    @AfterAll
    public static void stopAppiumServer() {
        service.stop();
    }
}
