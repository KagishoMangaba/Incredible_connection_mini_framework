package kagishomangaba.TestComponents;


import kagishomangaba.pages.LandingPage;
import kagishomangaba.utilities.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class TestContent extends BaseTest {

    private LandingPage landingPage;

    private void dismissCookiePopup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            By cookieBtnLocator = By.id("btn-cookie-allow");

            WebElement cookieButton = wait.until(
                    ExpectedConditions.elementToBeClickable(cookieBtnLocator)
            );

            cookieButton.click();
            LoggerUtil.info("Cookie popup dismissed successfully.");

        } catch (TimeoutException | NoSuchElementException e) {
            LoggerUtil.info("No cookie popup found, continuing test.");
        }
    }

    public LandingPage launchApplication() {
        landingPage = new LandingPage(driver , wait);
        landingPage.goTo();
        dismissCookiePopup();
        return landingPage;
    }



}
