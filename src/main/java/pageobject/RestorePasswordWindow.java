package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordWindow extends AbstractPageObject {

    private static final By ENTRANCE_LINK = By.xpath("//a[text()='Войти']");

    public RestorePasswordWindow(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать на ссылку 'Войти' при восстановлении пароля")
    public void clickEntranceLink() {
        driver.findElement(ENTRANCE_LINK).click();
    }
}