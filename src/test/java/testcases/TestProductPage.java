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
        productPage.clickOnElement(productPage.labsBackpack);
        Assert.assertEquals(productPage.getElementText(productPage.labsBackpackTitle),"Sauce Labs Backpack");
        productPage.clickOnElement(productPage.addToCartButton);
        productPage.clickOnElement(productPage.removeButton);

    }

    @Test
    public void testAddCart(){
        loginPage.doLogin("standard_user", "secret_sauce");
        productPage.clickOnElement(productPage.labsBackpack);
        productPage.clickOnElement(productPage.addToCartButton);
        Assert.assertTrue(productPage.getElement(productPage.removeButton).isDisplayed());
        Assert.assertEquals(productPage.getElementText(productPage.cartCount), "1");
        productPage.clickOnElement(productPage.removeButton);
    }




}
