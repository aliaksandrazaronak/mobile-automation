package page.objects.ui;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage {

    @FindBy(id = "yearFilter")
    private SelenideElement yearRegistrationIcon;

    @FindBy(xpath = "//button[contains(@data-qa-selector, 'cookie-consent-accept-all')]")
    private SelenideElement acceptAllCookieButton;

    @FindBy(id = "yearFrom")
    private SelenideElement startYearRegistrationSelector;

    @FindBy(id = "sortBy")
    private SelenideElement sortControlSelector;

    @FindBy(xpath = "//div[@data-qa-selector='price']")
    private ElementsCollection carsPricesLabels;

    public SearchPage acceptAllCookieButton() {
        acceptAllCookieButton.click();
        return this;
    }

    public SearchPage clickYearRegistrationIcon() {
        yearRegistrationIcon.click();
        return this;
    }

    public SearchPage selectStartYearRegistrationFrom(String option) {
        var registrationSelector = new Select(startYearRegistrationSelector);
        registrationSelector.selectByVisibleText(option);
        return this;
    }

    public SearchPage selectSortBy(String option) {
        var controlSelector = new Select(sortControlSelector);
        controlSelector.selectByVisibleText(option);
        return this;
    }

    public List<String> getAllCarsPrices() {
        carsPricesLabels.shouldHave(CollectionCondition.sizeGreaterThan(0));
        return carsPricesLabels.texts().stream().map(price -> price.split(" ")[0]).collect(Collectors.toList());
    }
}
