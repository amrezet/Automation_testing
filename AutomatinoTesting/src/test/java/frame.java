import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class frame {
    public static WebDriver driver =new EdgeDriver();
    public static void main(String[] args) /*throws InterruptedException*/ {

        openDriverNavigate("https://the-internet.herokuapp.com/nested_frames");
        mang();
        nestedframe();

    }

    public static void nestedframe ()
    {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.tagName("body")).getText());
        //driver.switchTo().parentFrame();
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),\"B\")]")).getText());



    }


    public static void iframe ()
    {
        By text = By.cssSelector("body#tinymce");
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(text).clear();
        driver.findElement(text).sendKeys("amr");
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();
    }



    public static void BoxChecked ()
    {
        By checkbox = By.cssSelector("#checkboxes:nth-of-type(1)");
        driver.findElement(checkbox).click();
        System.out.println("cdsvcbv"+ driver.findElement(checkbox).isSelected());

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
