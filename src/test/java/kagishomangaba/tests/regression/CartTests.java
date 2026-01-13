package kagishomangaba.tests.regression;

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
import java.util.logging.Logger;

public class CartTests extends TestContent {

    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    public void productMatch(HashMap<String , String> input) throws IOException {



        LandingPage landingPage = launchApplication();
        landingPage.searchProduct(input.get("product"));
        CataloguePage cataloguePage = new CataloguePage(driver );

        cataloguePage.addProductToCart(input.get("product"));
        cataloguePage.goToCheckoutPage();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver );
        Assert.assertTrue(shoppingCartPage.isProductInCart(input.get("product")));
        logger.info("product match");
    }

    @Test(dataProvider = "getData")
    public void ProductMisMatch(HashMap<String , String> input) throws IOException {



        LandingPage landingPage = launchApplication();
        landingPage.searchProduct(input.get("product"));

        CataloguePage cataloguePage = new CataloguePage(driver );

        cataloguePage.addProductToCart(input.get("product"));
        cataloguePage.goToCheckoutPage();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver );
        Assert.assertFalse(shoppingCartPage.isProductInCart(input.get("invalidProduct")));
        logger.info("The product that you searched and added to cart does not match with what is in the cart");

    }



}
