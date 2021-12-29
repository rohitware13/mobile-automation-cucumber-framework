package automation.config;


import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.typesafe.config.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class MobileDriverModule implements Provider<AppiumDriver<MobileElement>> {

    private final String platform = System.getProperty("platform");
    private static  AppiumDriver<MobileElement> mobileDriver;
    private  final Config config;

    @Inject
    public MobileDriverModule(Config config){
        this.config = config;
    }

    @Provides
    @Singleton
    @Override
    public AppiumDriver<MobileElement> get(){
        switch (platform){
            case "android":
                mobileDriver = new MobileAndroidDriver(config).androidDriver();
            case "ios":
                mobileDriver= new MobileIosDriver(config).iOSDriver();

        }
        return mobileDriver;
    }
}
