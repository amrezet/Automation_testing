import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waitingStratgies {
    public static WebDriver driver =new EdgeDriver();
    public static void main(String[] args) /*throws InterruptedException*/ {

//        openDriver("https://the-internet.herokuapp.com/login");
        openDriverNavigate("https://the-internet.herokuapp.com/dynamic_loading/2");
        mang();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        getHelloWorld();


    }

    public static void explicitWait (By by)
    {
       new WebDriverWait(driver,Duration.ofSeconds(10)).
               until(ExpectedConditions.visibilityOf(byWeb(by)));
    }

    public static void fluentWait(By by)
    {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).
                withMessage(by.toString()+"adsfdbgsdx").
                pollingEvery(Duration.ofMillis(2L)).
                until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement byWeb (By locator) {
        return driver.findElement(locator);
    }

    public static void getHelloWorld ()
    {
        By stertButton = By.tagName("button");
        By getHello = By.xpath("//div[@id='finish']/h4");
        driver.findElement(stertButton).click();
        explicitWait(getHello);
       // fluentWait(getHello);
        String mg =driver.findElement(getHello).getText();
        System.out.println(mg);
    }


    public static void openDriverNavigate (String url){

        driver.navigate().to(url);
    }

    public static void mang (){

        //Dimension dimension =new Dimension(100,100);
       // driver.manage().window().setSize(new Dimension(100,100));
        driver.manage().window().maximize();
    }



}