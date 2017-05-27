package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMainPage {

    private WebDriver driver;
    private static final String MAIN_URL = "https://www.amazon.com/";

    @FindBy(xpath = "//*[@id='nav-xshop']/a[text() = \"Today's Deals\"]")
    private WebElement todaysDealsMenuItem;

    public AmazonMainPage(WebDriver driver) {
        this.driver = driver;
        driver.navigate().to(MAIN_URL);
        PageFactory.initElements(driver, this);
    }

    public TodaysDealsPage openTodaysDeals() {
        todaysDealsMenuItem.click();
        return new TodaysDealsPage(driver);
    }
}
