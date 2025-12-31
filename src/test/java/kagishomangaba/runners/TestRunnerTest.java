package kagishomangaba.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import kagishomangaba.TestComponents.Retry;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = "kagishomangaba.steps",
        monochrome = true,

        plugin = {"pretty", "html:target/cucumber.html"}
)

public class TestRunnerTest extends AbstractTestNGCucumberTests {

}
