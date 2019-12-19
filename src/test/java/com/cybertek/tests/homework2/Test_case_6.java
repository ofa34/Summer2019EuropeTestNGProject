package com.cybertek.tests.homework2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_case_6 {
    /**
     * Test case #6 Step 1. Go to "https://www.tempmailaddress.com/"
     * Step 2. Copy and save email as a string.
     * Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
     * Step 4. And click on “Sign Up For Mailing List".
     * Step 5. Enter any valid name.
     * Step 6. Enter email from the Step 2
     * Step 7. Click Sign Up
     * Step 8. Verify that following message is displayed: “Thank you for signing up.
     * Click the button below to return to the home page.”
     * Step 9. Navigate back to the “https://www.tempmailaddress.com/”
     * Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
     * Step 11. Click on that email to open it.
     * Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
     * Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
     */
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver=WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterMethod(){
       // driver.quit();
    }
    @Test
    public void test1(){
       // Step 1. Go to "https://www.tempmailaddress.com/"
        driver.get("https://www.tempmailaddress.com/");

        //Step 2. Copy and save email as a string.
        String email =driver.findElement(By.className("animace")).getText();

        // Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.xpath("//*[text()=\"Sign Up For Mailing List\"]")).click();

        // Step 5. Enter any valid name.
        driver.findElement(By.name("full_name")).sendKeys("omer aygun");

        //Step 6. Enter email from the Step 2
        driver.findElement(By.name("email")).sendKeys(email);

        //Step 7. Click Sign Up
        driver.findElement(By.className("radius")).click();

        //Step 8. Verify that following message is displayed: “Thank you for signing up.

        WebElement actualMessage = driver.findElement(By.name("signup_message"));
        Assert.assertTrue(actualMessage.isDisplayed(),"Verify that message is displayed");

        //Step 9. Navigate back to the “https://www.tempmailaddress.com/”
        driver.get("https://www.tempmailaddress.com/");

        //Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
        String receivedMailAddress = driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]")).getText();
        String expectedMailAddress = " do-not-reply@practice.cybertekschool.com";
        System.out.println(receivedMailAddress);
        System.out.println(expectedMailAddress);
        Assert.assertTrue(expectedMailAddress.equals(receivedMailAddress), "Verify that you have recieved an email from Cybertek");

        //Step 11. Click on that email to open it.
        //Step 11. Click on that email to open it.
        driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]")).click();

        //Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
        String actualAddress = driver.findElement(By.id("odesilatel")).getText();
        String expectedAddress = "do-not-reply@practice.cybertekschool.com";

        Assert.assertEquals(actualAddress,expectedAddress,"Verify that email is from: 'do-not-reply@practice.cybertekschool.com'");

        //Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
        String actualsubject = driver.findElement(By.id("predmet")).getText();
        String expectedsubject = "Thanks for subscribing to practice.cybertekschool.com!";

        Assert.assertEquals(actualsubject,expectedsubject,"Thanks for subscribing to practice.cybertekschool.com!");



    }
}
