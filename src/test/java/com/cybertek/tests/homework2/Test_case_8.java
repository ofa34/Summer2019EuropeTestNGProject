package com.cybertek.tests.homework2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_case_8 {
    /**
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. And click on “Autocomplete”.
     * Step 3. Enter “United States of America” into country input box.
     * Step 4. Verify that following message is displayed: “You selected: United States of America”
     */
    WebDriver driver;
    @BeforeMethod
    public void before(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void after(){
        //driver.quit();
    }
    @Test
    public void test1(){

        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. And click on “Autocomplete”.
        driver.findElement(By.xpath("//*[text()='Autocomplete']")).click();

        // Step 3. Enter “United States of America” into country input box.
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        //Step 4. Verify that following message is displayed: “You selected: United States of America”
        driver.findElement(By.xpath("//*[@value='Submit']")).click();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.isDisplayed(),"verify that message is :You selected: United States of America");




    }
}
