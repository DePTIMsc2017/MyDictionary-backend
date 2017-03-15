package hu.unideb.inf.cucumber.util;

import static hu.unideb.inf.cucumber.util.DriverProvider.getDriver;
//import static hu.unideb.inf.cucumber.util.DriverProvider.waitForPageLoadAfter;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by mates on 2017. 03. 14..
 */
public class CommonStepDefs {
    @Given("The user signed in")
    public void loggedIn() {
        getDriver().get("http://localhost:8080/");
    }

}
