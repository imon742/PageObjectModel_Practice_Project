package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverSetup {
    public WebDriver browser ;
    public static String browserName = System.getProperty("browser", "Chrome");
    @BeforeSuite

    public void openABrowser(){
      browser = getBrowser(browserName);
      browser.manage().window().maximize();


    }

    @AfterSuite

    public void quiteBrowser(){
        //browser.close();
        browser.quit();
    }

    public WebDriver getBrowser(String browserName){

        if (browserName.equalsIgnoreCase("Chrome"))
             return new ChromeDriver();
        else if (browserName.equalsIgnoreCase("Edge"))
            return new EdgeDriver();
        else if (browserName.equalsIgnoreCase("Firefox"))
            return new FirefoxDriver();
        else {
            throw new RuntimeException("Browser is not available with the given name: " + browserName);
        }
    }
}
