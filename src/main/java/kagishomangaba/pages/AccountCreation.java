package kagishomangaba.pages;

import kagishomangaba.base.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class AccountCreation extends AbstractComponents {

    private WebDriver driver;

    public AccountCreation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "cellphone_number")
    private WebElement cellphoneNumber;

    @FindBy(id = "taxvat")
    private WebElement vatNumber;

    @FindBy(id = "email_address")
    private WebElement emailAddress;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "identity_number")
    private WebElement idNumber;

    @FindBy(id = "password-confirmation")
    private WebElement passwordConfirmation;

    @FindBy(xpath = "//label[@for='switcher--id-field']")
    private WebElement southAfricaIdentificationType;

    @FindBy(xpath = "//label[@for='switcher--passport-field']/span")
    private WebElement passportIdentificationType;

    @FindBy(xpath = "//label[@for='privacy_policy']")
    private WebElement privacyPolicy;


    public void enterInformation(String fName,
                                  String lName,
                                  String phone,
                                  String vat,
                                  String email,
                                  String pwd,
                                  String id) {

        waitForElementToAppear(By.id("firstname"));

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        cellphoneNumber.sendKeys(phone);
        vatNumber.sendKeys(vat);
        emailAddress.sendKeys(email);
        password.sendKeys(pwd);
        passwordConfirmation.sendKeys(pwd);

        southAfricaIdentificationType.click();
        idNumber.sendKeys(id);

        privacyPolicy.click();
    }





}
