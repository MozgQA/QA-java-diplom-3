package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationWindow extends AbstractPageObject {

    private static final By NAME_FIELD = By.xpath("//div[label[text()='Имя']]/input");
    private static final By EMAIL_FIELD = By.xpath("//div[label[text()='Email']]/input");
    private static final By PASSWORD_FIELD = By.xpath("//div[label[text()='Пароль']]/input");
    private static final By REGISTRATION_BUTTON = By.xpath("//button[text()='Зарегистрироваться']");
    private static final By INCORRECT_PASSWORD = By.xpath("//p[text()='Некорректный пароль']");
    private static final By ENTRANCE_BUTTON = By.xpath("//button[text()='Войти']");

    public RegistrationWindow(WebDriver driver) {
        super(driver);
    }

    public void inputNameField() {
        driver.findElement(NAME_FIELD).click();
        driver.findElement(NAME_FIELD).sendKeys("James");
    }

    public void inputEmailField(String email) {
        driver.findElement(EMAIL_FIELD).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    public void inputPasswordField(String password) {
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void clickRegistrationButton() {
        driver.findElement(REGISTRATION_BUTTON).click();
    }

    public void checkEnabledIncorrectPasswordField() {
        checkThatElementIsEnabled(INCORRECT_PASSWORD);
    }

    public void clickEntranceButton() {
        driver.findElement(ENTRANCE_BUTTON).click();
    }
}
