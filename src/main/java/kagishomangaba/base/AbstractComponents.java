package kagishomangaba.base;

import kagishomangaba.pages.ShoppingCartPage;
import kagishomangaba.utilities.ConfigLoader;
import kagishomangaba.utilities.LoggerUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractComponents(WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver , this);
        int explicitWait;
        try {
            explicitWait = Integer.parseInt(ConfigLoader.getProperties().getProperty("explicitWait"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse explicitWait from config properties", e);
        }

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));

    }



    public WebElement waitForElementToBeClickable(WebElement element, String elementName) {
        try {
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
            LoggerUtil.info(elementName + " is clickable.");
            return el;
        } catch (StaleElementReferenceException e) {
            LoggerUtil.warning(elementName + " became stale. Retrying...");
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            throw new RuntimeException(elementName + " was not clickable within timeout", e);
        }
    }


    public void  waitForElementToAppear(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (TimeoutException e) {
            throw new RuntimeException("Element is currently not visible: " + locator, e);
        }

    }

    protected java.util.List<WebElement> waitForAllVisible(java.util.List<WebElement> elements) {
        return wait.until(driver -> {
            for (WebElement e : elements) {
                if (!e.isDisplayed()) return null;
            }
            return elements;
        });
    }


    public void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }

    protected void safeClick(WebElement element) {
        try {
            waitForElementToBeClickable(element, "element").click();
        } catch (StaleElementReferenceException e) {
            waitForElementToBeClickable(element, "element").click();
        }
    }


    public void waitForWebElementToAppear(WebElement findBy) {
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }


    public void clickWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }



    public String getPageTitle() {
        return driver.getTitle();
    }

    public void navigateToUrl(String url) {
        driver.get(url);

    }




}
