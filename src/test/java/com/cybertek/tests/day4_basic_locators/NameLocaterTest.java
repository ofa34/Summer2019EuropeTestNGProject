package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocaterTest {

    public static void main(String[] args) {
        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");


        //navigate to website
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullnameInput = driver.findElement(By.name("full_name"));

        fullnameInput.sendKeys("Mike Smith");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("email@gmail.com");

        WebElement signupButton = driver.findElement(By.name("wooden_spoon"));
        signupButton.click();

        // verify that you got "Thank you for signing up. Click the button below to return to the home page."message
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement messageElement = driver.findElement(By.name("signup_message"));
        String actualMessage = messageElement.getText();
        if (expectedMessage.equals(actualMessage)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        driver.quit();

    }
}
