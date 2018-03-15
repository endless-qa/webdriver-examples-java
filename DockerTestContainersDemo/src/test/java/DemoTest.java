import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

public class DemoTest {

    @Rule
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer().
            withDesiredCapabilities(DesiredCapabilities.chrome());

    @Test
    public void demoTest() {
        RemoteWebDriver driver = chrome.getWebDriver();

        driver.get("http://amazon.com");
        System.out.println(driver.getTitle());
    }
}
