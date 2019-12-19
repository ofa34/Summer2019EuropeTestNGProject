package com.cybertek.tests.day14_pom_tests;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /**
     * Test case
     * Open browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to Activities -> Calender Events
     * Verify that subtitle is Calender Events
     */
    @Test
    public void verifySubtitleTest(){
        LoginPage loginPage=new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubtitle = "Quick Launchpad";
        String actualSubtitle = dashboardPage.getPageSubTitle();
        Assert.assertEquals(actualSubtitle , expectedSubtitle,"verify dashbord title is Quick Launchpad");

        dashboardPage.navigateToModule("Activities","Calendar Events");

        Assert.assertEquals(dashboardPage.getPageSubTitle(),"Calendar Events","Verify subtitle");



    }
}
