package ui;

import business.objects.MobileDevice;
import com.codeborne.selenide.WebDriverRunner;
import extension.AfterTestExecutor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.net.MalformedURLException;

import static driver.DriverManagerFactory.*;

@Slf4j
@ExtendWith(AfterTestExecutor.class)
public abstract class BaseUITest {

    @BeforeEach
    public void setUp() throws MalformedURLException {
        log.info("Start webdriver");
        setDriver(MobileDevice.builder().build());
        WebDriverRunner.setWebDriver(getDriver());
    }

    @AfterEach
    public void cleanUp() {
        log.info("Close webdriver");
        getDriver().quit();
        removeDriver();
    }
}
