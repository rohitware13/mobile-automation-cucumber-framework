package automation.pages.android;

import automation.config.Base;
import automation.agreement.Dashboard;
import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardScreen extends Base implements Dashboard {

    @FindBy(id = "dashboard_element")
    public WebElement dashboardElement;

    @Inject
    public DashboardScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @Override
    public boolean isDashboardDisplayed() {
        return dashboardElement.isDisplayed();
    }
}