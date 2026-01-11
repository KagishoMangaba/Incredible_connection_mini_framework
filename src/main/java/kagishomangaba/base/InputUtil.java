package kagishomangaba.base;

import kagishomangaba.utilities.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputUtil  extends AbstractComponents{


    public InputUtil(WebDriver driver) {
        super(driver);
    }


    public void enterText(WebElement element, String elementName, String inputText) {
        try {
            waitForWebElementToAppear(element);
            element.clear();
            element.sendKeys(inputText);

            String actualValue = element.getAttribute("value");

            if (!inputText.equals(actualValue)) {
                throw new RuntimeException(
                        "Text verification failed for " + elementName +
                                ". Expected: '" + inputText + "' but found: '" + actualValue + "'"
                );
            }
            LoggerUtil.info("Text '" + inputText + "' entered into " + elementName);
        } catch (Exception e) {
            LoggerUtil.severe("Failed to enter text '" + inputText + "' into " + elementName);
            throw e;
        }
    }

}
