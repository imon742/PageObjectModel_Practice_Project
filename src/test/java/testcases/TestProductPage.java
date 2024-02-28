package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import utilities.DriverSetup;

public class TestProductPage extends DriverSetup {
    LoginPage loginPage = new LoginPage();

    ProductPage productPage = new ProductPage();
    @Test

    public void testProductDetails() throws InterruptedException{
        loginPage.doLogin("standard_user", "secret_sauce");
        productPage.clickOnElement(productPage.addToCartButton);
        productPage.clickOnElement(productPage.labsBackpack);
        Thread.sleep(4000);
        productPage.clickOnElement(productPage.RemoveButton);
        Thread.sleep(4000);
        productPage.clickOnElement(productPage.addToCartButton);
        Thread.sleep(4000);
        Assert.assertEquals(productPage.getElementText(productPage.labsBackpackTitle),"Sauce Labs Backpack");



    }

}
