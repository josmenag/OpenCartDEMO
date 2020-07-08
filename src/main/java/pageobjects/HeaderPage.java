package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends BasePage{

    //elementos:
    private By myAccountLink = By.xpath("//span[text()='My Account']");
    private By loginButton = By.linkText("Login");
    private By logoutLocator = By.xpath("//a[text()='Logout']");
    private By searchField = By.name("search");
    private By registerButton = By.linkText("Register");

    public HeaderPage(WebDriver _driver){
        super(_driver);
    }

    public void clickOnMyAccountLink(){
        WebElement myAccount = driver.findElement(myAccountLink);
        myAccount.click();
    }

    public void clickOnLogin(){
        WebElement login = driver.findElement(loginButton);
        login.click();
    }

    public void clickOnRegister(){
        WebElement login = driver.findElement(registerButton);
        login.click();
    }

    public boolean isLogoutEnabled(){
        return driver.findElement(logoutLocator).isEnabled();
    }

    public void goToLogin(){
        this.clickOnMyAccountLink();
        this.clickOnLogin();
    }

    public void goToRegister(){
        this.clickOnMyAccountLink();
        this.clickOnRegister();
    }

    public boolean isLogoutLinkEnabled(){
        this.clickOnMyAccountLink();
        return this.isLogoutEnabled();
    }

    public void search(String searchCriteria){
        driver.findElement(searchField).sendKeys(searchCriteria, Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.urlContains(String.format("macbook+air")));
    }
}
