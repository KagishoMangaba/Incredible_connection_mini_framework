package kagishomangaba.pages;

import kagishomangaba.Abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage extends AbstractComponents {

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver , this);
    }

    @FindBy(css = ".product-item-info")
    private List<WebElement> products;

    private By productsBy = By.cssSelector(".product-item-info");
    private By productName = By.cssSelector(".product-item-link");
    private By addToCartBtn = By.cssSelector(".action.showcart");


    public List<WebElement> getProductList() {
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductName(String productName) {
        WebElement prod = products.stream().filter(product->
                product.findElement(By.cssSelector(".product-item-link")).getText().equals(productName))
                .findFirst().orElse(null);
        return prod;
    }


    public void addProductToCart(String productName) {
        WebElement prod = getProductName(productName);


    }




}
