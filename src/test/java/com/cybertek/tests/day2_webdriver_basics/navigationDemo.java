package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigationDemo {
    public static void main(String[] args) throws InterruptedException {
       //setting up the browser
        WebDriverManager.chromedriver().setup();

        //selenium object
        WebDriver driver = new ChromeDriver();
        //navigate to website
        driver.get("https://www.google.com");

        driver.navigate().to("https://www.facebook.com");

        //goes back to previous website
        driver.navigate().back();

        //Thread.sleep(3000);
        //goes forward
        driver.navigate().forward();

        Thread.sleep(3000);
        //refresh the page
        driver.navigate().refresh();

    }
}
