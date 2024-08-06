package su_1;

import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
//import org.testng.IInvokedMethod;
import org.testng.annotations.*;

import java.time.Duration;

//@Listeners(IInvokedMethod.class)
public class paramter {

    ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();

    //private WebDriver driver;
    public Logger LOGGER=LogManager.getLogger();
    @Parameters(value = "browser")
    @BeforeMethod
    public void setup(@Optional("edge") String browser)
    {
        switch (browser)
        {
//            case "edge":
//                driver=new EdgeDriver();
//                break;
            case "chrome":
                driverThreadLocal.set(new ChromeDriver());
                break;
            default:
                driverThreadLocal.set(new EdgeDriver());


        }
        driverThreadLocal.get().manage().window().maximize();
        driverThreadLocal.get().get("https://the-internet.herokuapp.com/login");
        driverThreadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }

    @Parameters(value = {"username","password"})
    @Test(priority = 3)
    public void invalidLoginTestCasa (@Optional("tomsmith") String username,@Optional("SuperSecretPassword!") String password)
    {
        LOGGER.info("amr1");
        driverThreadLocal.get().findElement(By.id("username")).sendKeys(username);
        LOGGER.info("amr2");
        driverThreadLocal.get().findElement(By.id("password")).sendKeys(password);
        LOGGER.info("amr3");
        driverThreadLocal.get().findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        LOGGER.info("amr4");
        boolean expected =driverThreadLocal.get().getCurrentUrl().equals("https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(expected,"asdf");
        System.out.println("sdfghjhfd");
        }

    @Test(priority = 3)
    public void invalidLoginTestCasa2 ()
    {
        driverThreadLocal.get().findElement(By.id("username")).sendKeys("tomsmith");
        driverThreadLocal.get().findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driverThreadLocal.get().findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        boolean expected =driverThreadLocal.get().getCurrentUrl().equals("https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(expected,"asdf");
        System.out.println("sdfghjhfd");
    }

    @Test(invocationCount = 3 ,threadPoolSize = 3)
    //@Test(priority = 3)
    public void invalidLoginTestCasa3 ()
    {
        driverThreadLocal.get().findElement(By.id("username")).sendKeys("tomsmith");
        driverThreadLocal.get().findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driverThreadLocal.get().findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        boolean expected =driverThreadLocal.get().getCurrentUrl().equals("https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(expected,"asdf");
        System.out.println("sdfghjhfd");
    }

    @AfterMethod
    public void quit ()
    {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}
