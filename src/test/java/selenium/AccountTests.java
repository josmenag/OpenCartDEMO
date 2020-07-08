package selenium;

import dataProviders.UsersProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;

import pageobjects.HeaderPage;
import pageobjects.LoginPage;
import pojo.UserAccount;
import utils.DataUtils;

public class AccountTests extends BaseClass{

    //crear un pojo y usarlo en el test
    //crear un json
    //creat un datasource que lea el json
    //apuntar el test al datasouerce
    //quitar los parametros del searchsuite.xml
    //dejar solo 1 metodo en Account Tests

    private static final String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
    private static final String creationConfirmationMessage = "Your Account Has Been Created!";

    @Description("Test that login feature works fine")
    @Test(description = "Test Login Success", dataProvider = "getUsersDataFromJson", dataProviderClass = UsersProvider.class)
    @Parameters({"email","password"})
    public void Test_Login_Successful(UserAccount userAccount){

        headerPage().goToLogin();

        //log in
        loginPage().loginWithCredentials(userAccount.getEmail(), userAccount.getPassword());

        // verificacion
        if (userAccount.shouldLogin()){
            Assert.assertTrue(headerPage().isLogoutLinkEnabled());
        }else{
            Assert.assertTrue(loginPage().isErrorMessageVisibleWithText(expectedMessage.toLowerCase()));
        }
    }


    @Description("Test that registration feature works fine")
    @Test(description = "Test Registration Success", dataProvider = "getUsersDataFromJsonForRegistration", dataProviderClass = UsersProvider.class)
    public void Test_Registration_Successful(UserAccount user){

        headerPage().goToRegister();

        registerPage().registerNewUser(user.getFirstName(), user.getLastName(), DataUtils.getRandomEmail(), user.getTelephone(), user.getPassword());

        //verificacion
        Assert.assertTrue(registerPage().isAccountCreatedMessageVisibleWithText(creationConfirmationMessage.toLowerCase()));
    }

}
