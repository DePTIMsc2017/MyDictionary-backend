package hu.unideb.inf.cucumber.util;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static hu.unideb.inf.cucumber.util.DriverProvider.getDriver;

/**
 * Created by varadi on 2017.05.20..
 */
public class FillingHandler{
    public void fillWithValue(WebElement webElement){
        String type = webElement.getAttribute("type");
        if(type=="date"){
            webElement.sendKeys("20170514");
        } else if(type=="number"){
            webElement.sendKeys("1521");
        } else if(type=="email"){
            webElement.sendKeys("alma@banan.hu");
        } else if(type =="checkbox"){
            webElement.click();
        } else {
            webElement.sendKeys("szoveg");
        }
    }

    @When("^The user fills one input$")
    public void fillOneInput(){
        List<WebElement> webElements =getDriver().findElements(By.tagName("input"));
        int index = (int)(Math.random() * webElements.size());
        fillWithValue(webElements.get(index));
    }

    @When("^The user fills all inputs$")
    public void fillAllInput(){
        List<WebElement> webElements =getDriver().findElements(By.tagName("input"));
        for(WebElement webElement : webElements){
            fillWithValue(webElement);
        }
    }

    @When("^The user does not fill any input$")
    public void doesNothing(){
    }
}
