package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordWindow extends AbstractPageObject {

    private static final By ENTRANCE_LINK = By.xpath("//a[text()='Войти']");

    public RestorePasswordWindow(WebDriver driver) {
        super(driver);
    }

    public void clickEntranceLink() {
        driver.findElement(ENTRANCE_LINK).click();
    }
}