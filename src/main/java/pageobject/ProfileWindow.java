package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileWindow extends AbstractPageObject {

    private static final By CONSTRUCTOR_BUTTON = By.xpath(".//nav[@class='AppHeader_header__nav__g5hnF']/ul[@class='AppHeader_header__list__3oKJj']/li[1]/a[@class='AppHeader_header__link__3D_hX']/p[@class='AppHeader_header__linkText__3q_va ml-2']");
    private static final By LOGO_BUTTON = By.xpath(".//nav[@class='AppHeader_header__nav__g5hnF']/div[@class='AppHeader_header__logo__2D0X2']/a");
    private static final By LOGOUT_BUTTON = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive'][text()='Выход']");

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
