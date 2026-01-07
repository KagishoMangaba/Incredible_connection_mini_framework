package kagishomangaba.managers;

import kagishomangaba.factory.DriverFactory;
import kagishomangaba.utilities.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class BrowserManager {

    private static WebDriverWait wait;

    public static void launchBrowser() {

        Properties prop = ConfigLoader.getProperties();

        String browser = prop.getProperty("browser", "chrome");
        boolean headless = Boolean.parseBoolean(prop.getProperty("headless", "false"));

        int implicitWait = Integer.parseInt(prop.getProperty("implicitWait", "5"));
        int explicitWait = Integer.parseInt(prop.getProperty("explicitWait", "15"));
        int pageLoadTimeout = Integer.parseInt(prop.getProperty("pageLoadTimeout", "30"));

        DriverFactory.createLocalDriver(browser, headless);

        WebDriver driver = DriverFactory.getDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
    }

    public static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
