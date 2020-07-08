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

public class UsersProvider {
    @DataProvider(name="getUsersDataFromCode")
    private Object [][] getSearchData(){
        return new Object[][]{
                {new UserAccount("hola@hola.com","hola", true)},
                {new UserAccount("hola@holas.com","holas", false)}
        };
    }


    @DataProvider(name = "getUsersDataFromJson")
    private Object[][] getSearchDataFromJson() throws FileNotFoundException {

        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/data/users.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<UserAccount> testData = new Gson().fromJson(dataSet, new TypeToken<List<UserAccount>>() {}.getType());

        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for(Object[] each : returnValue){
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @DataProvider(name = "getUsersDataFromJsonForRegistration")
    private Object[][] getSearchDataFromJsonForRegistration() throws FileNotFoundException {

        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/data/newUsers.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<UserAccount> testData = new Gson().fromJson(dataSet, new TypeToken<List<UserAccount>>() {}.getType());

        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for(Object[] each : returnValue){
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}