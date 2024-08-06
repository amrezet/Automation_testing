import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium {
   public static WebDriver driver =new EdgeDriver();
    public static void main(String[] args) /*throws InterruptedException*/ {

//        openDriver("https://the-internet.herokuapp.com/login");
        openDriverNavigate("https://the-internet.herokuapp.com/login");
//        refresh();
//        openDriverNavigate("https://google.com");
//        back();
//        //Thread.sleep(2000);
//        forward();
        mang();
//        urlOut();
//        getTitel();
//       // getSourceCode();
//        getWindowId();
//        closeWindowId();
//        quitWindowId();
        By userInput1 =By.id("username");


//        WebElement userInput = driver.findElement(By.id("username"));
//        userInput.sendKeys();


    }

    public static void openDriver (String url)
    {
        driver.get(url);

    }
    public static void openDriverNavigate (String url){

        driver.navigate().to(url);
    }
    public static void refresh (){

driver.navigate().refresh();
    }
    public static void forward (){

        driver.navigate().forward();
    }
    public static void back (){

        driver.navigate().back();
    }
    public static void mang (){

        //Dimension dimension =new Dimension(100,100);
        driver.manage().window().setSize(new Dimension(100,100));
        driver.manage().window().maximize();
    }
    public static void urlOut () {

      String url1=driver.getCurrentUrl();
        System.out.println(url1);

    }
    public static void getTitel () {

        String url1=driver.getTitle();
        System.out.println(url1);

    }
    public static void getSourceCode () {

        String url1=driver.getPageSource();
        System.out.println(url1);
}
    public static void getWindowId () {  //Handle

        String url1=driver.getWindowHandle() ;
        System.out.println(url1);

        driver.switchTo().newWindow(WindowType.TAB);

        String url2=driver.getWindowHandle() ;
        System.out.println(url2);
    }
    public static void closeWindowId () {

        driver.close();
    }
    public static void quitWindowId () {

        driver.quit();
    }


}
