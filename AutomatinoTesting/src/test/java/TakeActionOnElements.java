import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class TakeActionOnElements {
    public static WebDriver driver =new EdgeDriver();
    public static void main(String[] args) /*throws InterruptedException*/ {

//        openDriver("https://the-internet.herokuapp.com/login");
        openDriverNavigate("https://the-internet.herokuapp.com/login");
        mang();
        enterText("tomsmith","SuperSecretPassword!");
        clicking();
        getTextFormField();


    }

    public static void enterText (String username1,String password1)
    {
        By userNameLocator =By.id("username");
        driver.findElement(userNameLocator).sendKeys(username1);
        By passwordLocator =By.id("password");
        driver.findElement(passwordLocator).sendKeys(password1);
    }

    public static void clicking ()
    {
         By LoginButton =By.className("radius");
         driver.findElement(LoginButton).click();
    }

    public static String getTextFormField ()
    {
        By flashMassage = By.cssSelector("div#flash");
        return driver.findElement(flashMassage).getText();
       // System.out.println(msg);
    }


    public static void openDriver (String url)
    {
        driver.get(url);

    }
    public static void openDriverNavigate (String url){

        driver.navigate().to(url);
    }

    public static void mang (){

        //Dimension dimension =new Dimension(100,100);
        driver.manage().window().setSize(new Dimension(100,100));
        driver.manage().window().maximize();
    }



}

