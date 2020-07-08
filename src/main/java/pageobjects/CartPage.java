package pageobjects;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private String productRowLocator = "//div[@id='content']//tr[contains(.,'<product>')]";
    private WebElement productRow;

    private By inputOnRowLocator = By.cssSelector("input");

    public CartPage(WebDriver _driver){
        super(_driver);
    }

    public void goTo(){
        MenuSuperior menuSuperior = new MenuSuperior(driver);
        menuSuperior.clickShoppingCart();
    }

    public boolean isProductOnCartByName(String product){
        productRow = driver.findElement(By.xpath(productRowLocator.replace("<product>", product)));
        return productRow.isDisplayed();
    }

    public int getAmountFromProductRow(){
        String amount = productRow.findElement(inputOnRowLocator).getAttribute("value");

        try{
            return Integer.parseInt(amount);
        }catch (NumberFormatException ex){
            System.out.println("Error al parsear" );
            return 0;
        }
    }
}
