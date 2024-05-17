package testNG;

import org.testng.annotations.*;

public class Topic_04_Priority {
    @BeforeClass
    public void beforeClass (){
        System.out.println("BeforeClass");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass");
    }
//    @BeforeGroups
//    public void beforeGroups(){
//        System.out.println("BeforeGroups");
//    }
//    @AfterGroups
//    public void afterGroups(){
//        System.out.println("AfterGroups");
//    }
//
//    @BeforeMethod
//    public void beforeMethod(){
//        System.out.println("BeforeMethod");
//    }
//
//    @AfterMethod
//    public void afterMethod(){
//        System.out.println("AfterMethod");
//    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");
    }

//    @BeforeSuite
//    public void beforeSuite(){
//        System.out.println("BeforeSuite");
//    }
//    @AfterSuite
//    public void afterSuite(){
//        System.out.println("AfterSuite");
//    }

    @Test(priority = 1)
    public void test_01(){
        System.out.println("Test 01");
    }

    @Test(priority = 2)
    public void test_02(){
        System.out.println("Test 02");
    }
}
