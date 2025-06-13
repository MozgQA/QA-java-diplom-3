package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordWindow extends AbstractPageObject {

    private static final By ENTRANCE_LINK = By.xpath(".//div/p[@class='undefined text text_type_main-default text_color_inactive mb-4']/a[@class='Auth_link__1fOlj']");

    public RestorePasswordWindow(WebDriver driver) {
        super(driver);
    }

    public void clickEntranceLink() {
        driver.findElement(ENTRANCE_LINK).click();
    }
}