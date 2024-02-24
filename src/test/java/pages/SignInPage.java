package pages;

import org.openqa.selenium.By;

public class SignInPage extends BasePage{

    public String email = "19202103240@cse.bubt.edu.bd\n";
    public String password = "qPL9Udhpdnj2@y";

    public String emailErrorText = "Please enter a valid email address.";

    public By emailInputBox = By.xpath("//input[@id='iptLgnPlnID']");
    public By passwordInputBox = By.xpath("//input[@id='iptLgnPlnPD']");
    public By rememberMeButton = By.xpath("//label[@for='remIdChkYN']//span");
    public By emailError = By.xpath("//span[@id='react-aria-2']");
    public By loginButton = By.xpath("//button[normalize-space()='Login']");
}
