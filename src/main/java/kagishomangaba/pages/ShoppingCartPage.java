package kagishomangaba.pages;

import kagishomangaba.base.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage extends AbstractComponents {


    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[@class='col item']//strong[@class='product-item-name']")
    private List<WebElement> cartProducts;

    @FindBy(css = ".action.primary.checkout")
    private WebElement checkoutButton;

    @FindBy(css = ".cart-empty")
    private WebElement emptyCartMessage;

    @FindBy(css = ".product-item-details .price")
    private List productPrices;

    private By cartProductsBy = By.xpath("//td[@class='col item']//strong[@class='product-item-name']");


    public Boolean verifyProductsDisplay(String productName) {
        Boolean match = cartProducts.stream().anyMatch(cartProduct ->
                cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public Boolean isCartEmpty() {
        return emptyCartMessage.isDisplayed();
    }

    public int getCartItemCount() {
        return cartProducts.size();
    }


}