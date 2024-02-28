package pages;

import org.openqa.selenium.By;

public class CheckOutPage extends BasePage{
    public By checkOut = By.xpath("//button[@id='checkout']");
    public By first_name_inputBox = By.xpath("//input[@id='first-name']");
    public By last_name_inputBox = By.xpath("//input[@id='last-name']");
    public By zip_postal_code_inputBox = By.xpath("//input[@id='postal-code']");
    public By continue_Button = By.xpath("//input[@id='continue']");
    public By error_message = By.xpath("//h3[@data-test='error']");



}
