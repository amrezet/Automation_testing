package Utility;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

//TODO:ClickButton
public class UtilitY {

    private static String screenshots_path ="test_output_allure/screenshots";

    public static void ClickButton(WebDriver driver, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    //TODO:sendData
    public static void sendData(WebDriver driver,By locator,String text)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    //TODO:tack screenshot
    public static void take_screenshot(WebDriver driver,String screenshotName) throws IOException {
        File screenSrc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenDest=new File(screenshots_path+screenshotName+".png");
        FileUtils.copyFile(screenSrc,screenDest);
        Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenDest.getPath())));
    }

}
