package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class AmazonMainPage extends BasePage{

    public AmazonMainPage() {
        open("https://www.amazon.com");
    }

    @Step("Find the Today's Deals menu item and click on it")
    public TodaysDealPage enterTodaysDeal() {
        $(By.linkText("Today's Deals")).click();
        return new TodaysDealPage();
    }
}
