package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileWindow extends AbstractPageObject {

    private static final By CONSTRUCTOR_BUTTON = By.xpath(".//p[text() = 'Конструктор']");
    private static final By LOGO_BUTTON = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");
    private static final By LOGOUT_BUTTON = By.xpath(".//button[text()='Выход']");

    public ProfileWindow(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать на кнопку 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }

    @Step("Нажать на логотип")
    public void clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
    }

    @Step("Нажать на кнопку 'Выход'")
    public void clickLogoutButton() {
        waitElementIsEnabled(LOGOUT_BUTTON);
        driver.findElement(LOGOUT_BUTTON).click();
    }
}
