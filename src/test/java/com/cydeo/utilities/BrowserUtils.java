package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BrowserUtils {



    public static void sleep(int seconds){

        try{Thread.sleep(seconds*1000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }}


    public static void swithWindowAndVerify(String expectedURL, String expectedTitle) {

        Set<String> allWindowHaldles = Driver.getDriver().getWindowHandles();

        for (String eachHandle : allWindowHaldles) {
            Driver.getDriver().switchTo().window(eachHandle);
            System.out.println("current URL = " + Driver.getDriver().getCurrentUrl());
            if (Driver.getDriver().getCurrentUrl().contains(expectedURL)) {
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    public static void verifyTitle(WebDriver driver, String expectedTitle){
        String actualTitle = driver.getTitle();

        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }
    public static void verifyTitleContains( String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }



}
