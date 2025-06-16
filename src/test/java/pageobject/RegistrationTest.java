package pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.UserCredentials;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest extends BaseUserTest{
    private static final String INCORRECT_PASSWORD = "11111";

    @Test
    @DisplayName("Тест на успешную регистрацию")
    @Description("Проверяет успешную регистрацию пользователя")
    public void checkSuccessRegistration() {
        HomePageStellarBurger objHomePage = new HomePageStellarBurger(driver);
        objHomePage.clickAccountLogin();
        LoginWindow objLogin = new LoginWindow(driver);
        objLogin.clickRegistrationLink();
        RegistrationWindow objRegistration = new RegistrationWindow(driver);
        objRegistration.inputNameField();
        objRegistration.inputEmailField(user.getEmail());
        objRegistration.inputPasswordField(user.getPassword());
        objRegistration.clickRegistrationButton();
        Assert.assertTrue(objLogin.isLoginButtonDisplayed());
        accessToken = userClient.login(UserCredentials.from(user))
                .extract().path("accessToken");
    }

    @Test
    @DisplayName("Тест на регистрацию с неверным паролем")
    @Description("Проверяет появление ошибки 'Некорректный пароль' при регистрации пользователя с некорректным паролем")
    public void checkRegistrationWithIncorrectPassword() {
        HomePageStellarBurger objHomePage = new HomePageStellarBurger(driver);
        objHomePage.clickAccountLogin();
        LoginWindow objLogin = new LoginWindow(driver);
        objLogin.clickRegistrationLink();
        RegistrationWindow objRegistration = new RegistrationWindow(driver);
        objRegistration.inputNameField();
        objRegistration.inputEmailField(user.getEmail());
        objRegistration.inputPasswordField(INCORRECT_PASSWORD);
        objRegistration.clickRegistrationButton();
        accessToken = userClient.login(UserCredentials.from(user))
                .extract().path("accessToken");
        objRegistration.checkEnabledIncorrectPasswordField();
    }
}
