package selenium;

import dataProviders.ProductsProvider;
import dataProviders.SearchProvider;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.ProductProfile;
import pojo.SearchData;

public class ProductTests extends BaseClass{

    @Test(dataProvider = "getProductsDataFromJson", dataProviderClass = ProductsProvider.class)
    @Parameters({"product","id","usd","eur","pnd"})
    public void Test_Correct_Prices(ProductProfile testProduct){

        //ir a url
        homePage().goToProductUrl(testProduct.getId());
        productPage().changeCurrencyToDollars();
        Assert.assertTrue(productPage().isPriceCorrect(testProduct.getUsd()));

        homePage().goToProductUrl(testProduct.getId());
        productPage().changeCurrencyToEuros();
        Assert.assertTrue(productPage().isPriceCorrect(testProduct.getEur()));

        homePage().goToProductUrl(testProduct.getId());
        productPage().changeCurrencyToPounds();
        Assert.assertTrue(productPage().isPriceCorrect(testProduct.getPnd()));
    }


}
