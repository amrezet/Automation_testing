import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Advanced {
    public static WebDriver driver =new EdgeDriver();
    public static void main(String[] args) throws IOException /*throws InterruptedException*/ {

        openDriverNavigate("https://the-internet.herokuapp.com/key_presses");
        mang();
        screenShout("amr3");


    }

    public static void screenShout (String imageName) throws IOException {
         String path ="C:\\Users\\matrix\\autmation testing\\AutomatinoTesting\\src\\main\\resources\\";
        File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File target =new File(path +imageName + ".png");
        FileUtils.copyFile(src,target);

//        String path ="C:\\Users\\matrix\\autmation testing\\AutomatinoTesting\\src\\main\\resources\\";
  //     File src =(byWeb(By.id(""))).getScreenshotAs(OutputType.FILE);
//        File target =new File(path +imageName + ".png");
//        FileUtils.copyFile(src,target);

    }

    public static void scrol ()
    {
        new Actions(driver).scrollToElement(byWeb(By.id("dfg"))).
                perform();
        driver.findElement(By.id("dfg")).sendKeys("amr");

    }

    public static void Keys1 ()
    {
        By textF =By.id("target");
        new Actions(driver).keyDown(byWeb(textF), Keys.SHIFT)
                .sendKeys(byWeb(textF),"amr ezet")
                .keyUp(Keys.SHIFT)
                .build().perform();

    }

    public static void aleart ()
    {
        driver.findElement(By.cssSelector("[onclick=\"jsAlert()\"]")).click();
        driver.switchTo().alert().accept();

    }

    public static void prompt ()
    {
        driver.findElement(By.cssSelector("[onclick=\"jsPrompt()\"]")).click();
        Alert amr= driver.switchTo().alert();
        amr.sendKeys("amr");
        amr .accept();


    }

    public static void dismessaleart ()
    {
        driver.findElement(By.cssSelector("[onclick=\"jsConfirm()\"]")).click();

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
