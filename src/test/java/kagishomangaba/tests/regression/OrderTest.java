package kagishomangaba.tests.regression;

import kagishomangaba.TestComponents.BaseTest;
import kagishomangaba.TestComponents.TestContent;
import kagishomangaba.pages.AccountCreation;
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

import static kagishomangaba.utilities.JsonReaderUtil.getJsonDataToMap;


public class OrderTest extends TestContent {

    @Test(dataProvider = "getData" )
    public void submitOrder(HashMap<String , String> input) throws IOException {



        LandingPage landingPage = launchApplication();
        landingPage.searchProduct(input.get("product"));
        CataloguePage cataloguePage = new CataloguePage(driver);

        cataloguePage.addProductToCart(input.get("product"));
        cataloguePage.goToCheckoutPage();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartPage.VerifyProductsDisplay(input.get("product")));
    }




    @Test(dataProvider = "getData")
    public void createAccountTest(HashMap<String , String> input) {
        // Launch application
        LandingPage landingPage = launchApplication();

        AccountCreation accountCreationPage = landingPage.goToCreateAccountPage();

        accountCreationPage.enterInformation(input.get("firstName") , input.get("lastName") , input.get("cellphoneNumber")
                ,input.get("vatNumber") , input.get("emailAddress") , input.get("password") , input.get("passwordConfirmation"));

    }


    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//main//java//kagishomangaba//data//TestData.json");
        return new Object [][] { {data.get(0)}  , {data.get(1)} };

    }


}



//WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".product-item-info")));