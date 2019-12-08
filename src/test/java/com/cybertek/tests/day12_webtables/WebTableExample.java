package com.cybertek.tests.day12_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableExample {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1000);
        //driver.quit();
    }

    @Test
    public void printTable() {
        WebElement table = driver.findElement(By.id("table1"));
        String wholeTable = table.getText();

        //verify tha jsmith@gmail.com is in the table
        Assert.assertTrue(wholeTable.contains("jsmith@gmail.com"), "Verify jsmith@gmail.com is in the table");

    }

    @Test
    public void getAllHeaders() {
        //how many columns we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of colums " + headers.size());

        //print each columns one by one
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

    }

    @Test
    public void printTableSize() {
        //number of colums
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of colums " + headers.size());

        //number of rows with header
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("all rows with headers are= " + allRowsWithHeader.size());

        //number of rows without header(We prefer this)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr"));
        System.out.println("allRowsWithoutHeader= " + allRowsWithoutHeader.size());
    }

    @Test
    public void getrow() {
        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(secondRow.getText());
        System.out.println();
        //get all the rows dynamically. we can do 2 steps
        //1.get the number of rows
        //based on number of rows,iterate each row
        //number of rows
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr"));

        for (int i = 1; i <= allRows.size(); i++) {
            String rowXpath = "//table[@id='table1']/tbody/tr[" + i + "]";
            System.out.println("rowXpath = " + rowXpath);
            WebElement singleRow = driver.findElement(By.xpath(rowXpath));
            System.out.println(singleRow.getText());
        }
    }

    @Test
    public void getAllCellsInRow() {
        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        for (WebElement cell : allCellsInOneRow) {
            System.out.println(cell.getText());
        }
    }

    @Test
    public void getSingleCellByIndex() {
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[2]"));
        System.out.println(singleCell.getText());
    }

    @Test
    public void printAllCellByIndex() {

        //number of rows
        int rowNumber = getNumberOfRows();
        //number of columns
        int colNumber = getNumberOfColumns();
        //iterate through each row in the table
        for (int i = 1; i <= rowNumber; i++) {
            //iterate through each cell in the table
            for (int j = 1; j <= colNumber; j++) {

                //creating dynamic xpath
                String xpath = "//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
                System.out.println(xpath);

                //getting each cell value and printing it
                WebElement singleCell = driver.findElement(By.xpath(xpath));
                System.out.println(singleCell.getText());
            }
        }
    }

    @Test
    public void getSpecificCellByIndex(){
        int r = 2;
        int c = 3;
        String xpath = "//table[@id='table1']/tbody/tr["+ r +"]/td["+ c +"]";
        WebElement singleCell = driver.findElement(By.xpath(xpath));
        System.out.println(singleCell.getText());
        //HOMEWORK
        //Create a method that accepts row and col number, and returns the cell as a webelement
    }
    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        String firstname = "Tim";
        String xpath = "//table[@id='table1']//td[.='"+firstname +"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());
    }
    private int getNumberOfColumns() {
        List<WebElement> allColumns = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return allColumns.size();
    }
    private int getNumberOfRows() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRows.size();
    }

    @Test
    public void StaleTest(){
        driver.get("http://google.com");
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Selenium" + Keys.ENTER);
        WebElement results = driver.findElement(By.id("resultStats"));
        Assert.assertTrue(results.isDisplayed());
        //go to google second time
        driver.navigate().back();
        input = driver.findElement(By.name("q"));
        input.sendKeys("Java"+ Keys.ENTER);
    }

}
