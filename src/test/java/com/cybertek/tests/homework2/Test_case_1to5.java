package com.cybertek.tests.homework2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Test_case_1to5 {
    /**
     * Test case #1
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Enter “wrong_dob” into date of birth input box.
     * Step 4. Verify that warning message is displayed: “The date of birth is not valid”
     *
     * Test case #2
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
     *
     * Test case #3
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Enter only one alphabetic character into first name input box.
     * Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
     *
     * Test case #4
     * Step 1. Go to https://practice-cybertekschool.herokuapp.com
     * Step 2. Click on “Registration Form”
     * Step 3. Enter only one alphabetic character into last name input box.
     * Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
     *
     * Test case #5
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Enter any valid first name.
     * Step 4. Enter any valid last name.
     * Step 5. Enter any valid user name.
     * Step 6. Enter any valid password.
     * Step 7. Enter any valid phone number.
     * Step 8. Select gender.
     * Step 9. Enter any valid date of birth.
     * Step 10. Select any department.
     * Step 11. Enter any job title.
     * Step 12. Select java as a programming language.
     * Step 13. Click Sign up.
     * Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
     * Note: for using dropdown,
     * please refer to the documentation: https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/Select.html or,
     * please watch short video about drop-downs that is posted on canvas.
     */
    WebDriver driver;

    @BeforeMethod
    public void before(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Registration Form']")).click();
    }
    @AfterMethod
    public void after(){
        //driver.quit();
    }
    @Test
    public void test1(){
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        //driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
       //driver.findElement(By.xpath("//*[text()='Registration Form']")).click();

        //Step 3. Enter “wrong_dob” into date of birth input box.
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");

        //Step 4. Verify that warning message is displayed: “The date of birth is not valid”
        WebElement message = driver.findElement(By.xpath("//*[text()='The date of birth is not valid']"));
        Assert.assertTrue(message.isDisplayed(),"Verify that warning message is displayed: “The date of birth is not valid”");
    }
    @Test
    public void test2(){
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
       // driver.get("https://practice-cybertekschool.herokuapp.com");
        //     * Step 2. Click on “Registration Form”
        //     * Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript7
        WebElement actual1=driver.findElement(By.xpath("//*[text()='C++']"));
        WebElement actual2=driver.findElement(By.xpath("//*[text()='Java']"));
        WebElement actual3=driver.findElement(By.xpath("//*[text()='JavaScript']"));
        Assert.assertTrue(actual1.isDisplayed(),"c++ is displayed");
        Assert.assertTrue(actual2.isDisplayed(),"java is displayed");
        Assert.assertTrue(actual3.isDisplayed(),"javascript is displayed");
    }
    @Test
    public void test3(){
        //Step 3. Enter only one alphabetic character into first name input box.
        driver.findElement(By.name("firstname")).sendKeys("a");
        //     * Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
        WebElement warningMessage =driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[2]"));
        Assert.assertTrue(warningMessage.isDisplayed(),"verify that warning message is displayed for first name");
    }
    @Test
    public void test4(){
        // Step 3. Enter only one alphabetic character into last name input box.
        // Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
        driver.findElement(By.name("lastname")).sendKeys("a");
        WebElement warningMessage =driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[2]"));
        Assert.assertTrue(warningMessage.isDisplayed(),"verify that warning message is displayed for last name");
    }
    @Test
    public void test5(){
        //      Step 3. Enter any valid first name.
        driver.findElement(By.name("firstname")).sendKeys("omer");
        //     * Step 4. Enter any valid last name.
        driver.findElement(By.name("lastname")).sendKeys("aygun");
        //     * Step 5. Enter any valid user name.
        driver.findElement(By.name("username")).sendKeys("ofa2334");
        //     * Step 6. Enter any valid password.
        driver.findElement(By.name("email")).sendKeys("abc@abc.com");
        driver.findElement(By.name("password")).sendKeys("12345678");
        //     * Step 7. Enter any valid phone number.
        driver.findElement(By.name("phone")).sendKeys("571-000-0000");
        //     * Step 8. Select gender.
        driver.findElement(By.name("gender")).click();
        //     * Step 9. Enter any valid date of birth.
        driver.findElement(By.name("birthday")).sendKeys("01/01/2000");
        //     * Step 10. Select any department.
        Select select=new Select(driver.findElement(By.name("department")));
        select.selectByVisibleText("MCR");
        //List<WebElement> listofLinks = driver.findElements((By.xpath("//*[@id=\"registrationForm\"]/div[9]/div/select")));
        //listofLinks.get(3).click();
        //     * Step 11. Enter any job title.
        Select select2 = new Select(driver.findElement(By.name("job_title")));
        select2.selectByVisibleText("SDET");
        //     * Step 12. Select java as a programming language.
        driver.findElement(By.xpath("//*[@id=\"inlineCheckbox2\"]")).click();
        //     * Step 13. Click Sign up.
        driver.findElement(By.id("wooden_spoon")).click();
        //     * Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
        WebElement message = driver.findElement(By.xpath("//*[text()=\"You've successfully completed registration!\"]"));
        Assert.assertTrue(message.isDisplayed());
        //     * Note: for using dropdown,
        //     * please refer to the documentation: https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/Select.html or,
        //     * please watch short video about drop-downs that is posted on canvas.

    }
}
