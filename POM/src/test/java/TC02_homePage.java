import Pages.P01_LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC02_homePage
{
    private WebDriver driver;

    @BeforeMethod
    public void setDriver()
    {
        driver =new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void validLoginTc()
    {
//        new Pages.P01_LoginPage(driver).enterUserName("tomsmith");
//        new Pages.P01_LoginPage(driver).enterPassword("SuperSecretPassword!");
//        new Pages.P01_LoginPage(driver).clickButton();
        new P01_LoginPage(driver).enterUserName("tomsmith")
                .enterPassword("SuperSecretPassword!")
                        .clickButton()
                                .clicklogoutButton();
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");

    }

    @AfterMethod
    public void quit()
    {
        driver.quit();
    }
}
