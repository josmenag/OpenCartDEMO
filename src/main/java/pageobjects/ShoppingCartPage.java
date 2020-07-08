package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ShoppingCartPage extends BasePage{
    private By alertMessage = By.xpath("//div[contains(text(),' not available')]");
    private By checkoutButton = By.xpath("//a[text()='Checkout']");
    private static final String NOT_AVAILABLE_ALERT = "Products marked with *** are not available in the desired quantity or not in stock!";


    public ShoppingCartPage(WebDriver _driver){
        super(_driver);
    }

    public boolean isAlertPresent(){
        return(driver.findElement(alertMessage).isDisplayed());
    }

    public void clickOnCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }



}
