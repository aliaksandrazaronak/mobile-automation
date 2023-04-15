package ui;

import org.junit.jupiter.api.Test;

public class GoogleTest extends BaseTest {


    @Test
    public void checkOpenGoogle() {
        driver.get("https://www.google.com/");
    }

    @Test
    public void checkOpenBarcelona() {
        driver.get("https://www.fcbarcelona.com/en/");
    }

}
