package kagishomangaba.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import kagishomangaba.TestComponents.TestContent;
import kagishomangaba.factory.DriverFactory;
import kagishomangaba.pages.LandingPage;
import kagishomangaba.pages.AccountCreation;
import kagishomangaba.TestComponents.BaseTest;
import io.cucumber.datatable.DataTable;

import java.util.Map;

public class RegisterAccount extends TestContent {

    private LandingPage landingPage;
    private AccountCreation accountCreationPage;

    @Given("I am on the landing page")
    public void i_am_on_the_landing_page() {


        if (driver == null) {
            driver = DriverFactory.getDriver();
        }
        landingPage = launchApplication();
    }



    @When("I navigate to the account creation page")
    public void i_navigate_to_the_account_creation_page() {
        accountCreationPage = landingPage.goToCreateAccountPage();

    }

    @When("I enter the registration details:")
    public void i_enter_the_registration_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        accountCreationPage.enterInformation(
                data.get("firstName"),
                data.get("lastName"),
                data.get("phone"),
                data.get("vatNumber"),
                data.get("email"),
                data.get("password"),
                data.get("confirm")
        );

        System.out.println("Filled registration form for: " + data.get("email"));
    }


}
