package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePageStellarBurger extends AbstractPageObject {

    private static final By ACCOUNT_LOGIN = By.xpath("//button[text()='Войти в аккаунт']");
    private static final By PROFILE_BUTTON = By.xpath("//a[@href='/account']");
    private static final By BUN_CHAPTER = By.xpath("//div[span[text()='Булки']]");
    private static final By SAUCE_CHAPTER = By.xpath("//div[span[text()='Соусы']]");
    private static final By FILLING_CHAPTER = By.xpath("//div[span[text()='Начинки']]");
    private static final By ORDER_BUTTON = By.xpath("//button[text()='Оформить заказ']");
    private static final By ASSEMBLE_BURGER_CHAPTER = By.xpath("//h1[text()='Соберите бургер']");

    public HomePageStellarBurger(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать на кнопку 'Войти в аккаунт'")
    public void clickAccountLogin() {
        driver.findElement(ACCOUNT_LOGIN).click();
    }

    @Step("Проверить видимость кнопки 'Оформить заказ'")
    public boolean isOrderButtonDisplayed() {
        waitElementIsEnabled(ORDER_BUTTON);
        return driver.findElement(ORDER_BUTTON).isDisplayed();
    }

    @Step("Нажать на кнопку личный кабинет")
    public void clickProfileButton() {
        driver.findElement(PROFILE_BUTTON).click();
    }

    @Step("Проверить видимость заголовка 'Соберите бургер'")
    public boolean isAssembleBurgerChapterDisplayed() {
        waitElementIsEnabled(ASSEMBLE_BURGER_CHAPTER);
        return driver.findElement(ASSEMBLE_BURGER_CHAPTER).isDisplayed();
    }

    @Step("Нажать на раздел 'Булки'")
    public void clickBunChapter() {
        driver.findElement(BUN_CHAPTER).click();
    }

    @Step("Нажать на раздел 'Соусы'")
    public void clickSauceChapter(){
        driver.findElement(SAUCE_CHAPTER).click();
    }

    @Step("Нажать на раздел 'Начинки'")
    public void clickFillingChapter() {
        driver.findElement(FILLING_CHAPTER).click();
    }

    @Step("Проверить активность раздела 'Булки'")
    public boolean isSelectedBunChapterDisplayed() {
        return isCurrentDisplayed(BUN_CHAPTER);
    }

    @Step("Проверить активность раздела 'Соусы'")
    public boolean isSelectedSauceChapterDisplayed() {
        return isCurrentDisplayed(SAUCE_CHAPTER);
    }

    @Step("Проверить активность раздела 'Начинки'")
    public boolean isSelectedFillingChapterDisplayed() {
        return isCurrentDisplayed(FILLING_CHAPTER);
    }

    private Boolean isCurrentDisplayed(By by) {
        return driver.findElement(by).isDisplayed() && driver.findElement(by).getAttribute("class").contains("current");
    }
}
