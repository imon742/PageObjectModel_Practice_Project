package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    public String productPageURL = "https://www.saucedemo.com/inventory.html";

    public By labsBackpack = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
    public By labsBackpackTitle = By.xpath("//div[@class='inventory_details_name large_size']");
    public By labsBackpackAddToCartButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    public By labsBackpackRemoveButton = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    public By cartCount = By.xpath("//span[@class='shopping_cart_badge']");
    public By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");

}
