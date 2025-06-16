package pageobject;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseUserTest {

    @Test
    @DisplayName("Тест на вход на главной странице")
    public void checkLoginAtHomePage() {
        HomePageStellarBurger homePage = new HomePageStellarBurger(driver);
        homePage.clickAccountLogin();
        performLogin();
        Assert.assertTrue("Кнопка заказа не отображается", homePage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Тест на вход из личного кабинета")
    public void checkLoginFromProfile() {
        HomePageStellarBurger homePage = new HomePageStellarBurger(driver);
        homePage.clickProfileButton();
        performLogin();
        Assert.assertTrue("Кнопка заказа не отображается", homePage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Тест на вход из формы регистрации")
    public void checkLoginFromRegistrationForm() {
        HomePageStellarBurger homePage = new HomePageStellarBurger(driver);
        homePage.clickAccountLogin();
        LoginWindow loginWindow = new LoginWindow(driver);
        loginWindow.clickRegistrationLink();
        new RegistrationWindow(driver).clickEntranceButton();
        performLogin();
        Assert.assertTrue("Кнопка заказа не отображается", homePage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Тест на вход из формы восстановления пароля")
    public void checkLoginFromRestorePasswordLink() {
        HomePageStellarBurger homePage = new HomePageStellarBurger(driver);
        homePage.clickAccountLogin();
        LoginWindow loginWindow = new LoginWindow(driver);
        loginWindow.clickRestorePasswordLink();
        new RestorePasswordWindow(driver).clickEntranceLink();
        performLogin();
        Assert.assertTrue("Кнопка заказа не отображается", homePage.isOrderButtonDisplayed());
    }

    private void performLogin() {
        LoginWindow loginWindow = new LoginWindow(driver);
        loginWindow.inputEmailField(user.getEmail());
        loginWindow.inputPasswordField(user.getPassword());
        loginWindow.clickLoginButton();
    }
}
