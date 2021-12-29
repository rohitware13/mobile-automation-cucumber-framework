package automation.pages.android;

import automation.config.Base;
import automation.agreement.Login;
import com.google.inject.Inject;
import com.typesafe.config.Config;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends Base implements Login{

    private final Config config;

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login")
    public WebElement loginButton;

    @Inject
    public  LoginScreen(AppiumDriver appiumDriver, Config config){
        super(appiumDriver);
        this.config = config;
    }

    @Override
    public void loginApp() {
        enterUsername();
        enterPassword();
        clickOnLogin();
    }

    @Override
    public void enterUsername() {
        userName.sendKeys(config.getString("username"));
    }

    @Override
    public void enterPassword() {
        password.sendKeys(config.getString("password"));
    }

    @Override
    public void clickOnLogin() {
        loginButton.click();
    }
}
