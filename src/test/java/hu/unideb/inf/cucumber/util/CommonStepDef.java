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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mates on 2017. 03. 14..
 */
public class CommonStepDef extends Converter {
    @Override
    @When("^The user types (.*) into (.*)$")
    public void type(String typed, String where) {
        super.type(typed, where);
    }

    @Override
    @When("^The user clicks on (.*) button$")
    public void click(String button) {
        super.click(button);
    }

    @Override
    @When("^The user clicks on (.*) card")
    public void clickToCard(String card) {
        super.clickToCard(card);
    }

    @Then("^The (.*) button is disabled$")
    public void buttonIsThisabled(String button) {
        Assert.assertNotNull(getDriver().findElement(By.id(convertButtonName(button))).getAttribute("disabled"));
    }

    @Then("^The (.*) ErrorMessage appears$")
    public void errorMessageDisplayed(String message) {
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
        }
        WebElement messageElement = getDriver().findElement(By.xpath("//div[@class='alert alert-danger']"));
        assertThat(messageElement.isDisplayed(), is(true));
        assertThat(messageElement.getText(), is(message));
    }

    @Then("^nothing happens, stayed on (.*) page$")
    public void nothingHappened(String beforePage) {
        String url = "";
        switch (beforePage) {
            case "initial":
                url = "http://localhost:4200/#";
                break;
        }
        Assert.assertEquals(url, getDriver().getCurrentUrl());
    }

    @Then("^The user does nothing$")
    public void nothing() {
    }

    @Then("^The letter lines appear$")
    public void letterline() {
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
        }
        WebElement messageElement = getDriver().findElement(By.id("letterline"));
        assertThat(messageElement.isDisplayed(), is(true));
    }

    @Then("^new word appears$")
    public void wordAppears(){
        letterline();
        //TODO: új szó is
    }
    @Then("^The letter lines for word from the same collection appears$")
    public void vmi(){
        letterline();
        //TODO: ellenőrizni, hogy ugyanaz-e
    }

    @When("^The user does not accept terms and conditions$")
    public void the_user_does_not_accept_terms_and_conditions(){
        WebElement element = getDriver().findElement(By.id("checkboxAccept"));
        if(element.getAttribute("checked")!=null){
            element.click();
        }
    }

    @Then("^is redirected to registration-success page$")
    public void is_redirected_to_registration_success_page(){
        Assert.assertEquals("http://localhost:4200/registerdone", getDriver().getCurrentUrl());
    }
}
