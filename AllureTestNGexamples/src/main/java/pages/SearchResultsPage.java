package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {

    private ElementsCollection results = $$(By.className("s-item-container"));

    @Step("Make sure that search results contain more than {expectedSize} item (-s)")
    public SearchResultsPage withResultsMoreThan(int expectedSize) {
        results.shouldHave(sizeGreaterThan(expectedSize));
        return this;
    }

    @Step("Get the first found result")
    public ItemPage getFirstFound() {
        results.first().find("a > h2").click();
        return new ItemPage();
    }

    @Step("Make sure that the found item has the '{title}' in the title")
    public void firstItemTitleContains(String title) {
        results.first().shouldHave(text(title));
    }
}

