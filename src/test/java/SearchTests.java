import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends BaseClass{

    @Test
    public void searchTest(){
        String testEntry = "Macbook";
        int expectedResultsCount = 3;
        WebElement searchEntry = driver.findElement(By.name("search"));
        searchEntry.sendKeys(testEntry, Keys.ENTER);

        Assert.assertTrue(driver.getCurrentUrl().contains(String.format("search=%s", testEntry)));
        List<WebElement> results = driver.findElements(By.cssSelector(".product-thumb"));

        Assert.assertEquals(results.size(), expectedResultsCount, String.format("Was expecting %s, but got %s", expectedResultsCount, results.size()));
    }
}
