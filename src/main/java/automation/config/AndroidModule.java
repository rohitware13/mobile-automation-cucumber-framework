package automation.config;

import automation.agreement.Dashboard;
import automation.agreement.Login;
import automation.pages.android.DashboardScreen;
import com.google.inject.AbstractModule;
import automation.pages.android.LoginScreen;


public class AndroidModule extends AbstractModule {

    @Override
    protected void configure() {
      bind(Login.class).to(LoginScreen.class);
      bind(Dashboard.class).to(DashboardScreen.class);
    }
}
