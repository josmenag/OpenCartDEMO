import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestAccount {
    private WebDriver driver;

    @Description("Tests that user can correctly login when entering valid credentials")
    @Test(description = "Test Successful Login")
    public void testLoginSuccessful(){

        String email = "hola@hola.com";
        String password = "hola";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.opencart.com/");

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

        takeScreenshot(driver);

        driver.close();
        driver.quit();


    }


    @Description("Tests that login fails as expected when an incorrect username is entered")
    @Test(description = "Test Unsuccessful Login")
    public void testLoginUnsuccessful(){

        String email = "hola@hola-fail.com";
        String password = "hola";
        String expectedMessage = " Warning: No match for E-Mail Address and/or Password.\n";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.opencart.com/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        //enter user information

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();

        //verificacion
        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase().trim(),alertMessage.getText().toLowerCase().trim());

        takeScreenshot(driver);

        driver.close();
        driver.quit();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
