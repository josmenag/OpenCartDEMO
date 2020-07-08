package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected By successAlertLocator = By.cssSelector(".alert.alert-success");
    private By errorAlert = By.xpath("//div[contains(@class,'alert-danger')]");
    private By confirmation = By.xpath("//h1[contains(text(),'Account Has Been Created')]");

    WebDriver driver;

    public BasePage(WebDriver _driver){
        driver = _driver;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public Boolean isSuccessMessageVisibleWithText(String text){
        return driver.findElement(successAlertLocator).getText().contains(text);
    }

    public boolean isErrorMessageVisibleWithText(String expectedMessage){
        boolean result = driver.findElement(errorAlert).getText().toLowerCase().trim().equals(expectedMessage);
        return result;
    }

    public boolean isAccountCreatedMessageVisibleWithText(String expectedMessage){
        boolean result = driver.findElement(confirmation).getText().toLowerCase().trim().equals(expectedMessage);
        return result;
    }

}
