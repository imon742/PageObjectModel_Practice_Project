package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {


    public String homepageURL = "https://www.excelestore.com.bd/";
    public String HomepageTitle = "National Distributor of Samsung Bangladesh | Excel eStore |";
public By loginLogo = By.xpath("//a[@aria-label='Log-In']");
public By logInButton = By.xpath("//li[@class='gnb__login before-login-context']//div[@class='gnb__login-layer active']//ul[@class='gnb__utility-menu']//li//a[@class='gnb__utility-link']");


}
