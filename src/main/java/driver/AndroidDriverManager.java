package driver;

import business.objects.MobileDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

public class AndroidDriverManager extends DriverManager {

    private static final String APPLICATION_PATH = Path.of("").toAbsolutePath() + File.separator + "src"
            + File.separator + "test" + File.separator + "resources" + File.separator + "calculator.apk";

    protected void createDriver(MobileDevice mobileDevice) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.fullReset();
        options.setUdid(mobileDevice.getUdid());
        options.setPlatformName(mobileDevice.getPlatformName());
        options.setSystemPort(mobileDevice.getSystemPort());
        options.setApp(APPLICATION_PATH);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
    }
}
