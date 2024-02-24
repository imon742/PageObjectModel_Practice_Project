package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public String loginpageURL = "https://www.saucedemo.com/";
    public String loginPageTitle = "Swag Labs";
    public String email = "standard_user";
    public String password = "secret_sauce";

    public String emailErrorText = "Please enter a valid email address.";

    public By usernameInputBox = By.xpath("//input[@id='user-name']");
    public By passwordInputBox = By.xpath("//input[@id='password']");
    public By loginButton = By.xpath("//input[@id='login-button']");

    public By errorMessage = By.xpath("//h3[@data-test='error']");


    public void doLogin(String email,String password){

        loadWebPage(loginpageURL);
        writeOnElement(usernameInputBox, email);
        writeOnElement(passwordInputBox, password);
        clickOnElement(loginButton);
    }

}
