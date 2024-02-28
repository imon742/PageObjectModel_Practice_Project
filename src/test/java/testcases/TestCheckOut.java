package testcases;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.DriverSetup;

public class TestCheckOut extends DriverSetup {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    @Test
    public void purchaseProduct(){
        loginPage.doLogin("standard_user", "secret_sauce");
        productPage.addPrductToCart(productPage.labsBackpack);
        productPage.clickOnElement(productPage.shoppingCart);
        checkOutPage.clickOnElement(checkOutPage.checkOut);
        checkOutPage.writeOnElement(checkOutPage.first_name_inputBox,"AAAAA");
        checkOutPage.writeOnElement(checkOutPage.last_name_inputBox,"BBBBBBB");
        checkOutPage.writeOnElement(checkOutPage.zip_postal_code_inputBox,"12244");
        checkOutPage.clickOnElement(checkOutPage.continue_Button);
    }
}
