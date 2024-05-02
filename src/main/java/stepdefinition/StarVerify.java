package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchResultPage;

import java.time.Duration;
import java.util.ArrayList;

import static stepdefinition.SharedSD.getDriver;

public class StarVerify {

    SearchResultPage searchResultPage = new SearchResultPage();

    @Given("I am on default locations search result screen")
    public void IAmOnSearchResult()
    {
    //    getDriver().navigate().refresh();
        searchResultPage.clickPopUpCross();
    }

   /* @Given("I am on default locations search result screen")
    public void i_am_on_default_locations_search_result_screen() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/

    @When("^I select option for stars as (.+)$")
    public void iSelectOptionForStarsAs(String star) {
        // 5 star
        searchResultPage.clickStarRating(star.split(" ")[0]);

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void iVerifySystemDisplaysOnlyHotelsOnSearchResult(String star) {
     // 5 star
        getDriver().navigate().refresh();
        int expectedStarValue =  Integer.parseInt(star.split(" ")[0]);


        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        int totalStars = searchResultPage.getTotalStars();
        int totalRating = searchResultPage.getTotalRating();

        int actualStarValue = totalStars / totalRating  ;

        System.out.println("expectedStarValue="+expectedStarValue);
        System.out.println("actualStarValue="+actualStarValue);

        Assert.assertEquals("Incorrect star ratings",
                expectedStarValue,actualStarValue);



    }

    @Then("I verify system displays all hotels within {string} amount")
    public void iVerifySystemDisplaysAllHotelsWithinAmount(String expectedMaxAmountStr) {

        int expectedMaxAmount = Integer.parseInt(expectedMaxAmountStr);

        ArrayList<Integer> priceList = searchResultPage.getPriceList();
        System.out.println(priceList);

        ArrayList<Integer> greaterPriceList = new ArrayList<>();
        boolean flag = true;
        for (int price : priceList)
        {
            if (price>expectedMaxAmount)
            {
                flag = false;
                greaterPriceList.add(price);
            }

        }

        Assert.assertTrue("Some of the prices are greater than "
                +expectedMaxAmountStr
                +"\n Greater Price List :"+greaterPriceList
                ,flag);

    }
    @Then("I verify {string} is within the search result")
    public void iVerifyIsWithinTheSearchResult(String expectedHotelName) {

        ArrayList<String> hotelList = searchResultPage.getHotelList();

        boolean flag = false;
        for (String hotelName : hotelList)
        {
            System.out.println(hotelName);
            if(hotelName.contains(expectedHotelName))
            {
                flag = true;
            }

        }

        Assert.assertTrue(expectedHotelName +
                " is not present in the search result",flag);
    }
}
