package kagishomangaba.tests;

import kagishomangaba.TestComponents.BaseTest;
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

public class ErrorValidations extends BaseTest {

    @Test(groups = "Errors")
    public void ProductMisMatch() throws IOException {

        String productName = "Apple iPhone 17 256GB Mist Blue";

        LandingPage landingPage = launchApplication();
        landingPage.searchProduct(productName);

        CataloguePage cataloguePage = new CataloguePage(driver);
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".product-item-info")));
        cataloguePage.addProductToCart(productName);
        cataloguePage.goToCheckoutPage();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertFalse(shoppingCartPage.VerifyProductsDisplay("Iphone 13 pro max 256GB"));
    }
}
