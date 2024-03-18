package driver;

import business.objects.MobileDevice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    protected void createDriver(MobileDevice mobileDevice) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = WebDriverManager.chromedriver().clearDriverCache().create();
    }
}
