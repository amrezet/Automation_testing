package su_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Dependencies {
    private WebDriver driver;

    @BeforeClass
    public void setup()
    {
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }

@Test
public void registertest ()
{
    System.out.println("register test");
   // Assert.fail();
}

@Test(dependsOnMethods = "registertest",alwaysRun = true)
public void logintest()
{
    System.out.println("login test");
}

    @AfterClass
    public void quit ()
    {
        // driver.quit();
    }
}
