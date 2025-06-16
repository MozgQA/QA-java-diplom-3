package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginWindow extends AbstractPageObject {

    private static final By EMAIL_FIELD = By.xpath("//input[@name='name']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Войти']");
    private static final By RESTORE_PASSWORD_LINK = By.xpath("//a[text()='Восстановить пароль']");
    private static final By REGISTRATION_LINK = By.xpath("//a[@href='/account']");

    public LoginWindow(WebDriver driver) {
        super(driver);
    }

    public void inputEmailField(String email) {
        driver.findElement(EMAIL_FIELD).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    public void inputPasswordField(String password) {
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
    public void clickRegistrationLink() {
        driver.findElement(REGISTRATION_LINK).click();
    }

    public boolean isLoginButtonDisplayed() {
        checkThatElementIsEnabled(LOGIN_BUTTON);
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public void clickRestorePasswordLink() {
        driver.findElement(RESTORE_PASSWORD_LINK).click();
    }
}
