package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazontest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement source = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        source.sendKeys("apple");
        WebElement clickButton =driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
        clickButton.click();
        WebElement resultAmazon = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        String compare = resultAmazon.getText();
        String noResultFor1;
        if(compare.equalsIgnoreCase("No results for")){
            WebElement noResultFor = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/span/div/div[1]/span[2]"));
            noResultFor1 = noResultFor.getText();
        }else{
            WebElement noResultFor = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/h1/div/div[1]/div/div/span[3]"));
            noResultFor1 = noResultFor.getText();
            noResultFor1=noResultFor1.replaceAll("\"","");
        }
        //String result = resultAmazon.getText();
        //result=result.replaceAll("\"","");
        String titleAmazon = driver.getTitle();
        if(titleAmazon.contains(noResultFor1)){
            System.out.println("titleAmazon = " + titleAmazon);
            System.out.println("result = " + noResultFor1);
            System.out.println("PASS");
        }else{
            System.out.println("titleAmazon = " + titleAmazon);
            System.out.println("result = " + noResultFor1);
            System.out.println("FAIL");
        }
    }
}
