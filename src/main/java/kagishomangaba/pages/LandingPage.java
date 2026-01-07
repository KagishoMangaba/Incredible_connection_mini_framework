package kagishomangaba.pages;

import kagishomangaba.base.AbstractComponents;
import kagishomangaba.utilities.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LandingPage extends AbstractComponents {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='my-account icon__expand-arrow']")
    private WebElement myAccount;

    @FindBy(xpath = "//a[contains(text(),'Create an Account')]")
    private WebElement createAccountBtn;

    @FindBy(id = "search")
    private WebElement searchBox;

    @FindBy(css = "button[title='Search']")
    private WebElement searchButton;

    @FindBy(css = ".product-item-info")
    private List<WebElement> products;

    public LandingPage(WebDriver driver , WebDriverWait wait) {
        super(driver , wait);
        this.driver = driver;
    }


    public CataloguePage searchProduct(String productName) {
      enterText(searchBox , "search box" , productName);
      safeClick(searchButton);
      waitForAllVisible(products);
      return new CataloguePage(driver , wait);
    }

    public AccountCreationPage goToCreateAccountPage() {
        safeClick(myAccount);
        waitForElementToBeClickable(createAccountBtn , "create Account");
        safeClick(createAccountBtn);

        return new AccountCreationPage(driver , wait);
    }



    public void goTo() {
        driver.get(ConfigLoader.getProperties().getProperty("url"));
    }
}





