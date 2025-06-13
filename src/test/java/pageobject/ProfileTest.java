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

public class ProfileTest extends BaseTest {
    private UserClient userClient;
    private User user;
    private String accessToken;

    @Before
    @Description("Создание тестового пользователя через API")
    public void setUp() {
        super.setUp(); // Инициализация драйвера через BaseTest
        user = UserGenerator.getRandom();
        userClient = new UserClient();
        userClient.create(user);
        accessToken = userClient.login(UserCredentials.from(user))
                .extract().path("accessToken");
    }

    @After
    @Description("Удаление тестового пользователя через API")
    public void tearDown() {
        if (accessToken != null) {
            userClient.delete(accessToken, UserCredentials.from(user));
        }
    }

    @Test
    @DisplayName("Тест на переход по клику на Личный кабинет")
    public void checkClickAtProfile() {
        HomePageStellarBurger homePage = new HomePageStellarBurger(driver);
        homePage.clickProfileButton();
        LoginWindow loginWindow = new LoginWindow(driver);
        Assert.assertTrue("Кнопка входа не отображается", loginWindow.isEntranceButtonDisplayed());
    }

    @Test
    @DisplayName("Тест на переход по клику Конструктор из Личного кабинета")
    public void checkClickAtConstructor() {
        performLogin();
        HomePageStellarBurger homePage = new HomePageStellarBurger(driver);
        homePage.clickProfileButton();
        ProfileWindow profileWindow = new ProfileWindow(driver);
        profileWindow.clickConstructorButton();
        Assert.assertTrue("Раздел 'Соберите бургер' не отображается",
                homePage.isAssembleBurgerChapterDisplayed());
    }

    @Test
    @DisplayName("Тест на переход к логотипу из Личного кабинета")
    public void checkClickAtLogo() {
        performLogin();
        HomePageStellarBurger homePage = new HomePageStellarBurger(driver);
        homePage.clickProfileButton();
        ProfileWindow profileWindow = new ProfileWindow(driver);
        profileWindow.clickLogoButton();
        Assert.assertTrue("Раздел 'Соберите бургер' не отображается",
                homePage.isAssembleBurgerChapterDisplayed());
    }

    @Test
    @DisplayName("Тест на разлогинирование")
    public void checkLogout() {
        performLogin();
        HomePageStellarBurger homePage = new HomePageStellarBurger(driver);
        homePage.clickProfileButton();
        ProfileWindow profileWindow = new ProfileWindow(driver);
        profileWindow.clickLogoutButton();
        LoginWindow loginWindow = new LoginWindow(driver);
        Assert.assertTrue("Кнопка входа не отображается после выхода",
                loginWindow.isEntranceButtonDisplayed());
    }

    private void performLogin() {
        HomePageStellarBurger homePage = new HomePageStellarBurger(driver);
        homePage.clickAccountLogin();
        LoginWindow loginWindow = new LoginWindow(driver);
        loginWindow.inputEmailField(user.getEmail());
        loginWindow.inputPasswordField(user.getPassword());
        loginWindow.clickLoginButton();
    }
}
