package kagishomangaba.pages;

import kagishomangaba.base.AbstractComponents;
import kagishomangaba.base.InputUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractComponents {

    private InputUtil inputUtil;

    public LoginPage(WebDriver driver ) {
        super(driver );
        this.inputUtil = new InputUtil(driver);

    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(xpath = "(//div[@class='password-toggle'])[1]")
    private WebElement passwordToggle;



    public void enterEmail(String email) {
        inputUtil.enterText(emailInput , "email" , email);
    }

    public void enterPassword(String password) {
       inputUtil.enterText(passwordInput , "password" , password);
    }

    public void enterSignInCred(String email , String password) {
       enterEmail(email);
       enterPassword(password);

    }

    public void togglePassword() {
        passwordToggle.click();
    }


}
