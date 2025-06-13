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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest extends BaseTest{
    private static final String INCORRECT_PASSWORD = "1";

    private WebDriver driver;
    private User user;
    private UserClient userClient;
    private String accessToken;


    @Before
    @Description("Открывает страницу приложения, через API создает рандомного пользователя, авторизуется под пользователем, получает токен")
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(getBaseUrl());
        user = UserGenerator.getRandom();
        userClient = new UserClient();
    }

    @After
    @Description("Выходит из браузера, через API удаляет созданного пользователя")
    public void teardown() {
        driver.quit();
        if(accessToken != null) {
            userClient.delete(accessToken, UserCredentials.from(user));
        }
    }

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
        Assert.assertTrue(objLogin.isEntranceButtonDisplayed());
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
