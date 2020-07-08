package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By getFirstProductTitle = By.cssSelector(".caption a");
    private String firstH4By = "//h4/a[text()='<name>']";
    private String baseProductURL = "https://demo.opencart.com/index.php?route=product/product&product_id=";


    public HomePage(WebDriver _driver){
        super(_driver);
    }

    public String getFirstProductName(){
        return driver.findElement(getFirstProductTitle).getText();
    }

    public String goToProductURL(){
        String firstProduct = getFirstProductName();
        driver.findElement(By.xpath(firstH4By.replace("<name>", firstProduct))).click();
        return firstProduct;
    }

    public String selectProductByName(String name){
        String firstProduct = getFirstProductName();
        driver.findElement(By.xpath(firstH4By.replace("<name>", name)));
        return firstProduct;
    }

    public void goToProductUrl(String append){
        String url = baseProductURL.concat(append);
        driver.navigate().to(url);
    }

}
