import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.IOException;

public class BrowserOptions {


    public static WebDriver driver =new EdgeDriver();
    public static void main(String[] args) throws IOException /*throws InterruptedException*/ {

        openDriverNavigate("https://the-internet.herokuapp.com/upload");
      //  mang();
        BrowserOption();

    }

    public static void BrowserOption ()
    {
        EdgeOptions edgeOptions =new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--headless");
        edgeOptions.addArguments("--start-maximized");
        driver =new EdgeDriver(edgeOptions);
    }


    public static void uploadfile (String path)
    {
        driver.findElement(By.id("file-upload")).sendKeys(path);
    }


    public static void openDriverNavigate (String url){

        driver.navigate().to(url);
    }

    public static void mang (){

        //Dimension dimension =new Dimension(100,100);
        // driver.manage().window().setSize(new Dimension(100,100));
        driver.manage().window().maximize();
    }
    public static WebElement byWeb (By locator)
    {
        return driver.findElement(locator);
    }

}
