package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationWindow extends AbstractPageObject {

    private static final By NAME_FIELD = By.xpath("//div[.//label[text()='Имя']]//input");
    private static final By EMAIL_FIELD = By.xpath("//label[text()='Email']/following-sibling::input");
    private static final By PASSWORD_FIELD = By.xpath("//label[text()='Пароль']/following-sibling::input\n");
    private static final By REGISTRATION_BUTTON = By.xpath("//button[text()='Зарегистрироваться']");
    private static final By INCORRECT_PASSWORD = By.xpath("//p[text()='Некорректный пароль']");
    private static final By ENTRANCE_BUTTON = By.xpath("//a[text()='Войти']");

    public RegistrationWindow(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести имя")
    public void inputNameField() {
        driver.findElement(NAME_FIELD).click();
        driver.findElement(NAME_FIELD).sendKeys("Васька");
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

    @Step("Нажать кнопку 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        driver.findElement(REGISTRATION_BUTTON).click();
    }

    @Step("Проверить наличие сообщения 'Некорректный пароль'")
    public void checkEnabledIncorrectPasswordField() {
        waitElementIsEnabled(INCORRECT_PASSWORD);
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickEntranceButton() {
        driver.findElement(ENTRANCE_BUTTON).click();
    }
}
