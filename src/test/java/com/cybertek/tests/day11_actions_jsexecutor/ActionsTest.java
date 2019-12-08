package com.cybertek.tests.day11_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/hovers");

        //Actions -> class that contains all the user interactions
        //how to create actions object/passing driver as a constructor
        Actions actions = new Actions(driver);

        WebElement img = driver.findElement(By.tagName("img"));
        //perform() --> perform the action. complete the action
        // moveToElement() --> move your mouse to Webelement(hover over)
        actions.moveToElement(img).perform();

        Assert.assertTrue(driver.findElement(By.linkText("View profile")).isDisplayed());

    }
    @Test
    public void DragandDrop(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //how to create actions object/ passing driver as a constructor

        Actions actions = new Actions(driver);
        // we drag this element(source)
        WebElement source = driver.findElement(By.id("draggable"));
        //we drop here (target)
        WebElement target = driver.findElement(By.id("droptarget"));
        //pause() --> waiting just like thread.sleep, accepts milliseconds
        actions.pause(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[2]/div/button")).click();
        //we have to provide source and target to this method, it will drag and drop
        actions.dragAndDrop(source,target).perform();
    }
    @Test
    public void DragandDropChainig() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //how to create actions object/ passing driver as a constructor

        Actions actions = new Actions(driver);
        // we drag this element(source)
        WebElement source = driver.findElement(By.id("draggable"));
        //we drop here (target)
        WebElement target = driver.findElement(By.id("droptarget"));
        //pause() --> waiting just like thread.sleep, accepts milliseconds
        actions.pause(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[2]/div/button")).click();
        //we have to provide source and target to this method, it will drag and drop

       //if you are chaining actions we add build() method before perform
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().build().perform();
    }
}
