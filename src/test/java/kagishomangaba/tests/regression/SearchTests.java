package kagishomangaba.tests.regression;

import kagishomangaba.TestComponents.BaseTest;
import kagishomangaba.TestComponents.TestContent;
import kagishomangaba.pages.CataloguePage;
import kagishomangaba.pages.LandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

public class SearchTests extends TestContent {

    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    @Test(dataProvider = "getData")
    public void verifySearchWithValidProduct(HashMap<String , String> input) throws IOException {
        LandingPage landingPage = launchApplication();
        landingPage.searchProduct(input.get("product"));
        //Valid or invalid is okay since they both exist

        CataloguePage cataloguePage = new CataloguePage(driver );
        Assert.assertTrue(cataloguePage.getProductList().size() > 0,
                "No products found for valid search");
    }

    @Test()
    public void verifySearchWithInvalidProduct() throws IOException {
        LandingPage landingPage = launchApplication();
        landingPage.searchProduct("XYZ123NonExistent");
        CataloguePage cataloguePage = new CataloguePage(driver );

    }

}
