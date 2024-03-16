package page.objects.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class MainCalculatorScreen {

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
    private SelenideElement digitTwoButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_3")
    private SelenideElement digitThreeButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_add")
    private SelenideElement plusButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_sub")
    private SelenideElement minusButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_preview")
    private SelenideElement resultScreenTextLabel;

    @Step("Click on '2' button")
    public MainCalculatorScreen clickOnDigitTwoButton() {
        digitTwoButton.click();
        return this;
    }

    @Step("Click on '3' button")
    public MainCalculatorScreen clickOnDigitThreeButton() {
        digitThreeButton.click();
        return this;
    }

    @Step("Click on '+' button")
    public MainCalculatorScreen clickOnPlusButton() {
        plusButton.click();
        return this;
    }

    @Step("Click on '-' button")
    public MainCalculatorScreen clickOnMinusButton() {
        minusButton.click();
        return this;
    }

    @Step("Get operation result value")
    public String geOperationResultValue() {
        return resultScreenTextLabel.getText();
    }

}
