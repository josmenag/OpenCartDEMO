package selenium;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.MenuSuperior;

public class AddToCartTests extends BaseClass{

    @Description("Verify that add to cart works fine")
    @Test(description = "Add to Cart Tests")
    public void Test_Add_To_Cart_Successful(){

        int amount = 2;

        //String testProduct = homePage().selectFirstProductAndGetName();

        productPage().setAmountToAdd(amount);


        productPage().clickAddToCart();
        //Assert.assertTrue(productPage().isSuccessMessageVisibleWithText(testProduct));

        cartPage().goTo();
        //Assert.assertTrue(cartPage().isProductOnCartByName(testProduct));
    }

    @Description("Verify that checking out after adding to cart works fine")
    @Test(description = "Checkout Tests")
    public void Test_Checkout_Successful(){

        //buscar Macbook Air en barra de busqueda
        headerPage().search("Macbook Air");

        //hacer click en el thumb
        searchResultsPage().clickFirstItem();

        //hacer click en add to cart
        productPage().clickAddToCart();

        //hacer click en shopping cart
        menuSuperior().clickShoppingCart();

        //hacer verificaciones en shopping cart
        shoppingCartPage().isAlertPresent();

        //hacer click en checkout
        shoppingCartPage().clickOnCheckoutButton();

        //verificar el mensaje de error
        shoppingCartPage().isAlertPresent();
    }

}
