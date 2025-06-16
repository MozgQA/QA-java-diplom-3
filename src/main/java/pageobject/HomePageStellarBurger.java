package pageobject;

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

    public void clickAccountLogin() {
        driver.findElement(ACCOUNT_LOGIN).click();

    }

    public boolean isOrderButtonDisplayed() {
        checkThatElementIsEnabled(ORDER_BUTTON);
        return driver.findElement(ORDER_BUTTON).isDisplayed();
    }

    public void clickProfileButton() {
        driver.findElement(PROFILE_BUTTON).click();
    }

    public boolean isAssembleBurgerChapterDisplayed() {
        checkThatElementIsEnabled(ASSEMBLE_BURGER_CHAPTER);
        return driver.findElement(ASSEMBLE_BURGER_CHAPTER).isDisplayed();
    }

    public void clickBunChapter() {
        driver.findElement(BUN_CHAPTER).click();
    }

    public void clickSauceChapter(){
        driver.findElement(SAUCE_CHAPTER).click();
    }

    public void clickFillingChapter() {
        driver.findElement(FILLING_CHAPTER).click();
    }

    public boolean isSelectedBunChapterDisplayed() {
        return isCurrentDisplayed(BUN_CHAPTER);
    }

    public boolean isSelectedSauceChapterDisplayed() {
        return isCurrentDisplayed(SAUCE_CHAPTER);
    }
    public boolean isSelectedFillingChapterDisplayed() {
        return isCurrentDisplayed(FILLING_CHAPTER);
    }

    private Boolean isCurrentDisplayed(By by) {
        return driver.findElement(by).isDisplayed() && driver.findElement(by).getAttribute("class").contains("current");
    }
}
