package com.cybertek.tests.homework2;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class TestCase9to12 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
    @Test(dataProvider="200Provider")
    public void test9(String message) {
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. And click on “Status Codes”.
        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        //Step 3. Then click on “200”.
        driver.findElement(By.xpath("//*[text()='200']")).click();
        //Step 4. Verify that following message is displayed: “This page returned a 200 status code”
        String str = "This page returned a 200 status code";
        String returnMessage = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(returnMessage.contains(str),"Verify that following message is displayed: “This page returned a 200 status code”");
        System.out.println(returnMessage);
        System.out.println(message);
        //Assert.assertTrue(returnMessage.equals(message), "Verify that following message is displayed: “This page returned a 200 status code”");
    }
    @DataProvider(name="200Provider")
    public Object[][] getDataFromDataprovider200() {
        return new Object[][]
                {
                        {"This page returned a 200 status code."}
                };
    }
    @Test(dataProvider = "301Provider")
    public void test10(String message){
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. And click on “Status Codes”.
        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        //Step 3. Then click on “301”.
        driver.findElement(By.xpath("//*[text()='301']")).click();
        //Step 4. Verify that following message is displayed: “This page returned a 301 status code”
        String returnMessage = driver.findElement(By.xpath("//p")).getText().substring(0,37);
        System.out.println(returnMessage);
        System.out.println(message);
        Assert.assertTrue(returnMessage.equals(message), "Verify that following message is displayed: “This page returned a 301 status code”");
    }
    @DataProvider(name="301Provider")
    public Object[][] getDataFromDataprovider301() {
        return new Object[][]
                {
                        {"This page returned a 301 status code."}
                };
    }
    @Test(dataProvider = "404Provider")
    public void test11(String message){
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. And click on “Status Codes”.
        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        //Step 3. Then click on “404”.
        driver.findElement(By.xpath("//*[text()='404']")).click();
        //Step 4. Verify that following message is displayed: “This page returned a 404 status code”
        String returnMessage = driver.findElement(By.xpath("//p")).getText().substring(0,37);
        System.out.println(returnMessage);
        System.out.println(message);
        Assert.assertTrue(returnMessage.equals(message), "Verify that following message is displayed: “This page returned a 404 status code”");
    }
    @DataProvider(name="404Provider")
    public Object[][] getDataFromDataprovider404() {
        return new Object[][]
                {
                        {"This page returned a 404 status code."}
                };
    }
    @Test(dataProvider = "500Provider")
    public void test12(String message){
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. And click on “Status Codes”.
        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        //Step 3. Then click on “500”.
        driver.findElement(By.xpath("//*[text()='500']")).click();
        //Step 4. Verify that following message is displayed: “This page returned a 500 status code”
        String returnMessage = driver.findElement(By.xpath("//p")).getText().substring(0,37);
        System.out.println(returnMessage);
        System.out.println(message);
        Assert.assertTrue(returnMessage.equals(message), "Verify that following message is displayed: “This page returned a 500 status code”");
    }
    @DataProvider(name="500Provider")
    public Object[][] getDataFromDataprovider500() {
        return new Object[][]
                {
                        {"This page returned a 500 status code."}
                };
    }
}
