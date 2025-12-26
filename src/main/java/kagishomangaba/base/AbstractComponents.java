package kagishomangaba.base;

import kagishomangaba.pages.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver , this);
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
    }

    @FindBy(css = ".action.showcart" )
    WebElement cartHeader;

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToAppear(By findBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }

    public void waitForWebElementToAppear(WebElement findBy) {
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }

    public  void clickCookieBtn() {
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-cookie-allow")));
        cookieButton.click();

    }

    public void clickWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


 ShoppingCartPage goToCart() {
     waitForElementToBeClickable(cartHeader);
     return new ShoppingCartPage(driver);


    }


    public String getPageTitle() {
        return driver.getTitle();
    }

    public void navigateToUrl(String url) {
        driver.get(url);

    }




}
