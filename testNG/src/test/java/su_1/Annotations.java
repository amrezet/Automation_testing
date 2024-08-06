package su_1;

import org.testng.annotations.*;

//@Test
public class Annotations {
    @BeforeSuite
    public void BeforeSuite()
    {
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void BeforeTest()
    {
        System.out.println("Before Test");
    }

   @BeforeClass
   public void Beforeclass()
   {
       System.out.println("Before class");

   }
    @BeforeMethod
    public void BeforeMethod()
    {
        System.out.println("befor");
    }

    @Test
    public void testCase1 ()
    {
        System.out.println("testCase1");

    }

    @Test
    public void testCase2 ()
    {
        System.out.println("testCase2");

    }

    @AfterSuite
    public void AfterSuite()
    {
        System.out.println("After Suite");
    }
    @AfterTest
    public void AfterTest()
    {
        System.out.println("After Test");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("After class");

    }

    @AfterMethod
    public void after ()
    {
        System.out.println("after Method");
    }


}
