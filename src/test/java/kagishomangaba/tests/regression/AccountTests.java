package kagishomangaba.tests.regression;

import kagishomangaba.TestComponents.BaseTest;
import kagishomangaba.TestComponents.Retry;
import kagishomangaba.TestComponents.TestContent;
import kagishomangaba.pages.AccountCreationPage;
import kagishomangaba.pages.LandingPage;
import kagishomangaba.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.logging.Logger;

public class AccountTests extends TestContent {

    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    @Test(dataProvider = "getData" , retryAnalyzer = Retry.class)
    public void createNewAccount(HashMap<String , String> data) {
        // Launch application
        LandingPage landingPage = launchApplication();

        AccountCreationPage accountCreationPage = landingPage.goToCreateAccountPage();

        accountCreationPage.enterInformation(data.get("firstName")
                , data.get("lastName")
                , data.get("cellphoneNumber")
                ,data.get("vatNumber")
                , data.get("emailAddress")
                , data.get("password")
                , data.get("passwordConfirmation"));

        accountCreationPage.idIdentityType(data.get("idNumber"));



    }

    @Test(dataProvider = "getData")
    public void Login(HashMap<String , String> data)  {

        LandingPage landingPage = launchApplication();
        LoginPage loginPage = landingPage.navigateToSignInPage();

        loginPage.enterEmail(data.get("emailAddress"));
        loginPage.enterPassword(data.get("password"));




    }



    }



