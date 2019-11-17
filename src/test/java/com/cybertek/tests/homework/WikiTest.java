package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikiTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
       // driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("selenium webdriver");
        driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button/i")).click();
        driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/ul/li[1]/div[1]/a")).click();
        String expectedURL = "https://en.wikipedia.org/wiki/Selenium_(software";
        if(driver.getCurrentUrl().equals(expectedURL)){
            System.out.println("actualURL = " + driver.getCurrentUrl());
            System.out.println("expectedURL = " + expectedURL);
            System.out.println("PASS");
        }else {
            System.out.println("actualURL = " + driver.getCurrentUrl());
            System.out.println("expectedURL = " + expectedURL);
            System.out.println("FAIL");
        }

    }
}
