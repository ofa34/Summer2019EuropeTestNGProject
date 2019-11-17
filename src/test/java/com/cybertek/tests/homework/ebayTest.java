package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ebayTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        searchBox.sendKeys("apple");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]"));
        searchButton.click();
        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div/div[1]/h1/span[1]"));
        String result = searchResult.getText();
        result = result.replaceAll(",","");
        double res = Double.parseDouble(result);
        System.out.println(Math.round(res));

    }
}
