package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
}
