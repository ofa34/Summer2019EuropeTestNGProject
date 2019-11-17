package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrack1 {
    /**
     * •Go to the login page of VyTrack
     * •Enter valid credential (can be any role)
     * •Click login button
     * •Verify that the user login successfully
     *
     */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/user/login");

        WebElement userName = driver.findElement(By.xpath("//*[@id=\"prependedInput\"]"));
        userName.sendKeys("user22");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"prependedInput2\"]"));
        password.sendKeys("UserUser123");

        WebElement logIN = driver.findElement(By.xpath("//*[@id=\"_submit\"]"));
        logIN.click();

        String expectedUrl = "https://qa1.vytrack.com/";
        String actualUrl = driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("Pass");
        }else {
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("Fail");
        }

    }
}
