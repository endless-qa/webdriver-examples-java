package factory;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class BrowserProvider {

    public static WebDriver createDriver(Browser browser, DesiredCapabilities capabilities) {
        capabilities.setBrowserName(browser.toString().toLowerCase());
        return browser.initialize(capabilities);
    }

    public static WebDriver createDriver(Browser browser) {
        return createDriver(browser, new DesiredCapabilities());
    }

    public static RemoteWebDriver createDriver(URL hubUrl, Browser browser, DesiredCapabilities capabilities) {
        capabilities.setBrowserName(browser.toString().toLowerCase());
        return new RemoteWebDriver(hubUrl, capabilities);
    }

    public static RemoteWebDriver createDriver(URL hubUrl, Browser browser) {
        return createDriver(hubUrl, browser, new DesiredCapabilities());
    }
}
