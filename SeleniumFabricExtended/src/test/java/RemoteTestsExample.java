import enums.Browser;
import factory.BrowserProvider;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.AmazonMainPage;
import pages.TodaysDealsPage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RemoteTestsExample {

    private RemoteWebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUpClass(Browser browser) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setPlatform(Platform.LINUX);

        driver = BrowserProvider.createDriver(new URL("http://10.200.200.200:4444/wd/hub"), browser);
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
