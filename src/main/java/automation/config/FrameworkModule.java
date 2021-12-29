package automation.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.appium.java_client.AppiumDriver;

public class FrameworkModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AppiumDriver.class).toProvider(MobileDriverModule.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    public Config configProvider(){
        Config applicationConf = ConfigFactory.parseResources("application.conf");
        Config config =
                ConfigFactory.systemEnvironment()
                        .withFallback(ConfigFactory.systemProperties()
                                .withFallback(applicationConf)
                                .resolve());
        return config;
    }
}
