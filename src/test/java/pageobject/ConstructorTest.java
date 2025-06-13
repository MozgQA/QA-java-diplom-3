package pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Тест на переход к разделу Булки")
    @Description("Проверяет переход по клику на раздел Булки на главной странице")
    public void checkClickBunChapter() {
        HomePageStellarBurger homePage = new HomePageStellarBurger(driver);
        homePage.clickSauceChapter();
        homePage.clickBunChapter();
        Assert.assertTrue("Раздел 'Булки' не активен", homePage.isSelectedBunChapterDisplayed());
    }

    @Test
    @DisplayName("Тест на переход к разделу Соусы")
    @Description("Проверяет переход по клику на раздел Соусы на главной странице")
    public void checkClickSauceChapter() {
        HomePageStellarBurger homePage = new HomePageStellarBurger(driver);
        homePage.clickSauceChapter();
        Assert.assertTrue("Раздел 'Соусы' не активен", homePage.isSelectedSauceChapterDisplayed());
    }

    @Test
    @DisplayName("Тест на переход к разделу Начинки")
    @Description("Проверяет переход по клику на раздел Начинки на главной странице")
    public void checkClickFillingChapter() {
        HomePageStellarBurger homePage = new HomePageStellarBurger(driver);
        homePage.clickFillingChapter();
        Assert.assertTrue("Раздел 'Начинки' не активен", homePage.isSelectedFillingChapterDisplayed());
    }
}
