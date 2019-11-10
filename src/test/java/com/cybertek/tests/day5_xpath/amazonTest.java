package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonTest {
    public static void main(String[] args) {
        /**
         * navigate to amazon.com
         * type selenium in the searchbox
         * click search button
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        //
        WebElement searchBox = driver.findElement(By.xpath("//input[starts-with(@dir, 'auto')]"));
        searchBox.sendKeys("selenium");

        WebElement searchButton = driver.findElement(By.xpath("//input[starts-with(@value, 'Go')]"));
        searchButton.click();

        WebElement searchButton2 = driver.findElement(By.xpath("(//span[contains(.,'results for')])[2]"));
        System.out.println(searchButton2.getText());

    }
}
