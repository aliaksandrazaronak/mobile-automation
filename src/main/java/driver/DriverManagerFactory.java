package driver;

import org.openqa.selenium.WebDriver;
import property.PropertyLoader;

import java.net.MalformedURLException;

public class DriverManagerFactory {

    private static ThreadLocal<WebDriver> driverThreadHolder = new ThreadLocal<>();

    public static synchronized void setDriver() throws MalformedURLException {

        WebDriver driver;
        String browserName = System.getProperty("browser", PropertyLoader.getProperty("test.environment.browser"));

        switch (browserName) {
            case "CHROME" -> {
                driver = new ChromeDriverManager().getDriver();
                driverThreadHolder.set(driver);
            }
            case "ANDROID" -> {
                driver = new AndroidDriverManager().getDriver();
                driverThreadHolder.set(driver);
            }
            default -> throw new IllegalArgumentException("Unrecognized browser is selected");
        }
    }

    public static WebDriver getDriver() {
        return driverThreadHolder.get();
    }

    public static void removeDriver() {
        driverThreadHolder.remove();
    }
}
