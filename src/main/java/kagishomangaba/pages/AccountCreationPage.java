package kagishomangaba.pages;

import kagishomangaba.base.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreationPage extends AbstractComponents {

    private WebDriver driver;

    public AccountCreationPage(WebDriver driver , WebDriverWait wait) {
        super(driver , wait);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "cellphone_number")
    private WebElement cellphoneNumberInput;

    @FindBy(id = "taxvat")
    private WebElement vatNumberInput;

    @FindBy(id = "email_address")
    private WebElement emailAddressInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "identity_number")
    private WebElement idNumberInput;

    @FindBy(id = "password-confirmation")
    private WebElement passwordConfirmation;

    @FindBy(xpath = "//label[@for='switcher--id-field']")
    private WebElement southAfricaIdentificationType;

    @FindBy(xpath = "//label[@for='switcher--passport-field']/span")
    private WebElement passportIdentificationType;

    @FindBy(xpath = "//label[@for='privacy_policy']")
    private WebElement privacyPolicy;


    public void enterInformation(String firstName,
                                 String lastName,
                                 String cellphoneNumber,
                                 String vatNumber,
                                 String emailAddress,
                                 String password,
                                 String identityNumber) {

        waitForElementToAppear(By.id("firstname"));

        enterText(firstNameInput, "First Name", firstName);
        enterText(lastNameInput, "Last Name", lastName);
        enterText(cellphoneNumberInput, "Cellphone Number", cellphoneNumber);
        enterText(vatNumberInput, "VAT Number", vatNumber);
        enterText(emailAddressInput, "Email Address", emailAddress);
        enterText(passwordInput, "Password", password);
        enterText(passwordConfirmation, "Password Confirmation", password);

        southAfricaIdentificationType.click();
        enterText(idNumberInput, "ID Number", identityNumber);

        privacyPolicy.click();
        //check boxes come preselected so it may de select it
    }






}
