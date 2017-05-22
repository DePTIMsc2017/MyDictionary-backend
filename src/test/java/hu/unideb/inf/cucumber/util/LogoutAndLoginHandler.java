package hu.unideb.inf.cucumber.util;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import static hu.unideb.inf.cucumber.util.DriverProvider.getDriver;

/**
 * Created by varadi on 2017.05.20..
 */
public class LogoutAndLoginHandler{
    @Then("^The user is logged in$")
    public void loggedIn(){
        String userJson = getUserJSON();
        Assert.assertNotEquals(null, userJson);
    }

    @Then("^The user is not logged in$")
    public void notLoggedIn(){
        String userJson = getUserJSON();
        Assert.assertEquals(null, userJson);
    }

    protected String getUserJSON() {
        return (String)(((JavascriptExecutor) getDriver()).executeScript("return window.localStorage.getItem('currentUser');"));
    }
}
