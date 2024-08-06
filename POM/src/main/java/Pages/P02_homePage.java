package Pages;

import Utility.UtilitY;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_homePage
{
    private WebDriver driver;

    private final By logoutButton=By.xpath("//*[@id=\"content\"]/div/a");


    public P02_homePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clicklogoutButton()
    {
        UtilitY.ClickButton(driver,logoutButton);
    }
}
