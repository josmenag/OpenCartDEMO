package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{

    private By firstNameField = By.name("firstname");
    private By lastnameField = By.name("lastname");
    private By emailField = By.name("email");
    private By telephoneField = By.name("telephone");
    private By passwordField = By.name("password");
    private By confirmField = By.name("confirm");
    private By agreeCheckbox = By.name("agree");
    private By continueButton = By.cssSelector("input[value='Continue']");


    public RegisterPage(WebDriver _driver){
        super(_driver);
    }

    public void enterFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driver.findElement(lastnameField).sendKeys(lastName);
    }

    public void enterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterTelephone(String telephone){
        driver.findElement(telephoneField).sendKeys(telephone);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterPasswordConfirmation(String confirmation){driver.findElement(confirmField).sendKeys(confirmation); }

    public void checkAgree(){driver.findElement(agreeCheckbox).click(); }

    public void clickContinue(){driver.findElement(continueButton).click();}

    public void registerNewUser(String _firstName, String _lastName, String _email, String _telephone, String _password){
        this.enterFirstName(_firstName);
        this.enterLastName(_lastName);
        this.enterEmail(_email);
        this.enterTelephone(_telephone);
        this.enterPassword(_password);
        this.enterPasswordConfirmation(_password);
        this.checkAgree();
        this.clickContinue();
    }

}
