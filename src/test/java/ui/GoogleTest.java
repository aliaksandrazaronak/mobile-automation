package ui;

import org.junit.jupiter.api.Test;

public class GoogleTest extends BaseUITest {


    @Test
    public void checkOpenGoogle() {
        driver.get("https://www.google.com/");
    }

    @Test
    public void checkOpenBarcelona() {
        driver.get("https://www.barcamania.com");
    }

}
