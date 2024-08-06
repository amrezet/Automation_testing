import Pages.P01_LoginPage;
import Utility.DataUtility;
import Utility.UtilitY;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC01_LoginPage {
    String UserNAme = new Faker().name().username();
    String Password = new Faker().number().digit();
    private WebDriver driver;

    @BeforeMethod
    public void setDriver() throws IOException {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtility.getPropertiesFile("environments", "login_url"));
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }


    @Description("amr_1")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("amr")
    @Link(name = "amr", url = "https://www.google.com.eg/?hl=ar")
    @Issue("www.jira.com")
    @TmsLink("www.jira.com/1")
    @Epic("web panel")
    @Feature("login")
    @Story("valid login")

    @Test
    public void validLoginTc() throws IOException {
//        new Pages.P01_LoginPage(driver).enterUserName("tomsmith");
//        new Pages.P01_LoginPage(driver).enterPassword("SuperSecretPassword!");
//        new Pages.P01_LoginPage(driver).clickButton();
        new P01_LoginPage(driver).enterUserName(DataUtility.
                        getJsonFile("ValidLoginData", "userName"))
                .enterPassword(DataUtility.getJsonFile("ValidLoginData", "password"))
                .clickButton();
        UtilitY.take_screenshot(driver, "validLoginTc");
        Assert.assertEquals(driver.getCurrentUrl(), DataUtility.getPropertiesFile("environments", "secure_page"));

    }


    @Test
    public void invalidLoginTc() throws IOException {
//        new Pages.P01_LoginPage(driver).enterUserName("tomsmith");
//        new Pages.P01_LoginPage(driver).enterPassword("SuperSecretPassword!");
//        new Pages.P01_LoginPage(driver).clickButton();
        new P01_LoginPage(driver).enterUserName(UserNAme)
                .enterPassword(DataUtility.getJsonFile("ValidLoginData", "password"))
                .clickButton();
        System.out.println(UserNAme);
        System.out.println(Password);
        Assert.assertNotEquals(driver.getCurrentUrl(), DataUtility.getPropertiesFile("environments", "secure_page"));

    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
