package selenium;

import org.openqa.selenium.WebDriver;
import pageobjects.*;
import sun.jvm.hotspot.asm.Register;

import java.awt.*;

public class PageObjectHandler {

    WebDriver driver;

    private HeaderPage headerPage;
    private LoginPage loginPage;
    private SearchResultsPage searchResultsPage;
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private RegisterPage registerPage;
    private MenuSuperior menuSuperior;
    private ShoppingCartPage shoppingCartPage;

    public PageObjectHandler(){ }

    public void pagesCleanUp(){
        headerPage = null;
        loginPage = null;
        searchResultsPage = null;
        homePage = null;
        productPage = null;
        cartPage = null;
        registerPage = null;
        menuSuperior = null;
        shoppingCartPage = null;
    }

    protected void initDriver(WebDriver driver){
        this.driver = driver;
    }

    public HeaderPage headerPage(){
        if(headerPage == null)
            headerPage = new HeaderPage(driver);
        return headerPage;
    }

    public LoginPage loginPage(){
        if(loginPage == null)
            loginPage = new LoginPage(driver);
        return loginPage;
    }

    public SearchResultsPage searchResultsPage() {
        if(searchResultsPage == null)
            searchResultsPage = new SearchResultsPage(driver);
        return searchResultsPage;
    }

    public HomePage homePage() {
        if(homePage == null)
            homePage = new HomePage(driver);
        return homePage;
    }

    public ProductPage productPage() {
        if(productPage == null)
            productPage = new ProductPage(driver);
        return productPage;
    }


    public CartPage cartPage() {
        if(cartPage == null)
            cartPage = new CartPage(driver);
        return cartPage;
    }

    public RegisterPage registerPage() {
        if (registerPage == null)
            registerPage = new RegisterPage(driver);
        return registerPage;
    }

    public MenuSuperior menuSuperior() {
        if (menuSuperior == null)
            menuSuperior = new MenuSuperior(driver);
        return menuSuperior;
    }

    public ShoppingCartPage shoppingCartPage() {
        if (shoppingCartPage == null)
            shoppingCartPage = new ShoppingCartPage(driver);
        return shoppingCartPage;
    }

}
