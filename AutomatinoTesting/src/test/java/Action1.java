import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Action1 {
    public static WebDriver driver =new EdgeDriver();
    public static void main(String[] args) /*throws InterruptedException*/ {

        openDriverNavigate("https://the-internet.herokuapp.com/hovers");
        mang();
       hover();

    }

    public static void hover()
    {
        By checkbox = By.xpath("(//img)[2]");
        new Actions(driver).moveToElement(byWeb(checkbox)).perform();
    }

    public static void DragDrop()
    {
        By checkbox = By.id("column-a");
        By checkbox2 = By.id("column-b");
       // driver.findElement(checkbox).click();
        new Actions(driver).dragAndDrop(byWeb(checkbox),byWeb(checkbox2)).perform();
    }
    public static void DragDropByHold()
    {
        By checkbox = By.id("column-a");
        By checkbox2 = By.id("column-b");
      //  driver.findElement(checkbox).click();
        new Actions(driver).clickAndHold(byWeb(checkbox)).moveToElement(byWeb(checkbox2)).release().build().perform();
    }

   public static void DoubleClick()
     {
    By checkbox = By.cssSelector("#checkboxes:nth-of-type(1)");
    driver.findElement(checkbox).click();
    new Actions(driver).doubleClick(byWeb(checkbox)).perform();
     }
    public static void RightClick()
    {
        By checkbox = By.cssSelector("#checkboxes:nth-of-type(1)");
        driver.findElement(checkbox).click();
        new Actions(driver).contextClick(byWeb(checkbox)).perform();
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
