package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager extends DriverManager {

    protected void createDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid("emulator-5554");
        options.setApp("d:\\Projects\\parallel-tests\\Calculator.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
    }
}
