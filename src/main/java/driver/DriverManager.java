package driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public abstract class DriverManager {

    protected WebDriver driver;
    protected abstract void createDriver() throws MalformedURLException;

    public WebDriver getDriver() throws MalformedURLException {
        if (null == driver) {
            createDriver();
        }
        return driver;
    }
}
