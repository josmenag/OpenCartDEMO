import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoAccount {

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();

    }


    @Test
    public void test_capabilities(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--kiosk");
        options.addArguments("--window-size=1980,800");

        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.seleniumeasy.com");
    }

    @Test
    public void test_waits(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");

        driver.findElement(By.id("downloadButton")).click();

        Assert.assertTrue(
                wait.until(
                        ExpectedConditions.textToBe(
                                By.className("progress-label"),"Complete!")));

        WebElement progreso = driver.findElement(By.className("progress-label"));

        Assert.assertEquals(progreso.getText(),"Complete!");
    }
}
