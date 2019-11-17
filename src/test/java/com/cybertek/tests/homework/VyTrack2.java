package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrack2 {
    /**
     * •Go to the login page of VyTrack
     * •Enter invalidcredential (can be any role)
     * •Click login button
     * •Verify that the system shows error message “Invalid user name or password.”
     *
     */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/user/login");

        WebElement userName =  driver.findElement(By.xpath("//*[@id=\"prependedInput\"]"));
        userName.sendKeys("user2");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"prependedInput2\"]"));
        password.sendKeys("asd");

        WebElement logIn = driver.findElement(By.xpath("//*[@id=\"_submit\"]"));
        logIn.click();

        WebElement Invalıd = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div"));
        // WebElement errorMessage = driver.findElement(By.xpath("//div[starts-with(.,'Invalid')]"));
        System.out.println(Invalıd.getText());


    }
}
