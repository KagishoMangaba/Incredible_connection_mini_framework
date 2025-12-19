package kagishomangaba.tests;

import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import kagishomangaba.pages.CataloguePage;
import kagishomangaba.pages.LandingPage;
import kagishomangaba.pages.ShoppingCartPage;
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

        LandingPage landingPage = new LandingPage(driver);
        landingPage.searchProduct(productName);


        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".product-item-info")));
        CataloguePage cataloguePage = new CataloguePage(driver);
        cataloguePage.addProductToCart(productName);
        cataloguePage.goToCheckoutPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.VerifyProductsDisplay(productName);
        Assert.assertTrue(shoppingCartPage.VerifyProductsDisplay(productName));







////td[@class='col item']//strong[@class='product-item-name']
//.product-item-info .actions-primary button





    }
}
