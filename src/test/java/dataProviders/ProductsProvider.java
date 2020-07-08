package dataProviders;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;
import pojo.ProductProfile;
import pojo.UserAccount;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ProductsProvider {

    @DataProvider(name="getProductsDataFromCode")
    private Object [][] getSearchData(){
        return new Object[][]{
                {new ProductProfile("iPhone","40", "123.20", "106.04", "92.93")},
                {new ProductProfile("iMac","41", "122.00", "105.01", "92.03")}
        };
    }




    @DataProvider(name = "getProductsDataFromJson")
    private Object[][] getSearchDataFromJson() throws FileNotFoundException {

        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/data/productsAndPrices.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<ProductProfile> testData = new Gson().fromJson(dataSet, new TypeToken<List<ProductProfile>>() {}.getType());

        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for(Object[] each : returnValue){
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}