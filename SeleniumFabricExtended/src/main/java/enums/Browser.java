package enums;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum Browser {

    FIREFOX {
        @Override
        public WebDriver initialize(DesiredCapabilities capabilities) {
            synchronized (BrowserManager.class) {
                FirefoxDriverManager.getInstance().setup();
                return new FirefoxDriver(capabilities);
            }
        }
    },

    CHROME {
        @Override
        public WebDriver initialize(DesiredCapabilities capabilities) {
            synchronized (BrowserManager.class) {
                ChromeDriverManager.getInstance().setup();
                return new ChromeDriver(capabilities);
            }
        }
    },

    IE {
        @Override
        public WebDriver initialize(DesiredCapabilities capabilities) {
            synchronized (BrowserManager.class) {
                InternetExplorerDriverManager.getInstance().setup();
                return new InternetExplorerDriver(capabilities);
            }
        }
    },

    EDGE {
        @Override
        public WebDriver initialize(DesiredCapabilities capabilities) {
            synchronized (BrowserManager.class) {
                EdgeDriverManager.getInstance().setup();
                return new EdgeDriver(capabilities);
            }
        }
    },

    OPERA {
        @Override
        public WebDriver initialize(DesiredCapabilities capabilities) {
            synchronized (BrowserManager.class) {
                OperaDriverManager.getInstance().setup();
                return new OperaDriver(capabilities);
            }
        }
    },

    PHANTOMJS {
        @Override
        public WebDriver initialize(DesiredCapabilities capabilities) {
            synchronized (BrowserManager.class) {
                PhantomJsDriverManager.getInstance().setup();
                return new PhantomJSDriver(capabilities);
            }
        }
    },

    HTMLUNIT {
        @Override
        public WebDriver initialize(DesiredCapabilities capabilities) {
            return new HtmlUnitDriver(capabilities);
        }
    };


    public abstract WebDriver initialize(DesiredCapabilities capabilities);


    @Override
    public String toString() {
        switch (this) {
            case FIREFOX: return "FIREFOX";
            case CHROME: return "CHROME";
            case IE: return "IE";
            case EDGE: return "EDGE";
            case OPERA: return "OPERA";
            case PHANTOMJS: return "PHANTOMJS";
            case HTMLUNIT: return "HTMLUNIT";
            default: throw new IllegalArgumentException();
        }
    }
}
