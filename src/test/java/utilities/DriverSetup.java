package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetup {

    public static String browserName = System.getProperty("browser", "Chrome");


    private static final ThreadLocal <WebDriver> LOCAL_BROWSER = new ThreadLocal<>();

    public void setBrowser(WebDriver browser) {
        DriverSetup.LOCAL_BROWSER.set(browser);
    }

    // browser re static hisabe declear kora hoise jate kuno object o creat kora na lage.
    public static WebDriver getBrowser() {
        return LOCAL_BROWSER.get();
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

    @BeforeSuite

    public void openABrowser(){
// local_broser theke get korlam
        WebDriver browser = getBrowser(browserName);

//browser maximize korlam ar implicit wait dilam jate kuno element na pele direct error na dey.
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // local_broser theke get kore theb set korlam

        setBrowser(browser);


    }

    @AfterSuite

    public void quiteBrowser(){
        //browser.close();
        getBrowser().quit();
    }
}
