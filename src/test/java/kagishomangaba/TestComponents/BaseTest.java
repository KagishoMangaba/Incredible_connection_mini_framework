package kagishomangaba.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kagishomangaba.factory.DriverFactory;
import kagishomangaba.managers.BrowserManager;
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


    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());



    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        BrowserManager.launchBrowser();
        driver = DriverFactory.getDriver();
    }




    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            DriverFactory.quitDriver();
        } catch (Exception ignored) {}

    }





}
