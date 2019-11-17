package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals(1,1);

        System.out.println("Second Assertion");
        Assert.assertEquals("title","title");

        System.out.println("after second assertion");
    }
    @Test
    public void test2(){

        //verify that title starts with C
        String actualTitle = "Cybertek";
        String expectTitleBeginning ="C";
        Assert.assertTrue(actualTitle.startsWith(expectTitleBeginning),"verify title starts with");

        //verify that email includes @ sign

        Assert.assertTrue("yasin@mail".contains("@"),"Verify @");

    }
    @Test
    public void test3(){
        Assert.assertNotEquals("one","on");

    }
    @Test
    public void test4(){
        Assert.assertFalse(1<0);
    }


}
