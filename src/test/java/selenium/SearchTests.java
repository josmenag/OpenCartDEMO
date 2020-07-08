package selenium;

import dataProviders.SearchProvider;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.HeaderPage;
import pageobjects.SearchResultsPage;
import pojo.SearchData;

public class SearchTests extends BaseClass{

    @Test(dataProvider = "getSearchData", dataProviderClass = SearchProvider.class)
    @Parameters({"searchCriteria","expectedResults"})
    public void searchTest(SearchData testSearchData){

        headerPage().search(testSearchData.getSearchCriteria());

        if (testSearchData.getExpectedResults() > 0){
            int results = searchResultsPage().getThumbsCount();

            Assert.assertEquals(results, testSearchData.getExpectedResults(),
                    String.format("Was expecting %s, but got %s", testSearchData.getExpectedResults(), results));
        }else{
            Assert.assertTrue(searchResultsPage().isNoResultsVisible(), "Error message was not displayed");
        }

    }


}
