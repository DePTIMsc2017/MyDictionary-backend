package hu.unideb.inf.cucumber.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static hu.unideb.inf.cucumber.util.DriverProvider.getDriver;

/**
 * Created by varadi on 2017.05.20..
 */
public class Converter {
    public String convertToID(String name){
        String[] words =name.split(" ");
        for(int i = 0; i<words.length;++i){
            words[i] = Character.toUpperCase(words[i].charAt(0))+words[i].substring(1);
        }
        return String.join("",words);
    }

    public String convertButtonName(String button){
        switch (button) {
            case "Szavak felvétele":
                return "buttonGiveWords";
            case "Registration":
                return "buttonSubmit";
            default:
                return "button"+convertToID(button);
        }
    }

    public String convertSelectName(String select){
        switch(select){
            default:
                return "select"+convertToID(select);
        }
    }

    public void logout(){
        getDriver().get("http://localhost:4200/");
        ((JavascriptExecutor) getDriver()).executeScript("window.localStorage.clear();");
    }

    public void login(){
        logout();
        getDriver().get("http://localhost:4200/login");
        type("test","username");
        type("test", "password");
        click("login");
    }

    public void click(String button){
        getDriver().findElement(By.id(convertButtonName(button))).click();
    }

    public void clickToCard(String card){
        getDriver().findElement(By.id("card"+convertToID(card))).click();
    }

    public void type(String typed, String where){
        getDriver().findElement(By.id("input"+convertToID(where))).sendKeys(typed);
    }
}
