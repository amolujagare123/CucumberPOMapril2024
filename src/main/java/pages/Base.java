package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static stepdefinition.SharedSD.getDriver;

public class Base {

   public WebElement webAction(By locator)
   {
       Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
               .withTimeout(Duration.ofSeconds(50)) // max time
               .pollingEvery(Duration.ofSeconds(5)) // every 5 seconds
               .ignoring(NoSuchElementException.class)
               .ignoring(StaleElementReferenceException.class)
               .ignoring(ElementClickInterceptedException.class)
               .ignoring(ElementNotInteractableException.class)
               .ignoring(ArithmeticException.class)
               .ignoring(Exception.class)
               .withMessage(
                       "WebDriver waited for 50 seconds but still " +
                               "could not find the element therefore " +
                               "Timeout Exception has been thrown");

       WebElement element = wait.until(new Function<WebDriver, WebElement>() {
           public WebElement apply(WebDriver driver)
           {
               return driver.findElement(locator);
           }
       });

       return element;
   }

   // 1. click
    public void clickOn(By locator)
    {
        webAction(locator).click();
    }


    // 2. set value ( sendkeys )
    public void setValue(By locator,String value)
    {
        webAction(locator).sendKeys(value);
    }
    // 3. get Text
    public String getElementText(By locator)
    {
        return webAction(locator).getText();
    }

    // 4. drop down
    public void selectFromDropDown(By locator,String value)
    {
        WebElement wb = webAction(locator);
        Select sel = new Select(wb);
        sel.selectByVisibleText(value);
    }

    // 5. get element text list
    public ArrayList<String> getElementTextList(By locator)
    {

        List<WebElement> wbList = getDriver().findElements(locator);

        ArrayList<String> txtList = new ArrayList<>();

        for (int i=0;i< wbList.size();i++)
            txtList.add(wbList.get(i).getText());

        return txtList;

    }
}
