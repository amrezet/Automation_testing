package su_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Assertion {

    private SoftAssert softAssert ;
private WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }

    //@Ignore
    @Test(priority = 8,enabled = true)
    public void SoftAValidLoginTestCasa ()
    {
//        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
//      // driver.switchTo().alert().accept();
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        boolean expected =driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/secure");
        softAssert.assertEquals(driver.getCurrentUrl(),"www.google.com","Assertion");
        softAssert.assertFalse(expected,"Assert true");
        softAssert.assertAll();
    }
    @Test(priority = 1)
    public void hardValidLoginTestCasa ()
    {
//        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
//      // driver.switchTo().alert().accept();
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        boolean expected =driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/secure");
        Assert.assertEquals(driver.getCurrentUrl(),"google","Assertion");
        Assert.assertFalse(expected,"Assert true");
    }

    @Test(priority = 3)
    public void invalidLoginTestCasa ()
    {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        boolean expected =driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(expected,"asdf");
        System.out.println("sdfghjhfd");
    }

    @AfterMethod
    public void quit ()
    {
        driver.quit();
    }

}
