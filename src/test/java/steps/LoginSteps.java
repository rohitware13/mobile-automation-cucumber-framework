package steps;

import automation.agreement.Dashboard;
import automation.agreement.Login;
import com.google.inject.Inject;
import io.cucumber.java8.En;
import org.junit.Assert;


public class LoginSteps implements En {

    @Inject
    public LoginSteps(Login login, Dashboard dashboard) {

        When("^the user enters valid login credentials$", () -> login.loginApp());

        Then("^the user should redirect to dashboard$", () -> {
            Assert.assertEquals("Error in Login Functionality", true, dashboard.isDashboardDisplayed());
        });

    }
}
