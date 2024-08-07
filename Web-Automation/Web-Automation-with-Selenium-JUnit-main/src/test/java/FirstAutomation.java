import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class FirstAutomation {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void getTitle(){
        driver.get("https://demoqa.com/");
        String title_actual=driver.getTitle();
        String title_expected= "DEMOQA";
        System.out.println("title_actual");
        Assert.assertEquals(title_actual,title_expected);
    }
    @Test
    public void ifImageExists(){
        driver.get("https://demoqa.com/");
        boolean status =driver.findElement(By.xpath("//header/a[1]/img[1]")).isDisplayed();
        System.out.println(status);
        Assert.assertTrue(status);
    }
    @Test
    public void SubmitForm() throws InterruptedException {

        driver.get("https://demoqa.com/text-box");
        //driver.findElement(By.id("userName")).sendKeys("user");
        //driver.findElement(By.cssSelector("[type=text]")).sendKeys("user");
        //driver.findElement(By.id("userEmail")).sendKeys("user@test.com");

        List <WebElement> formControl= driver.findElements(By.className("form-control"));
        formControl.get(0).sendKeys("user");
        formControl.get(1).sendKeys("user@test.com");

        WebElement txtAddress= driver.findElement(By.cssSelector("[placeholder='Current Address']"));
        txtAddress.sendKeys("Dhaka");
        WebElement btnSubmit= driver.findElement(By.id("submit"));
        JavascriptExecutor executor= (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        btnSubmit.click();
//        driver.findElement(By.id("submit")).click();
        String name_actual=driver.findElement(By.id("name")).getText();
        String name_expected="user";
        Assert.assertTrue(name_actual.contains(name_expected));
    }
    @Test
    public void btnClick(){
        driver.get("https://demoqa.com/buttons");
        List<WebElement> button= driver.findElements(By.cssSelector(("[type=button]")));
        Actions action =new Actions(driver);
        action.doubleClick(button.get(1)).perform();
        action.contextClick(button.get(2)).perform(); // for mousehover replace contextClick/ doubleclick by obj.moveToElement
        action.click(button.get(3)).perform();

        String actual_message=driver.findElement(By.id("doubleClickMessage")).getText();
        String actual_message2=driver.findElement(By.id("rightClickMessage")).getText();
        String expected_message= "You have done a double click";
        Assert.assertTrue(actual_message.contains(expected_message));
        Assert.assertTrue(actual_message.contains(expected_message));
    }
    @Test
    public void alertClick() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
//        driver.findElement(By.id("timerAlertButton")).click();
//        Thread.sleep(6000);
//        driver.switchTo().alert();
        driver.findElement(By.id("confirmButton")).click();
        // driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
    }
    @Test
    public void selectDate(){
        driver.get("https://demoqa.com/date-picker");
        WebElement date= driver.findElement(By.id("datePickerMonthYearInput"));
        date.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        date.sendKeys("09/09/2023");
        date.sendKeys(Keys.ENTER);
    }
    @Test
    public void selectDropDown(){
        driver.get("https://demoqa.com/select-menu");
        Select select =new Select(driver.findElement(By.id("oldSelectMenu")));
        //select.selectByValue("3"); // it's a value provided by fornt end developer
        select.selectByIndex(3); // It is a array found by index number
//      select.selectByVisibleText("Black");
    }
    @Test
    public void takeScreenShot() throws IOException {
        driver.get("https://demoqa.com");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(screenshotFile, DestFile);
    }
    @Test
    public void handleMultipleWindows () throws InterruptedException {

        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(3000);
        ArrayList<String> w = new ArrayList(driver.getWindowHandles());
        //switch to open tab
        driver.switchTo().window(w.get(1));
        System.out.println("New tab title: " + driver.getTitle());
        String text = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(text,"This is a sample page");
        driver.close();
        //driver.switchTo().window(w.get(0));
    }
    @Test
    public void HandleChildWindows(){
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id(("windowButton"))).click();
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                String text= driver.findElement(By.id("sampleHeading")).getText();
                Assert.assertTrue(text.contains("This is a sample page"));
            }
        }

        driver.close();
        driver.switchTo().window(mainWindowHandle);

    }
    @Test
    public void scrapData(){
        driver.get("https://demoqa.com/webtables");
        WebElement table = driver.findElement(By.className("rt-tbody"));
        List<WebElement> allRows = table.findElements(By.className("rt-tr"));
        int i=0;
        for (WebElement row : allRows) {
            List<WebElement> columns = row.findElements(By.className("rt-td"));
            for (WebElement cell : columns) {
                i++;
                System.out.println("num["+i+"] "+ cell.getText());
            }
        }
    }
    @Test
    public void handleIframe(){
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame2");
        String text= driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertTrue(text.contains("This is a sample page"));
        driver.switchTo().defaultContent();
    }


    //  @Test
//    public void SearchGoogle (){
//        driver.get("https://www.google.com/");
//        WebElement search = driver.findElement(By.name("q"));
//        Actions action =new Actions(driver);
//        action.moveToElement(search);
//        action.keyDown(Keys.SHIFT);
//        action.sendKeys("Education System in Bangladesh");
//        action.keyUp(Keys.UP);
//        action.sendKeys(Keys.ENTER);
//        action.perform();
//    }

    @After
    public void CloseBrowser(){
        driver.quit();
    }

}
