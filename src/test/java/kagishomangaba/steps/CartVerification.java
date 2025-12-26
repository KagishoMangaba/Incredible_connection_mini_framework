package kagishomangaba.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kagishomangaba.TestComponents.BaseTest;
import kagishomangaba.factory.DriverFactory;
import kagishomangaba.pages.CataloguePage;
import kagishomangaba.pages.LandingPage;
import kagishomangaba.pages.ShoppingCartPage;
import org.testng.Assert;

public class CartVerification extends BaseTest {

    private LandingPage landingPage;
    private CataloguePage cataloguePage;
    private ShoppingCartPage shoppingCartPage;

    @Given("the user is on the Incredible Connection landing page")
    public void i_have_landed_on_Incredible_Connection() {
        // Ensure driver is initialized
        if (driver == null) {
            driver = DriverFactory.getDriver();
        }
        landingPage = launchApplication();
    }

    @When("the user searches for {string}")
    public void i_am_searching_for_a_product_on_search_bar(String productName) {
        cataloguePage = landingPage.searchProduct(productName);
    }

    @And("the user adds the product {string} to the cart")
    public void i_am_on_catalogue_page_i_add_product_to_page(String productName) {
        if (cataloguePage == null) {
            throw new IllegalStateException("CataloguePage is not initialized. Ensure search step executed first.");
        }
        cataloguePage.addProductToCart(productName);
    }


    @And("the user navigates to the shopping cart")
    public void i_go_to_the_Cart() {
        if (cataloguePage == null) {
            throw new IllegalStateException("CataloguePage is not initialized. Cannot navigate to cart.");
        }
        shoppingCartPage = cataloguePage.goToCheckoutPage();
    }



    @Then("the product name in the cart should be {string}")
    public void i_verify_the_product_i_added_and_product_in_cart_matches(String productName) {
        if (shoppingCartPage == null) {
            throw new IllegalStateException("ShoppingCartPage is not initialized. Ensure navigation to cart executed first.");
        }
        Assert.assertTrue(
                shoppingCartPage.VerifyProductsDisplay(productName),
                "Product in cart does not match expected product: " + productName
        );
    }

}