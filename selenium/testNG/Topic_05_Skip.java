package testNG;

import org.testng.annotations.*;

public class Topic_05_Skip {
    @BeforeClass
    public void beforeClass (){
        System.out.println("BeforeClass");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass");
    }

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

    //th
    @Test(enabled = false)
    public void test_01(){
        System.out.println("Test 01");
    }

    @Test(priority = 2)
    public void test_02(){
        System.out.println("Test 02");
    }
}
