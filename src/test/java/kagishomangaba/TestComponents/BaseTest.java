package kagishomangaba.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kagishomangaba.factory.DriverFactory;
import kagishomangaba.pages.LandingPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class BaseTest {

    protected WebDriver driver;
    protected LandingPage landingPage;

    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
                Paths.get(
                        System.getProperty("user.dir"),
                        "src", "main", "java",
                        "kagishomangaba", "resources",
                        "GlobalData.properties"
                ).toString()
        );

        prop.load(fis);
        String browser = prop.getProperty("browser", "chrome");

        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();

        logger.info("Driver initialized with browser: " + browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
        logger.info("Driver closed successfully");
    }

    public LandingPage launchApplication() {
        landingPage = new LandingPage(driver);
        landingPage.goTo();

        // Handle cookie popup if present
        dismissCookiePopup();

        return landingPage;
    }

    private void dismissCookiePopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            // Replace with the actual locator of your cookie accept button
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-cookie-allow")));
            cookieButton.click();
        } catch (TimeoutException e) {
            // Cookie popup not present, nothing to do
        }
    }


    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(
                new File(filePath),
                StandardCharsets.UTF_8
        );

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(
                jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {}
        );
    }

    public String captureScreenshot(String testCaseName) throws IOException {

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File target = new File(
                System.getProperty("user.dir") + "/reports/" + testCaseName + ".png"
        );

        FileUtils.copyFile(source, target);
        return target.getAbsolutePath();
    }
}
