package driver;

import business.objects.MobileDevice;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public abstract class DriverManager {

    protected WebDriver driver;
    protected abstract void createDriver(MobileDevice mobileDevice) throws MalformedURLException;

    public WebDriver getDriver(MobileDevice mobileDevice) throws MalformedURLException {
        if (null == driver) {
            createDriver(mobileDevice);
        }
        return driver;
    }
}
