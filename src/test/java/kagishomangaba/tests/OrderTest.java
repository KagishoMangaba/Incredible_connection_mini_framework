package kagishomangaba.tests;

import kagishomangaba.TestComponents.BaseTest;
import kagishomangaba.pages.CataloguePage;
import kagishomangaba.pages.LandingPage;
import kagishomangaba.pages.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;


public class OrderTest extends BaseTest {

    @Test(dataProvider = "getData" )
    public void submitOrder(HashMap<String , String> input) throws IOException {

        LandingPage landingPage = launchApplication();
        landingPage.searchProduct(input.get("product"));

        CataloguePage cataloguePage = new CataloguePage(driver);
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));


       wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".product-item-info")));
        cataloguePage.addProductToCart(input.get("product"));
        cataloguePage.goToCheckoutPage();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartPage.VerifyProductsDisplay(input.get("product")));
    }


    @DataProvider

    public Object[][] getData() {
        HashMap<Object , Object> map = new HashMap<>();

        map.put("product" , "Apple iPhone 17 256GB Mist Blue");

        HashMap<Object , Object> map1 = new HashMap<>();
        map1.put("product" , "Apple MacBook Air 13 M4 10 Core CPU 8 Core GPU 16GB RAM 256GB SSD Starlight");




        return new Object [][] { {map} , {map1}  };

    }
}


//WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".product-item-info")));