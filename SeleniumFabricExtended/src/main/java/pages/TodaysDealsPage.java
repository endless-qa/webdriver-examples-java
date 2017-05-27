package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TodaysDealsPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@id='gbox-item-0.0.0']//div[text()=\"Today's Deals\"]")
    private WebElement todaysDealsSectionTitle;

    public TodaysDealsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkSectionTitle() {
        System.out.println("This is " + todaysDealsSectionTitle.getText());
    }
}
