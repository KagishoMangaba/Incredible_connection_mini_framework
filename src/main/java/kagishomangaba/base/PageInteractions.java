package kagishomangaba.base;

import kagishomangaba.utilities.ConfigLoader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageInteractions {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageInteractions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        int explicitWait = Integer.parseInt(
                ConfigLoader.getProperties().getProperty("explicitWait")
        );

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
    }


    public WebElement waitForElementToBeClickable(WebElement element, String elementName) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForWebElementToAppear(WebElement findBy) {
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    protected List<WebElement> waitForAllVisible(List<WebElement> elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }



    protected void safeClick(WebElement element) {
        waitForElementToBeClickable(element, "element").click();
    }

    public void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }



    public String getPageTitle() {
        return driver.getTitle();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }
}
