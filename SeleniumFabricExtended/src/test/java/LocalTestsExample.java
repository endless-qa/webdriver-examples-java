import enums.Browser;
import factory.BrowserProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.AmazonMainPage;
import pages.TodaysDealsPage;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class LocalTestsExample {

    private WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUpClass(Browser browser) throws MalformedURLException {
        driver = BrowserProvider.createDriver(browser);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void CodeIconLoadingTest() {
        AmazonMainPage amazonMain = new AmazonMainPage(driver);
        TodaysDealsPage todaysDeals = amazonMain.openTodaysDeals();
        todaysDeals.checkSectionTitle();
    }

    @AfterClass
    public void tearDownTest() {
        if(driver!=null) {
            driver.quit();
        }
    }
}
