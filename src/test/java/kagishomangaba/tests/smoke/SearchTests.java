package kagishomangaba.tests.smoke;

import io.cucumber.java.hu.Ha;
import kagishomangaba.TestComponents.BaseTest;
import kagishomangaba.TestComponents.TestContent;
import kagishomangaba.pages.CataloguePage;
import kagishomangaba.pages.LandingPage;
import kagishomangaba.pages.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class SearchTests extends TestContent {

    @Test(dataProvider = "getData")
    public void verifySearchWithValidProduct(HashMap<String , String> input) throws IOException {
        LandingPage landingPage = launchApplication();
        landingPage.searchProduct(input.get("product"));
        //Valid or invalid is okay since they both exist

        CataloguePage cataloguePage = new CataloguePage(driver);
        Assert.assertTrue(cataloguePage.getProductList().size() > 0,
                "No products found for valid search");
    }



    @Test()
    public void verifySearchWithInvalidProduct() throws IOException {
        LandingPage landingPage = launchApplication();
        landingPage.searchProduct("XYZ123NonExistent");
        CataloguePage cataloguePage = new CataloguePage(driver);

    }

    @Test(dataProvider = "getData")
    public void ProductMisMatch(HashMap<String , String> input) throws IOException {



        LandingPage landingPage = launchApplication();
        landingPage.searchProduct(input.get("product"));

        CataloguePage cataloguePage = new CataloguePage(driver);


//        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".product-item-info")));
        cataloguePage.addProductToCart(input.get("product"));
        cataloguePage.goToCheckoutPage();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertFalse(shoppingCartPage.verifyProductsDisplay(input.get("invalidProduct")));
    }

}
