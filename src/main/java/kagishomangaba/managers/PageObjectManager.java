package kagishomangaba.managers;

import kagishomangaba.pages.CataloguePage;
import kagishomangaba.pages.LandingPage;
import kagishomangaba.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;

    private LandingPage landingPage;
    private CataloguePage cataloguePage;
    private ShoppingCartPage shoppingCartPage;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage() {
        if (landingPage == null) {
            landingPage = new LandingPage(driver);
        }
        return landingPage;
    }

    public CataloguePage getCataloguePage() {
        if (cataloguePage == null) {
            cataloguePage = new CataloguePage(driver);
        }
        return cataloguePage;
    }

    public ShoppingCartPage shoppingCartPage() {
        if(shoppingCartPage == null) {
            shoppingCartPage = new ShoppingCartPage(driver);
        }
        return shoppingCartPage;
    }


}
