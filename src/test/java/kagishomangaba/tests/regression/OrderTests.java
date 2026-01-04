package kagishomangaba.tests.regression;

import kagishomangaba.TestComponents.BaseTest;
import kagishomangaba.pages.CataloguePage;
import kagishomangaba.pages.LandingPage;
import kagishomangaba.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderTests extends BaseTest {


    @Test(groups = {"regression"}, priority = 1)
    public void completeOrderFlow() throws IOException {
        String productName = "Apple iPhone 17 256GB Mist Blue";

        LandingPage landingPage = launchApplication();
        landingPage.searchProduct(productName);

        CataloguePage cataloguePage = new CataloguePage(driver);
        cataloguePage.addProductToCart(productName);
        cataloguePage.goToCheckoutPage();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartPage.VerifyProductsDisplay(productName));

        //Due to security reasons this is the furthest i can comfortably go
    }




}

