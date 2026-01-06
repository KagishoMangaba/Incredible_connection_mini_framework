package kagishomangaba.pages;

import kagishomangaba.base.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public CataloguePage searchProduct(String productName) {
      enterText(searchBox , "search box" , productName);
      safeClick(searchButton);
      waitForAllVisible(products);
      return new CataloguePage(driver);
    }

    public AccountCreation goToCreateAccountPage() {
        myAccount.click();
        waitForElementToBeClickable(createAccountBtn , "create Account");
        createAccountBtn.click();

        return new AccountCreation(driver);
    }



    public void goTo() {
        driver.get("https://www.incredible.co.za/");
    }
}





