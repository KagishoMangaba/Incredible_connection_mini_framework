package kagishomangaba.pages;

import kagishomangaba.base.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CataloguePage extends AbstractComponents {


    private WebDriver driver;

    @FindBy(css = ".action.showcart")
    private WebElement cartButton;

    @FindBy(css = ".action.viewcart")
    private WebElement viewCartButton;

    @FindBy(css = ".product-item-info")
    private List<WebElement> products;

    @FindBy(css = ".counter-number")
    private WebElement cartCounter;

    @FindBy(css = ".loading-mask")
    private WebElement loadingMask;

    @FindBy(css = ".message-success")
    private WebElement successMessage;

    private By productsBy = By.cssSelector(".product-item-info");
    private By loadingMaskBy = By.cssSelector(".loading-mask");
    private By successMessageBy = By.cssSelector(".message-success");
    private By cartCounterBy = By.cssSelector(".counter-number");
    private By viewCartButtonBy = By.cssSelector(".action.viewcart");


    public CataloguePage(WebDriver driver, WebDriverWait wait) {
        super(driver , wait);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ShoppingCartPage goToCheckoutPage() {
        waitForElementToDisappear(loadingMaskBy);
        waitForElementToAppear(cartCounterBy);
        waitForElementToBeClickable(cartButton , "cart button");
        cartButton.click();
        waitForElementToBeClickable(viewCartButton , "view cart");
        viewCartButton.click();
        return new ShoppingCartPage(driver, wait);
    }

    public List<WebElement> getProductList() {
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        return products.stream()
                .filter(product ->
                        product.findElement(By.cssSelector(".product-item-link"))
                                .getText().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);
    }

    public void addProductToCart(String productName) {
        waitForElementToAppear(productsBy);
        WebElement product = getProductByName(productName);

        if (product == null) {
            throw new RuntimeException("Product not found: " + productName);
        }
        WebElement addToCartButton =
                product.findElement(By.cssSelector(".actions-primary button"));
        waitForElementToBeClickable(addToCartButton , "add to cart button");
        addToCartButton.click();

        waitForElementToAppear(successMessageBy);

        // Wait for loading to complete after adding to cart
        waitForElementToDisappear(loadingMaskBy);
    }



}





