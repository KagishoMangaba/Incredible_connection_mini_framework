package kagishomangaba.tests.regression;

import kagishomangaba.TestComponents.TestContent;
import kagishomangaba.pages.AccountCreationPage;
import kagishomangaba.pages.LandingPage;
import kagishomangaba.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.HashMap;

public class AccountTests extends TestContent {

    @Test(dataProvider = "getData")
    public void createNewAccount(HashMap<String , String> input) {
        // Launch application
        LandingPage landingPage = launchApplication();

        AccountCreationPage accountCreationPage = landingPage.goToCreateAccountPage();

        accountCreationPage.enterInformation(input.get("firstName") , input.get("lastName") , input.get("cellphoneNumber")
                ,input.get("vatNumber") , input.get("emailAddress") , input.get("password") , input.get("passwordConfirmation"));
    }

    @Test(dataProvider = "getData")
    public void Login(HashMap<String , String> input)  {

        LandingPage landingPage = launchApplication();
        LoginPage loginPage = landingPage.navigateToSignInPage();
        loginPage.enterEmail(input.get("emailAddress"));
        loginPage.enterPassword(input.get("password"));
        loginPage.togglePassword();

    }



    }



