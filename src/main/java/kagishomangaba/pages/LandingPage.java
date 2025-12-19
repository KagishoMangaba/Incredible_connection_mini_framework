package kagishomangaba.pages;

import kagishomangaba.Abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage extends AbstractComponents {

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".product-item-info")
    private List<WebElement> products;

    private By productsBy = By.cssSelector(".product-item-info");

    public void searchProduct(String productName) {
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.id("search")), productName).build().perform();
        driver.findElement(By.cssSelector("button[title='Search']")).click();
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
        WebElement prod = getProductByName(productName);
        prod.findElement(By.cssSelector(".action.showcart")).click();
    }
}





