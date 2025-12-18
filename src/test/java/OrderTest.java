import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class OrderTest {

    public static void main(String[] args) throws InterruptedException {

        String productName = "Apple iPhone 17 256GB Mist Blue";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.incredible.co.za/");


        //we are on the Landing page
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.id("search")) , "iphone").build().perform();
        driver.findElement(By.cssSelector("button[title='Search']")).click();

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".product-item-info")));

        List<WebElement> products = driver.findElements(By.cssSelector(".product-item-info"));

       WebElement prod = products.stream().filter(product->
                product.findElement(By.cssSelector(".product-item-link")).getText().equals("Apple iPhone 17 256GB Mist Blue")).findFirst().orElse(null);

       prod.findElement(By.cssSelector(".product-item-info .actions-primary button")).click();
       Thread.sleep(3000);

       driver.findElement(By.cssSelector(".action.showcart")).click();

       driver.findElement(By.cssSelector(".action.viewcart")).click();


       List<WebElement> cartProducts = driver.findElements(By.xpath("//td[@class='col item']//strong[@class='product-item-name']"));
      Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
      Assert.assertTrue(match);

      driver.close();




////td[@class='col item']//strong[@class='product-item-name']
//.product-item-info .actions-primary button





    }
}
