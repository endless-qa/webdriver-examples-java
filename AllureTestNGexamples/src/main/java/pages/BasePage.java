package pages;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    BasePage() {
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = "chrome";
    }

    @Step("Click in the search textbox, type '{item}' text and press ENTER")
    public SearchResultsPage searchFor(String item) {

        $(By.id("twotabsearchtextbox")).setValue(item).pressEnter();
        return new SearchResultsPage();
    }
}