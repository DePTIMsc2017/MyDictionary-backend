package hu.unideb.inf.cucumber.util;

import cucumber.api.java.en.Given;

import static hu.unideb.inf.cucumber.util.DriverProvider.getDriver;

/**
 * Created by varadi on 2017.05.20..
 */
public class PageHandler extends Converter{
    @Given("^The user is on login page$")
    public void userIsOnLoginPage() {
        logout();
        getDriver().get("http://localhost:4200/login");
    }

    @Given("^The user is on register page$")
    public void userIsOnRegisterPage() {
        logout();
        getDriver().get("http://localhost:4200/register");
    }

    @Given("^The user is on My words page$")
    public void userIsOnMyWordsPage() {
        logout();
        login();
        getDriver().get("http://localhost:4200/collections");
    }

    @Given ("^The user is on initial page$")
    public void initialPage(){
        getDriver().get("http://localhost:4200/");
    }

    @Given ("^The user is on Exercise lessons page$")
    public void exervisePage(){
        logout();
        login();
        getDriver().get("http://localhost:4200/collections");
    }
}
