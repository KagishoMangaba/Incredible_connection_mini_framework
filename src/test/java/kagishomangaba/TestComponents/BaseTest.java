package kagishomangaba.TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import kagishomangaba.pages.LandingPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class BaseTest {

    public LandingPage landingPage;

    protected WebDriver driver;
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());
    private static final int PAGE_LOAD_TIMEOUT = 30;
    private static final int IMPLICIT_WAIT = 10;
    private static final int WINDOW_WIDTH = 1440;
    private static final int WINDOW_HEIGHT = 900;


    @BeforeMethod(alwaysRun = true)
    public WebDriver initializeDriver() throws IOException {
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
        driver.manage().window().maximize();

        logger.info("WebDriver initialized successfully with browser: " + browserName);
        return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed successfully");
        }
    }


    public
 LandingPage launchApplication() throws IOException {
        driver = initializeDriver();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;


    }

    

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        logger.info("Parsing JSON data from: " + filePath);
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
    }






    public String  getScreenShot(String testCaseName , WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }

    

}