package kagishomangaba.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import kagishomangaba.factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Starting scenario: " + scenario.getName());


        String browser = System.getProperty("browser", "chrome");
        DriverFactory.createLocalDriver(browser, false);
    }

    @After
    public void tearDown(Scenario scenario) {
        try {

            if (scenario.isFailed() && DriverFactory.getDriver() != null) {
                final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure Screenshot");
            }
        } catch (Exception e) {
            System.err.println("Error capturing screenshot: " + e.getMessage());
        } finally {
            DriverFactory.quitDriver();
            System.out.println("Finished scenario: " + scenario.getName());
        }
    }
}
