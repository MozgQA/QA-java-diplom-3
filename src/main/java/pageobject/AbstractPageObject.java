package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageObject {

    protected WebDriver driver;

    protected AbstractPageObject(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickElement(By element) {
        driver.findElement(element).click();
    }

    protected void checkThatElementIsEnabled(By element) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(element));
        Assert.assertTrue(driver.findElement(element).isEnabled());
    }

    protected String  getTextOfElement(By element){
        return driver.findElement(element).getText();
    }
}
