package testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SignInPage;
import utilities.DataSet;
import utilities.DriverSetup;

public class TestLogin extends DriverSetup {
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Test

    public void testLogin(){
        getBrowser().get(homePage.homepageURL);

        homePage.hoverOnElement(homePage.loginLogo);
        homePage.clickOnElement(homePage.logInButton);

        signInPage.writeOnElement(signInPage.emailInputBox, signInPage.email);
        signInPage.writeOnElement(signInPage.passwordInputBox,signInPage.password);
        signInPage.clickOnElement(signInPage.rememberMeButton);
        signInPage.clickOnElement(signInPage.loginButton);

        //login Test
        getBrowser().get(loginPage.loginpageURL);
        loginPage.writeOnElement(loginPage.usernameInputBox, "standard_user");
        loginPage.writeOnElement(loginPage.passwordInputBox, "secret_sauce");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertEquals(getBrowser().getCurrentUrl(), productPage.productPageURL);


        getBrowser().get(loginPage.loginpageURL);
        loginPage.writeOnElement(loginPage.usernameInputBox, loginPage.email);
        loginPage.writeOnElement(loginPage.passwordInputBox, loginPage.password);
        loginPage.clickOnElement(loginPage.loginButton);

    }


    @Test(description = "Test with valid credentials")
    @Description("User trying to login with valid username and password")
    @Severity(SeverityLevel.BLOCKER)

    //first e sanity testcase gula automate korte hbe. Valid user name password diye login kore use kora jabe kina ensure hote hbe
    public void testloginWithValidCrendentials(){
        getBrowser().get(loginPage.loginpageURL);
        loginPage.writeOnElement(loginPage.usernameInputBox, "standard_user");
        loginPage.takeScreenShort("After enter Username");
        loginPage.writeOnElement(loginPage.passwordInputBox, "secret_sauce");
        loginPage.takeScreenShort("After enter password");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertEquals(getBrowser().getCurrentUrl(), productPage.productPageURL);
        loginPage.takeScreenShort("After login successful");
    }

    @Test

    //negative test case
    public void testloginWithInvalidPassword(){
        getBrowser().get(loginPage.loginpageURL);
        loginPage.writeOnElement(loginPage.usernameInputBox, "standard_user");
        loginPage.writeOnElement(loginPage.passwordInputBox, "secret_sauce_");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMessage), "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void testloginWithoutUserIdandPassword(){
        getBrowser().get(loginPage.loginpageURL);
        loginPage.writeOnElement(loginPage.usernameInputBox, "");
        loginPage.writeOnElement(loginPage.passwordInputBox,"");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMessage), "Epic sadface: Username is required");
    }
    @Test
    public void testloginWithoutUserId(){
        getBrowser().get(loginPage.loginpageURL);
        loginPage.writeOnElement(loginPage.usernameInputBox, "");
        loginPage.writeOnElement(loginPage.passwordInputBox, "secret_sauce_");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMessage), "Epic sadface: Username is required");
    }



//Data driven testing:  Now using Data Provider allocation of TestNg

    @Test(dataProvider = "invalidUserData", dataProviderClass = DataSet.class)
    public void testloginWithDataProvider(String username, String password, String errorMessage){
        getBrowser().get(loginPage.loginpageURL);
        loginPage.writeOnElement(loginPage.usernameInputBox, username);
        loginPage.writeOnElement(loginPage.passwordInputBox, password);
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMessage), errorMessage);
    }


}
