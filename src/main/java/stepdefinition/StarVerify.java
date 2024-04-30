package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchResultPage;

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
        getDriver().navigate().refresh();
    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void iVerifySystemDisplaysOnlyHotelsOnSearchResult(String star) {

        ArrayList<Integer> ratingList = searchResultPage.getStarRatingList();
        System.out.println(ratingList);
    }
}
