package kagishomangaba.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import kagishomangaba.factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp() {
        // Pick your browser here; can also read from config
        String browser = "chrome";

        DriverFactory.initDriver(browser);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
