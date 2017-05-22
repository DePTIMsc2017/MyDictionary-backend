package hu.unideb.inf.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Created by mates on 2017. 03. 14..
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = {"json:target/report.json", "pretty"},
        features={"src/test/resources/hu.unideb.inf/cucumber/Login.feature","src/test/resources/hu.unideb.inf/cucumber/InitialPage.feature","src/test/resources/hu.unideb.inf/cucumber/Registration.feature"},
        glue = {"hu.unideb.inf.cucumber.login","hu.unideb.inf.cucumber.initialPage","hu.unideb.inf.cucumber.util"})
public class testIT {
}
