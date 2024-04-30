package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static stepdefinition.SharedSD.getDriver;

public class SearchResultPage extends Base{


    By popUpCross = By.xpath("//button[contains(@aria-label,'Dismiss')]");

    public void clickPopUpCross()
    {
        clickOn(popUpCross);
    }
    public void clickStarRating(String star)
    {

       By locator = By.xpath("//*[@data-filters-item='class:class="+star+"']");

        clickOn(locator);
    }


    By ratingElement = By.xpath("//div[contains(@aria-label , 'out of 5')]");
    public ArrayList<Integer> getStarRatingList()
    {
        List<WebElement> ratingElementList = getDriver().findElements(ratingElement);

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        ArrayList<Integer> ratingList = new ArrayList<>();
       /* for (int i=0;i<ratingElementList.size();i++)
        {
            String ariaLabel = ratingElementList.get(i).getAttribute("aria-label"); // "4 out of 5"
            String ratingStr = ariaLabel.split(" ")[0];
            int rating = Integer.parseInt(ratingStr);
            ratingList.add(rating);
        }*/
        for (WebElement element : ratingElementList )
        {
            String ariaLabel = element.getAttribute("aria-label"); // "4 out of 5"
            String ratingStr = ariaLabel.split(" ")[0];
            int rating = Integer.parseInt(ratingStr);
            ratingList.add(rating);
        }
        return ratingList;
    }

}
