package kagishomangaba.managers;

import kagishomangaba.pages.CataloguePage;
import kagishomangaba.pages.LandingPage;
import kagishomangaba.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Senior-level PageObjectManager
 * Handles lazy initialization of pages
 * Thread-safe if instantiated per test
 */
public class PageObjectManager {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private LandingPage landingPage;
    private CataloguePage cataloguePage;
    private ShoppingCartPage shoppingCartPage;

    public PageObjectManager(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public LandingPage getLandingPage() {
        if (landingPage == null) {
            landingPage = new LandingPage(driver, wait);
        }
        return landingPage;
    }

    public CataloguePage getCataloguePage() {
        if (cataloguePage == null) {
            cataloguePage = new CataloguePage(driver, wait);
        }
        return cataloguePage;
    }

    public ShoppingCartPage getShoppingCartPage() {
        if (shoppingCartPage == null) {
            shoppingCartPage = new ShoppingCartPage(driver, wait);
        }
        return shoppingCartPage;
    }
}
