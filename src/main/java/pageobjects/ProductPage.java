package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductPage extends BasePage{

    //elementos:
    private By productQuantityLocator = By.id("input-quantity");
    private By addToCartButtonLocator = By.id("button-cart");
    private By currencyDropdown = By.cssSelector("#form-currency [data-toggle]");
    private By euroButton = By.name("EUR");
    private By poundsButton = By.name("GBP");
    private By usdButton = By.name("USD");
    private By priceLabel = By.cssSelector("ul:nth-of-type(2)  h2");


    public ProductPage(WebDriver _driver){
        super(_driver);
    }

    public void setAmountToAdd(int amount){
        driver.findElement(productQuantityLocator).sendKeys(String.valueOf(amount));
    }

    public void clickAddToCart(){
        driver.findElement(addToCartButtonLocator).click();
    }

    public void changeCurrencyToEuros(){
        driver.findElement(currencyDropdown).click();
        driver.findElement(euroButton).click();
    }

    public void changeCurrencyToDollars(){
        driver.findElement(currencyDropdown).click();
        driver.findElement(usdButton).click();
    }

    public void changeCurrencyToPounds(){
        driver.findElement(currencyDropdown).click();
        driver.findElement(poundsButton).click();
    }

    public boolean isPriceCorrect(String expectedPrice){
        String actualPrice = driver.findElement(priceLabel).getText();
        actualPrice = actualPrice.replace('$',' ').trim();
        actualPrice = actualPrice.replace('€',' ').trim();
        actualPrice = actualPrice.replace('£',' ').trim();
        System.out.println(actualPrice + "   " + expectedPrice);
        return (expectedPrice.equals(actualPrice));
    }
}
