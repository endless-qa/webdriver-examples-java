package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class TodaysDealPage {

    private ElementsCollection results = $$(By.xpath("//div[contains(@id,'100_dealView_')]"));

    @Step("Make sure that Today's Deals page contains more than {expectedSize} item (-s)")
    public TodaysDealPage withResultsMoreThan(int expectedSize) {
        results.shouldHave(sizeGreaterThan(expectedSize));
        return this;
    }

    @Step("Make sure that the first item on the page has the '{label}' label")
    public void firstItemHasLabel(String label) {
        results.first().shouldHave(text(label));
    }
}