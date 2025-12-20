package kagishomangaba.pages;

import kagishomangaba.base.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CataloguePage extends AbstractComponents {

    private WebDriver driver;

    @FindBy(css = ".action.showcart")
    private WebElement cartButton;

    @FindBy(css = ".action.viewcart")
    private WebElement viewCartButton;

    @FindBy(css = ".product-item-info")
    private List<WebElement> products;

    private By productsBy = By.cssSelector(".product-item-info");

    public CataloguePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ShoppingCartPage goToCheckoutPage() {
        cartButton.click();
        viewCartButton.click();
        return new ShoppingCartPage(driver);
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
        waitForElementToBeClickable(addToCartButton);
        addToCartButton.click();
    }



}





