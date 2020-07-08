package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumUtils {

    WebDriver driver;

    public SeleniumUtils(WebDriver driver){
        this.driver = driver;
    }

    public void clearAndEnterText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
}
