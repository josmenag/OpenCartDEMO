package dataProviders;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;
import pojo.SearchData;
import pojo.UserAccount;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class SearchProvider {

    @DataProvider(name="getSearchData")
    private Object [][] getSearchData(){
        return new Object[][]{
                {new SearchData("macbook",3)},
                {new SearchData("creativa",0)}
        };
    }

    @DataProvider(name = "getSearchDataFromJson")
    private Object[][] getSearchDataFromJson() throws FileNotFoundException {

        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/data/Search.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<SearchData> testData = new Gson().fromJson(dataSet, new TypeToken<List<SearchData>>() {}.getType());
      //  List<UserAccount> userData = new Gson().fromJson(dataSet, new TypeToken<List<UserAccount>>() {}.getType());

        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for(Object[] each : returnValue){
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}
