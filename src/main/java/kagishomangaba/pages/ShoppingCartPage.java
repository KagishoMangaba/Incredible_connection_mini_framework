package kagishomangaba.pages;

import kagishomangaba.base.PageInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends PageInteractions {


    public ShoppingCartPage(WebDriver driver) {
        super(driver);

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


    public Boolean isProductInCart(String productName) {
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