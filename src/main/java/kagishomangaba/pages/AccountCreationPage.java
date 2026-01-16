package kagishomangaba.pages;

import kagishomangaba.base.PageInteractions;
import kagishomangaba.base.InputUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationPage extends PageInteractions {
    private WebDriver driver;
    private InputUtil inputUtil;

    public AccountCreationPage(WebDriver driver) {
        super(driver);
        this.inputUtil = new InputUtil(driver);
        this.driver = driver;
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

    @FindBy(id = "password-confirmation")
    private WebElement passwordConfirmation;

    @FindBy(id = "identity_number")
    private WebElement idNumberInput;

    @FindBy(xpath = "//label[@for='switcher--id-field']")
    private WebElement southAfricaIdentificationType;

    @FindBy(xpath = "//label[@for='switcher--passport-field']/span")
    private WebElement passportIdentificationType;

    @FindBy(xpath = "//label[@for='privacy_policy']")
    private WebElement privacyPolicy;

    // ========= SRP Methods using InputUtil =========
    public void enterFirstName(String value) {
        inputUtil.enterText(firstNameInput, value);
    }

    public void enterLastName(String value) {
        inputUtil.enterText(lastNameInput,  value);
    }

    public void enterCellphoneNumber(String value) {
        inputUtil.enterText(cellphoneNumberInput,  value);
    }

    public void enterVatNumber(String value) {
        inputUtil.enterText(vatNumberInput,  value);
    }

    public void enterEmailAddress(String value) {
        inputUtil.enterText(emailAddressInput,  value);
    }

    public void enterPassword(String value) {
        inputUtil.enterText(passwordInput,  value);
    }

    public void confirmPassword(String value) {
        inputUtil.enterText(passwordConfirmation,  value);
    }

    public void enterIdentityNumber(String value) {
        inputUtil.enterText(idNumberInput,  value);
    }

    public void selectSouthAfricanId() {
        southAfricaIdentificationType.click();
    }

    public void selectPassportId() {
        passportIdentificationType.click();
    }

    public void acceptPrivacyPolicy() {
        privacyPolicy.click();
    }

    // ========= Business Workflow =========
    public void enterInformation(String firstName,
                                 String lastName,
                                 String cellphoneNumber,
                                 String vatNumber,
                                 String email,
                                 String password,
                                 String identityNumber) {

        waitForElementToAppear(By.id("firstname"));

        enterFirstName(firstName);
        enterLastName(lastName);
        enterCellphoneNumber(cellphoneNumber);
        enterVatNumber(vatNumber);
        enterEmailAddress(email);
        enterPassword(password);
        confirmPassword(password);

        acceptPrivacyPolicy();
    }

    public void idIdentityType(String identityNumber) {
        selectSouthAfricanId();
        enterIdentityNumber(identityNumber);
    }

    public void passportIdentityType() {
        selectPassportId();

    }
}
