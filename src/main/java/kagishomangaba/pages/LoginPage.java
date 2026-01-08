package kagishomangaba.pages;

import kagishomangaba.base.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractComponents {

    public LoginPage(WebDriver driver , WebDriverWait wait) {
        super(driver , wait);

    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(xpath = "(//div[@class='password-toggle'])[1]")
    private WebElement passwordToggle;

    public void enterSignInCred(String emailEle , String passwordEle) {
        enterText(emailInput , "email" , emailEle);
        enterText(emailInput , "password" , passwordEle);
        passwordToggle.click();


    }

    public void enterEmail(String emailEle) {
        enterText(emailInput , "email" , emailEle);
    }

    public void enterPassword(String passwordEle) {
        enterText(passwordInput , "password" , passwordEle);
    }

    public void togglePassword() {
        passwordToggle.click();
    }


}
