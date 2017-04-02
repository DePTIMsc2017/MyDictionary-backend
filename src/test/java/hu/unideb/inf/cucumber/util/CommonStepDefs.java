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

    @When("^The user types (.*) into E-mail cím$")
    public void typeEmailAdress(String email){
        getDriver().findElement(By.id("inputEmail")).sendKeys(email);
    }

    @When("^The user types (.*) into Jelszó$")
    public void typePassword(String password){
        getDriver().findElement(By.id("inputPassword")).sendKeys(password);
    }

    @When("^The user clicks on (.*) button$")
    public void click(String button){
        switch (button) {
            case "Bejelentkezés":
                getDriver().findElement(By.xpath("//button[@type='submit']")).click();
                break;
            case "Gyakorlás":
                //TODO: ha lesz ID, megírni
                break;
            case "Szavak felvétele":
                //TODO: ha lesz ID, megírni
                break;
            case "Lehetőségek":
                //TODO: ha lesz ID, megírni
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
        typeEmailAdress("teszt@teszt.hu");
        typePassword("teszt");
        click("Bejelentkezés");
    }

    @Then ("^nothing happens, stayed on (.*) page$")
    public void nothingHappened(String beforePage){
        String url ="";
        switch (beforePage) {
            case "initial":
                url = "http://localhost:4200/";
                break;
        }
        Assert.assertEquals(url,getDriver().getCurrentUrl());
    }

    private String getUserJSON() {
        return (String)(((JavascriptExecutor) getDriver()).executeScript("return window.localStorage.getItem('currentUser');"));
    }
}
