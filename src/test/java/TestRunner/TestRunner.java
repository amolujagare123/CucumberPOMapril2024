package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features"
        ,glue = "stepdefinition"
        ,tags = "@starverify"
        , plugin = {"pretty"
        ,"html:target/cucumber-reports.html",
        "json:target/cucumber.json"}
        //  , dryRun = true


)
public class TestRunner {
}
