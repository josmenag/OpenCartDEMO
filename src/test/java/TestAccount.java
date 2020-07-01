import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestAccount extends BaseClass{

    @Description("Tests that user can correctly login when entering valid credentials")
    @Test(description = "Test Login Success", groups = "Successful")
    public void testLoginSuccessful(){
        System.out.println("*** Test");

        String email = "hola@hola.com";
        String password = "hola";

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        //enter user information

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();

        //verificacion
        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Logout']"));
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        Assert.assertTrue(logoutButton.isDisplayed());
    }

    @Ignore
    @Description("Tests that login fails as expected when an incorrect username is entered")
    @Test(description = "Test Login Fail", groups = "Unsuccessful")
    public void testLoginUnsuccessful(){
        System.out.println("*** Test");

        String email = "hola@hola-fail.com";
        String password = "hola";
        String expectedMessage = " Warning: No match for E-Mail Address and/or Password.\n";

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        //enter user information

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();

        //verificacion
        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase().trim(),alertMessage.getText().toLowerCase().trim());
    }
}
