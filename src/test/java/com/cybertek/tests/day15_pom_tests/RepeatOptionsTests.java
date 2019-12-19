package com.cybertek.tests.day15_pom_tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * VERIFY RADIO BUTTONS
 * Open browser
 * Login as driver
 * Go to Activities->Calendar
 * Click on create calendar events
 * Click on repeat
 * Verfiy that repeat every days is checked
 * verify that repeat weekday is not checked
 */
public class RepeatOptionsTests extends TestBase {

    @Test
    public void RepeatRadioButtonTest(){
        //Login as driver
        LoginPage loginPage= new LoginPage();

        String username = ConfigurationReader.get(("driver_username"));
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username,password);

        BrowserUtils.waitForPageToLoad(10);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        BrowserUtils.waitFor(3);



        // Click on create calendar events
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        //Click on repeat
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        //Verfiy that repeat every days is checked
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify that days rb is selected");

        //verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"Verify that weekday is not selected");


    }

    /**
     * VERIFY REPEAT OPTIONS
     * Open browser
     * Login as driver
     * Go to Activities->Calendar
     * Click on create calendar events
     * Click on repeat
     * Verify that repat options are Daily, Weekly, Monthly,Yearly(in this order)
     */

    @Test
    public void verifyRepeatOtions(){
        //Login as driver
        LoginPage loginPage= new LoginPage();

        String username = ConfigurationReader.get(("driver_username"));
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username,password);

        BrowserUtils.waitForPageToLoad(10);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        BrowserUtils.waitFor(3);



        // Click on create calendar events
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        //Click on repeat
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        //Verify that repat options are Daily, Weekly, Monthly,Yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");
        System.out.println(expectedList.size());
        List<WebElement> actualOptions = createCalendarEventsPage.repeatOptionsList().getOptions();

       //get text of each webElement and return as a list of string
        List<String>actualList = BrowserUtils.getElementsText(actualOptions);

        Assert.assertEquals(actualList,expectedList,"compare dropdawn values");

    }

}
