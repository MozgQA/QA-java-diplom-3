package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginWindow extends AbstractPageObject {

    private static final By EMAIL_FIELD = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][1]/div[@class='input__container']/div[@class='input pr-6 pl-6 input_type_text input_size_default']/input[@class='text input__textfield text_type_main-default']");
    private static final By SELECTED_EMAIL_FIELD = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][1]/div[@class='input__container']/div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@class='text input__textfield text_type_main-default']");
    private static final By PASSWORD_FIELD = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][2]/div[@class='input__container']/div[@class='input pr-6 pl-6 input_type_password input_size_default']/input[@class='text input__textfield text_type_main-default']");
    private static final By SELECTED_PASSWORD_FIELD = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][2]/div[@class='input__container']/div[@class='input pr-6 pl-6 input_type_password input_size_default input_status_active']/input[@class='text input__textfield text_type_main-default']");
    private static final By ENTRANCE_BUTTON = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private static final By LOGIN_BUTTON = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private static final By RESTORE_PASSWORD_LINK = By.xpath(".//div/p[@class='undefined text text_type_main-default text_color_inactive']/a[@class='Auth_link__1fOlj']");
    private static final By REGISTRATION_LINK = By.xpath(".//div/p[@class='undefined text text_type_main-default text_color_inactive mb-4']/a[@class='Auth_link__1fOlj']");

    public LoginWindow(WebDriver driver) {
        super(driver);
    }

    public void inputEmailField(String email) {
        driver.findElement(EMAIL_FIELD).click();
        driver.findElement(SELECTED_EMAIL_FIELD).sendKeys(email);
    }

    public void inputPasswordField(String password) {
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(SELECTED_PASSWORD_FIELD).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
    public void clickRegistrationLink() {
        driver.findElement(REGISTRATION_LINK).click();
    }

    public boolean isEntranceButtonDisplayed() {
        checkThatElementIsEnabled(ENTRANCE_BUTTON);
        return driver.findElement(ENTRANCE_BUTTON).isDisplayed();
    }

    public void clickRestorePasswordLink() {
        driver.findElement(RESTORE_PASSWORD_LINK).click();
    }
}
