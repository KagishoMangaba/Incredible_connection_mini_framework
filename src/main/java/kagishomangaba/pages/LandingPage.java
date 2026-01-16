package kagishomangaba.pages;

import kagishomangaba.base.PageInteractions;
import kagishomangaba.base.InputUtil;
import kagishomangaba.utilities.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LandingPage extends PageInteractions {

    private InputUtil inputUtil;

    public LandingPage(WebDriver driver ) {
        super(driver);
        this.inputUtil =new InputUtil(super.driver);
    }



    @FindBy(xpath = "//div[@class='my-account icon__expand-arrow']")
    private WebElement myAccount;

    @FindBy(xpath = "//a[contains(text(),'Create an Account')]")
    private WebElement createAccountBtn;

    @FindBy(id = "search")
    private WebElement searchBox;

    @FindBy(css = "button[title='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@class='my-account-plus-more']")
    private WebElement signInBtn;

    @FindBy(css = ".product-item-info")
    private List<WebElement> products;




    public CataloguePage searchProduct(String productName) {
      inputUtil.enterText(searchBox  , productName);
      safeClick(searchButton);
      waitForAllVisible(products);
      return new CataloguePage(driver );
    }

    public AccountCreationPage goToCreateAccountPage() {
        safeClick(myAccount);
        waitForElementToBeClickable(createAccountBtn , "create Account");
        safeClick(createAccountBtn);

        return new AccountCreationPage(driver );
    }

    public LoginPage navigateToSignInPage() {
        safeClick(signInBtn);
        return new LoginPage(driver);
    }



    public void goTo() {
        driver.get(ConfigLoader.getProperties().getProperty("url"));
    }
}





