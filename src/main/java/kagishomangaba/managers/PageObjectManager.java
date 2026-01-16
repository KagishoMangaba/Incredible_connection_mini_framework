package kagishomangaba.managers;

import kagishomangaba.pages.*;
import org.openqa.selenium.WebDriver;



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
        return landingPage = (landingPage == null) ? new LandingPage(driver) : landingPage;
    }

    public CataloguePage getCataloguePage() {
        return cataloguePage = (cataloguePage == null) ? new CataloguePage(driver) : cataloguePage;
    }

    public ShoppingCartPage getShoppingCartPage() {
        return shoppingCartPage = (shoppingCartPage == null) ? new ShoppingCartPage(driver) : shoppingCartPage;
    }

    public AccountCreationPage getAccountCreationPage() {
        return accountCreationPage = (accountCreationPage == null) ? new AccountCreationPage(driver) : accountCreationPage;
    }

    public LoginPage getLoginPage() {
        return loginPage = (loginPage == null) ? new LoginPage(driver) : loginPage;
    }
}
