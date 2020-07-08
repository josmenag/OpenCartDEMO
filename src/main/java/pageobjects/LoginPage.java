package pageobjects;

import com.sun.xml.internal.rngom.parse.host.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{

    private By emailFieldLocater = By.name("email");
    private By passwordFieldLocater = By.name("password");
    private By loginButton = By.cssSelector("[value='Login']");

    public LoginPage(WebDriver _driver){
        super(_driver);
    }

    public void enterEmail(String email){
        driver.findElement(emailFieldLocater).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(passwordFieldLocater).sendKeys(password);
    }

    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void loginWithCredentials(String _email, String _password){
        this.enterEmail(_email);
        this.enterPassword(_password);
        clickOnLoginButton();
    }

}
