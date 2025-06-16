package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileWindow extends AbstractPageObject {

    private static final By CONSTRUCTOR_BUTTON = By.xpath(".//p[text() = 'Конструктор']");
    private static final By LOGO_BUTTON = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");
    private static final By LOGOUT_BUTTON = By.xpath(".//button[text()='Выход']");

    public ProfileWindow(WebDriver driver) {
        super(driver);
    }

    public void clickConstructorButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }

    public void clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
    }

    public void clickLogoutButton() {
        checkThatElementIsEnabled(LOGOUT_BUTTON);
        driver.findElement(LOGOUT_BUTTON).click();
    }
}
