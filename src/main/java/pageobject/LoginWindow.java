package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginWindow extends AbstractPageObject {

    private static final By EMAIL_FIELD = By.xpath("//input[@name='name']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Войти']");
    private static final By RESTORE_PASSWORD_LINK = By.xpath("//a[text()='Восстановить пароль']");
    private static final By REGISTRATION_LINK = By.xpath("//a[@href='/register']");

    public LoginWindow(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести email: {0}")
    public void inputEmailField(String email) {
        driver.findElement(EMAIL_FIELD).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    @Step("Ввести пароль: {0}")
    public void inputPasswordField(String password) {
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Нажать на кнопку 'Регистрация'")
    public void clickRegistrationLink() {
        driver.findElement(REGISTRATION_LINK).click();
    }

    @Step("Проверить видимость кнопки 'Войти'")
    public boolean isLoginButtonDisplayed() {
        waitElementIsEnabled(LOGIN_BUTTON);
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    @Step("Нажать кнопку 'Восстановить пароль'")
    public void clickRestorePasswordLink() {
        driver.findElement(RESTORE_PASSWORD_LINK).click();
    }
}
