import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    protected WebDriver driver;

    //Esto corre una vez por ejecución, por cada suite
    @BeforeTest
    public void setUpTest(){
        System.out.println("* Before Test Setup");
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }


    //Esto corre una vez antes de cada método, por ejemplo 'testLoginSuccessful'
    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUpMethod(String browser){
        System.out.println("** Before Method Setup");

        if(browser.equals("firefox"))
            driver = new FirefoxDriver();
        else
            driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

        driver.get("https://demo.opencart.com/index.php");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(){
        System.out.println("*** After Method Tear Down");

        //takeScreenshot(driver);
        driver.close();
        driver.quit();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
