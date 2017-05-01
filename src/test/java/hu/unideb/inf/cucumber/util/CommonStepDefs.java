package hu.unideb.inf.cucumber.util;

import static hu.unideb.inf.cucumber.util.DriverProvider.getDriver;
//import static hu.unideb.inf.cucumber.util.DriverProvider.waitForPageLoadAfter;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mates on 2017. 03. 14..
 */
public class CommonStepDefs {
    @Given("^The user is on login page$")
    public void userIsOnLoginPage() {
        getDriver().get("http://localhost:4200/");
        ((JavascriptExecutor) getDriver()).executeScript("window.localStorage.clear();");
        getDriver().get("http://localhost:4200/login");
    }

    public String convertToID(String name){
        String[] words =name.split(" ");
        for(int i = 0; i<words.length;++i){
            words[i] = Character.toUpperCase(words[i].charAt(0))+words[i].substring(1);
        }
        return String.join("",words);
    }

    @When("^The user types (.*) into (.*)$")
    public void type(String typed, String where){
        getDriver().findElement(By.id("input"+convertToID(where))).sendKeys(typed);
    }

    @When("^The user clicks on (.*) button$")
    public void click(String button){
        switch (button) {
            case "Szavak felvétele":
                getDriver().findElement(By.id("buttonGiveWords")).click();
                break;
            default:
                getDriver().findElement(By.id("button"+convertToID(button))).click();
                break;
        }
    }

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

    @Then ("^The (.*) ErrorMessage appears$")
    public void errorMessageDisplayed(String message){
        try {
            Thread.sleep(2000);
        }
        catch (Exception ex){}
        WebElement messageElement = getDriver().findElement(By.xpath("//div[@class='alert alert-danger']"));
        assertThat(messageElement.isDisplayed(), is(true));
        assertThat(messageElement.getText(), is(message));
    }

    @Given ("^The user is on initial page$")
    public void initialPage(){
        userIsOnLoginPage();
        type("teszt","username");
        type("teszt","password");
        click("Login");
    }

    @Then ("^nothing happens, stayed on (.*) page$")
    public void nothingHappened(String beforePage){
        String url ="";
        switch (beforePage) {
            case "initial":
                url = "http://localhost:4200/#";
                break;
        }
        Assert.assertEquals(url,getDriver().getCurrentUrl());
    }

    private String getUserJSON() {
        return (String)(((JavascriptExecutor) getDriver()).executeScript("return window.localStorage.getItem('currentUser');"));
    }
}
