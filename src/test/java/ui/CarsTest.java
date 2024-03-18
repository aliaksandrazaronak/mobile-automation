package ui;

import com.google.common.collect.Ordering;
import org.junit.jupiter.api.Test;
import page.objects.ui.SearchPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarsTest extends BaseUITest {

    public static final String SEARCH_PAGE_URL = "https://www.autohero.com/de/search/";
    private static final String REGISTRATION_YEAR = "2020";
    private static final String SORT_OPTION = "Höchster Preis";
    @Test
    public void checkSearchFunctionality() {
        var searchPage = open(SEARCH_PAGE_URL, SearchPage.class);
        searchPage.acceptAllCookieButton()
                .clickYearRegistrationIcon()
                .selectStartYearRegistrationFrom(REGISTRATION_YEAR)
                .selectSortBy(SORT_OPTION);

        List<String> carsPrices = searchPage.getAllCarsPrices();
        System.out.println("Cars prices = " + carsPrices);
        boolean sorted = Ordering.natural().reverse().isOrdered(carsPrices);
        assertTrue(sorted, "Cars prices aren't sorted by desc");
    }

}
