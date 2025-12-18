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

import java.time.Duration;
import java.util.List;

public class OrderTest {

    public static void main(String[] args) {

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
//.product-item-info .actions-primary button





    }
}
