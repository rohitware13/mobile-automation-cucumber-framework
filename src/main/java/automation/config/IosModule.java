package automation.config;

import automation.agreement.Dashboard;
import automation.agreement.Login;
import automation.pages.ios.DashboardScreen;
import automation.pages.ios.LoginScreen;
import com.google.inject.AbstractModule;

public class IosModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Login.class).to(LoginScreen.class);
        bind(Dashboard.class).to(DashboardScreen.class);
    }
}
