package kagishomangaba.managers;

import kagishomangaba.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Senior-level PageObjectManager
 * Handles lazy initialization of pages
 * Thread-safe if instantiated per test
 * I removed waits in
 */
public class PageObjectManager {

    private final WebDriver driver;


    private LandingPage landingPage;
    private CataloguePage cataloguePage;
    private ShoppingCartPage shoppingCartPage;
    private AccountCreationPage accountCreationPage;
    private LoginPage loginPage;

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

    public ShoppingCartPage getShoppingCartPage() {
        if (shoppingCartPage == null) {
            shoppingCartPage = new ShoppingCartPage(driver);
        }
        return shoppingCartPage;
    }

    public  AccountCreationPage accountCreationPage() {
        if(accountCreationPage == null) {
            accountCreationPage = new AccountCreationPage(driver);
        }
        return accountCreationPage;
    }

    public LoginPage getLoginPage() {
        if(loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
}
