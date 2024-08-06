import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dorpdown {

    public static WebDriver driver =new EdgeDriver();
    public static void main(String[] args) /*throws InterruptedException*/ {

        openDriverNavigate("https://the-internet.herokuapp.com/checkboxes");
        mang();
       // DropDow();
        //CheckBox();
        BoxChecked();

    }

    public static void DropDow()
    {
        By dropDown1=By.cssSelector("select#dropdown");
        new Select(byWeb(dropDown1)).selectByIndex(2);
//        new Select(byWeb(dropDown1)).selectByValue("2");
//        new Select(byWeb(dropDown1)).selectByVisibleText("Option 2");
    }

    public static void BoxChecked ()
    {
        By checkbox = By.cssSelector("#checkboxes:nth-of-type(1)");
        driver.findElement(checkbox).click();
        System.out.println("cdsvcbv"+ driver.findElement(checkbox).isSelected());
       // System.out.println("cdsvcbv"+ driver.findElement(checkbox).isDisplayed());
        //System.out.println("cdsvcbv"+ driver.findElement(checkbox).isEnabled());
    }

    public static void CheckBox()
    {
        By checkbox = By.cssSelector("#checkboxes:nth-of-type(1)");
        driver.findElement(checkbox).click();
    }


    public static void openDriverNavigate (String url){

        driver.navigate().to(url);
    }

    public static void mang (){

        //Dimension dimension =new Dimension(100,100);
        // driver.manage().window().setSize(new Dimension(100,100));
        driver.manage().window().maximize();
    }
    public static WebElement byWeb (By locator) {
        return driver.findElement(locator);
    }



}
