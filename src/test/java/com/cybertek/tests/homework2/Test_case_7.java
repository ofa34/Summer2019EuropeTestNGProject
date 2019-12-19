package com.cybertek.tests.homework2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_case_7 {
    /**
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. And click on “File Upload".
     * Step 3. Upload any file with .txt extension from your computer.
     * Step 4. Click “Upload” button.
     * Step 5. Verify that subject is: “File Uploaded!”
     * Step 6. Verify that uploaded file name is displayed.
     * Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading.
     * Run this method against “Choose File” button.
     */
    WebDriver driver;
    @BeforeMethod
    public void before(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void after(){
        //driver.quit();
    }
    @Test
    public void test1(){
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. And click on “File Upload".
        driver.findElement(By.xpath("//*[text()='File Upload']")).click();

        //Step 3. Upload any file with .txt extension from your computer.
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\omera\\Desktop\\selenium.txt");

        //Step 4. Click “Upload” button.
        driver.findElement(By.id("file-submit")).click();

        //Step 5. Verify that subject is: “File Uploaded!”
        String actualSubject = driver.findElement(By.xpath("//*[text()='File Uploaded!']")).getText();
        String expectedSubject = "File Uploaded!";

        Assert.assertEquals(actualSubject,expectedSubject,"Verify that subject is: “File Uploaded!”");

        //Step 6. Verify that uploaded file name is displayed.
        WebElement uploaded = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(uploaded.isDisplayed(),"Verify that uploaded file name is displayed");




    }


}
