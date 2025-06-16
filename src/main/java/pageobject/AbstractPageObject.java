package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPageObject {

    protected WebDriver driver;

    protected AbstractPageObject(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitElementIsEnabled(By element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            //ловим timeout чтобы тесты корректно завершали работу и удаляли пользователя
            throw new TimeoutException(e);
        }
    }
}
