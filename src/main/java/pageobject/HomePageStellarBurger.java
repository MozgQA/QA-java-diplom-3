package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageStellarBurger extends AbstractPageObject {

    private static final By ACCOUNT_LOGIN = By.xpath(".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    private static final By PROFILE_BUTTON = By.xpath(".//header[@class='AppHeader_header__X9aJA pb-4 pt-4']/nav[@class='AppHeader_header__nav__g5hnF']/a[@class='AppHeader_header__link__3D_hX']/p[@class='AppHeader_header__linkText__3q_va ml-2']");
    private static final By BUN_CHAPTER = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect'][1]/span[@class='text text_type_main-default']");
    private static final By SELECTED_BUN_CHAPTER = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div[1]");
    private static final By SAUCE_CHAPTER = By.xpath(".//div[1]/div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect'][1]/span[@class='text text_type_main-default']");
    private static final By SELECTED_SAUCE_CHAPTER = By.xpath(".//div[1]/div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class='text text_type_main-default']");
    private static final By FILLING_CHAPTER = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect'][2]/span[@class='text text_type_main-default']");
    private static final By SELECTED_FILLING_CHAPTER = By.xpath(".//div[1]/div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class='text text_type_main-default']");
    private static final By ORDER_BUTTON = By.xpath(".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    private static final By ASSEMBLE_BURGER_CHAPTER = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/h1[@class='text text_type_main-large mb-5 mt-10']");

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

    public void clickSauceChapter() {
        driver.findElement(SAUCE_CHAPTER).click();
    }

    public void clickFillingChapter() {
        driver.findElement(FILLING_CHAPTER).click();
    }

    public boolean isSelectedBunChapterDisplayed() {
        checkThatElementIsEnabled(SELECTED_BUN_CHAPTER);
        return driver.findElement(SELECTED_BUN_CHAPTER).isDisplayed();
    }

    public boolean isSelectedSauceChapterDisplayed() {
        checkThatElementIsEnabled(SELECTED_SAUCE_CHAPTER);
        return driver.findElement(SELECTED_SAUCE_CHAPTER).isDisplayed();
    }
    public boolean isSelectedFillingChapterDisplayed() {
        checkThatElementIsEnabled(SELECTED_FILLING_CHAPTER);
        return driver.findElement(SELECTED_FILLING_CHAPTER).isDisplayed();
    }
}
