package pageobject;

import client.UserClient;
import generator.UserGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import model.UserCredentials;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends BaseTest {
    private UserClient userClient;
    private User user;
    private String accessToken;

    @Before
    @Description("Создание тестового пользователя через API")
    public void setUp() {
        super.setUp(); // Вызов родительского метода для инициализации драйвера
        user = UserGenerator.getRandom();
        userClient = new UserClient();
        userClient.create(user);
        accessToken = userClient.login(UserCredentials.from(user))
                .extract().path("accessToken");
    }

    @After
    @Description("Удаление тестового пользователя через API")
    public void cleanUp() {
        if (accessToken != null) {
            userClient.delete(accessToken, UserCredentials.from(user));
        }
    }

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
