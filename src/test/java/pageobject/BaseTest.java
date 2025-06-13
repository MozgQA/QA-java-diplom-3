package pageobject;

import model.browser.Browser;
import model.browser.BrowserFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected WebDriver driver;

    private static final String URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void setUp() {
        Browser browser = BrowserFactory.createBrowser();
        System.setProperty(getDriverSystemProperty(browser), browser.getDriverPath());
        driver = createWebDriverInstance(browser);
        driver.get(getBaseUrl());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private String getDriverSystemProperty(Browser browser) {
        String browserName = browser.getName().toLowerCase();
        if (browserName.contains("chrome")) {
            return "webdriver.chrome.driver";
        } else if (browserName.contains("yandex")) {
            return "webdriver.yandex.driver";
        }
        throw new IllegalArgumentException("Unsupported browser: " + browser.getName());
    }

    private WebDriver createWebDriverInstance(Browser browser) {
        String browserName = browser.getName().toLowerCase();
        if (browserName.contains("chrome") || browserName.contains("yandex")) {
            return new ChromeDriver();
        }
        throw new IllegalArgumentException("Unsupported browser: " + browser.getName());
    }

    public String getBaseUrl(){
        return URL;
    }
}
