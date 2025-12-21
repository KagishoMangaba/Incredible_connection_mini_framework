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
import java.util.List;


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
    public Object[][] getData() throws IOException {

        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//main//java//kagishomangaba//data//TestData.json");
        return new Object [][] { {data.get(0)}  , {data.get(1)} };

    }
}



//WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".product-item-info")));