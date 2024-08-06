import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class UploadFile {

    public static WebDriver driver =new EdgeDriver();
    public static void main(String[] args) throws IOException /*throws InterruptedException*/ {

        openDriverNavigate("https://the-internet.herokuapp.com/upload");
        mang();
        uploadfile("C:\\Users\\matrix\\Desktop\\Screenshot 2024-07-05 091008.png");



    }

    public static void uploadFileRobot(String path) throws AWTException {
      driver.findElement(By.id("")).click();
        StringSelection stringSelection =new StringSelection(path);  //ctrl C
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        Robot robot= new Robot();
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

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
