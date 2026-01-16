package kagishomangaba.base;

import kagishomangaba.utilities.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputUtil  extends PageInteractions {


    public InputUtil(WebDriver driver) {
        super(driver);
    }


    public void enterText(WebElement element, String inputText) {
        waitForWebElementToAppear(element);
        element.clear();
        element.sendKeys(inputText);
    }


}
