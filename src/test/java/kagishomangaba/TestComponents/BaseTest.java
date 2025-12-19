package kagishomangaba.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

public class BaseTest {

    protected WebDriver driver;
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());
    private static final int PAGE_LOAD_TIMEOUT = 30;
    private static final int IMPLICIT_WAIT = 10;
    private static final int WINDOW_WIDTH = 1440;
    private static final int WINDOW_HEIGHT = 900;



    @BeforeMethod(alwaysRun = true)
    public void initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") +
                        "//src//main//java//kagishomangaba//resources//GlobalData.properties"
        ); // Fixed: Added closing parenthesis
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        // Setup WebDriverManager before creating driver instance
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) { // Fixed: Added braces
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            logger.warning("Browser not supported: " + browserName + ". Defaulting to Chrome.");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        // Configure timeouts
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        // Set window size
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        logger.info("WebDriver initialized successfully with browser: " + browserName);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed successfully");
        }
    }
}