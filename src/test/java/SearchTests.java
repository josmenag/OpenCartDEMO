import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends BaseClass{

    @Test(groups = "search")
    @Parameters({"searchCriteria","expectedResults"})
    public void searchTest(@Optional("default") String searchCriteria,@Optional("0") int expectedResults){

        WebElement searchEntry = driver.findElement(By.name("search"));
        searchEntry.sendKeys(searchCriteria, Keys.ENTER);


        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains(String.format("search=%s", searchCriteria)));
        Assert.assertTrue(driver.getCurrentUrl().contains(String.format("search=%s", searchCriteria)));

        List<WebElement> results = driver.findElements(By.cssSelector("product-thumb"));
        Assert.assertEquals(results.size(), expectedResults, String.format("Was expecting %s, but got %s", expectedResults, results.size()));
    }
}
