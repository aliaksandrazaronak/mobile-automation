package extension;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static driver.DriverManagerFactory.getDriver;

public class AfterTestExecutor implements AfterTestExecutionCallback {

    private void takeScreenshot() {
        Allure.addAttachment("Failure screenshot", new ByteArrayInputStream(((TakesScreenshot)
                getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isPresent()) {
            takeScreenshot();
        }
    }
}
