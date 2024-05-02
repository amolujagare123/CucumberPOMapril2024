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


    By allRatings = By.xpath("//div[@data-testid='rating-stars']");
    By allStars = By.xpath("//div[@data-testid='rating-stars']/span");

    public int getTotalRating()
    {
        return getDriver().findElements(allRatings).size();
    }

    public int getTotalStars()
    {
        return getDriver().findElements(allStars).size();
    }

    By rawPrice = By.xpath("//span[@data-testid='price-and-discounted-price']");

    public ArrayList<Integer> getPriceList()
    {
        ArrayList<Integer> priceList = new ArrayList<>();
        ArrayList<String> priceListStr = getElementTextList(rawPrice);

        for (String priceStr : priceListStr ) // ₹ 71,245
        {
            String priceWithoutR = priceStr.split(" ")[1]; // 71,245
            String priceWithoutComma = priceWithoutR.replace(",",""); //// 71245
            int price = Integer.parseInt(priceWithoutComma);
            priceList.add(price);
        }

        return priceList;
    }


    By hotelListElement = By.xpath("//div[@data-testid='title']");

    public ArrayList<String> getHotelList()
    {
        return getElementTextList(hotelListElement);
    }



}
