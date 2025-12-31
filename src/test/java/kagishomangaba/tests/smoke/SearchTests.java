package kagishomangaba.tests.smoke;

import kagishomangaba.TestComponents.BaseTest;
import kagishomangaba.pages.CataloguePage;
import kagishomangaba.pages.LandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchTests extends BaseTest {

    @Test(groups = {"smoke"} , priority = 1)
    public void verifySearchWithValidProduct() throws IOException {
        LandingPage landingPage = launchApplication();
        landingPage.searchProduct("Ps5");

        CataloguePage cataloguePage = new CataloguePage(driver);
        Assert.assertTrue(cataloguePage.getProductList().size() > 0,
                "No products found for valid search");
    }



    @Test(groups = {"smoke"}, priority = 2)
    public void verifySearchWithInvalidProduct() throws IOException {
        LandingPage landingPage = launchApplication();
        landingPage.searchProduct("XYZ123NonExistent");

        CataloguePage cataloguePage = new CataloguePage(driver);

    }

}
