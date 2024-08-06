package Pages;

import Utility.UtilitY;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage
{
    private WebDriver driver;

    private final By userName=By.xpath("//*[@id=\"username\"]");
    private final By password=By.xpath("//*[@id=\"password\"]");
    private final By button=By.xpath("//*[@id=\"login\"]/button/i");

//TODO:driver=driver
    public P01_LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    /**
     * enterUserName
     * @param userNameText
     * @return
     */
//TODO:enterUserName
    public P01_LoginPage enterUserName(String userNameText)
    {
        UtilitY.sendData(driver,userName,userNameText);
        //driver.findElement(userName).sendKeys(userNameText);
        return this;
    }
//TODO:enterPassword
    public P01_LoginPage enterPassword(String passwordText)
    {
        UtilitY.sendData(driver,password,passwordText);
        // driver.findElement(password).sendKeys(passwordText);
        return this;
    }

    public P02_homePage clickButton()
    {
        UtilitY.ClickButton(driver,button);
        //driver.findElement(button).click();
        return new P02_homePage(driver);
    }
}
