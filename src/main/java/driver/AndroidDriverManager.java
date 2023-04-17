package driver;

import business_objects.MobileDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager extends DriverManager {

    protected void createDriver(MobileDevice mobileDevice) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid(mobileDevice.getUdid());
        options.setSystemPort(mobileDevice.getSystemPort());
        options.setApp("d:\\Projects\\parallel-tests\\Calculator.apk");
        driver = new AndroidDriver(new URL("http://" + mobileDevice.getAppiumIpAddress() + ":" +
                mobileDevice.getAppiumPort() + "/wd/hub"), options);
    }
}
