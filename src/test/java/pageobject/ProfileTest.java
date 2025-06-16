package pageobject;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ProfileTest extends BaseUserTest {

    @Test
    @DisplayName("Тест на переход по клику на Личный кабинет")
    public void checkClickAtProfile() {
        HomePageStellarBurger homePage = new HomePageStellarBurger(driver);
        homePage.clickProfileButton();
        LoginWindow loginWindow = new LoginWindow(driver);
        Assert.assertTrue("Кнопка входа не отображается", loginWindow.isLoginButtonDisplayed());
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
                loginWindow.isLoginButtonDisplayed());
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
