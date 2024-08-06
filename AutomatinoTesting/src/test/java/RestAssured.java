import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class RestAssured {
    public static WebDriver driver =new EdgeDriver();
    public static void main(String[] args) throws IOException, URISyntaxException /*throws InterruptedException*/ {

//        openDriver("https://the-internet.herokuapp.com/login");
        openDriverNavigate("https://the-internet.herokuapp.com/broken_images");
        mang();
        List<WebElement>elements=driver.findElements(By.tagName("img"));
       //checkBrokenUsingrestAssure(elements,"photo");
        checkBrokenUsingrestAssure(elements ,"photo");

    }

   public static void checkBrokenUsingrestAssure (List<WebElement>elements,String type)throws IOException, URISyntaxException
   {
       URL url=null;
       String attribute;
       if (type.equals("photo"))
           attribute= "src";
       else
           attribute="href";
       for (WebElement element:elements){
           url=new URI(element.getAttribute(attribute)).toURL();
           Response amr1= io.restassured.RestAssured.given().get(url);
         //  Response response=new RestA.given().get(url);
           System.out.println(amr1.getStatusCode());
       }
   }


    public static void openDriverNavigate (String url){

        driver.navigate().to(url);
    }

    public static void mang (){

        //Dimension dimension =new Dimension(100,100);
        // driver.manage().window().setSize(new Dimension(100,100));
        driver.manage().window().maximize();
    }

}
