import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestAccount extends BaseClass{

    @Description("Test that login feature works fine")
    @Test(description = "Test Login Success", groups = "successful")
    public void Test_Login_Successful(){
        System.out.println("*** Test");

        // go to login page
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        // enter user information
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);

        // click submit
        driver.findElement(By.cssSelector("[value='Login']")).click();

        // verificacion
        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Logout']"));
        driver.findElement(By.xpath("//span[text()='My Account']")).click();

        Assert.assertTrue(logoutButton.isEnabled());

    }

    @Description("Test that login feature works fine when incorrect username")
    @Test(description = "Test Login Fail", groups = "failure")
    public void Test_Login_Unsuccessful(){
        System.out.println("*** Test");

        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";

        // go to login page
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        // enter user information
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);

        // click submit
        driver.findElement(By.cssSelector("[value='Login']")).click();

        // verificacion
        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));

        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());
    }



}
