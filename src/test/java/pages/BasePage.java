package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.ByteArrayInputStream;

import static utilities.DriverSetup.getBrowser;

public class BasePage {

  //Creating method for findElement
    public WebElement getElement(By locator){
        return getBrowser().findElement(locator);

    }

    //creating method for click

    public void clickOnElement(By locator){
        getElement(locator).click();
    }


    public void writeOnElement(By locator, String text){
        getElement(locator).sendKeys(text);

    }

    public void hoverOnElement(By locator){
        Actions actions = new Actions(getBrowser());
        actions.clickAndHold(getElement(locator)).build().perform();
    }

    public void loadWebPage(String url){
        getBrowser().get(url);
    }
    public String getElementText (By locator){
        return getElement(locator).getText();
    }

    public void takeScreenShort(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getBrowser()).getScreenshotAs(OutputType.BYTES)));
    }
}
