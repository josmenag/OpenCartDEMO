package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuSuperior extends BasePage {

    private By shoppingCartLocator = By.xpath("//span[text()='Shopping Cart']");

    public MenuSuperior(WebDriver _driver){
        super(_driver);
    }

    public void clickShoppingCart(){
        driver.findElement(shoppingCartLocator).click();
    }


}
