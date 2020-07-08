package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage{
    private By resultsThumbs = By.cssSelector("product-thumb");
    private By firstThumb = By.cssSelector(".img-responsive");
    private static final String ERROR_WHEN_THERE_ARE_NO_RESULTS = "There is no product that matches the search criteria";

    public SearchResultsPage(WebDriver _driver){
        super(_driver);
    }

    public int getThumbsCount(){
        return driver.findElements(resultsThumbs).size();
    }

    public boolean isNoResultsVisible(){
        WebElement contentElement = driver.findElement(By.id("content"));
        return contentElement.getAttribute("innerHTML").contains(ERROR_WHEN_THERE_ARE_NO_RESULTS);
    }

    public void clickFirstItem(){
        driver.findElement(firstThumb).click();
    }
}
