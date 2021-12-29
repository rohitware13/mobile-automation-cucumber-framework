package automation.config;

import automation.config.IosModule;
import com.google.inject.Inject;
import com.typesafe.config.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class MobileIosDriver extends IosModule {

    private final Logger log = LoggerFactory.getLogger(MobileIosDriver.class);
    private final Config config;

    @Inject
    public MobileIosDriver(Config config) {
        this.config = config;
    }

    public AppiumDriver<MobileElement> iOSDriver () {
        log.info("Invoking iOS Driver");
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "ios");
            capabilities.setCapability("platformVersion","");
            capabilities.setCapability("deviceName","Add Device Name");
            capabilities.setCapability("udid","Add App Activity");
            capabilities.setCapability("appPackage","");
            capabilities.setCapability("automationName","XCUITest");
            if(config.hasPath("bundle")){
                capabilities.setCapability("bundleId",config.getString("bundle"));
            } else{
                capabilities.setCapability("app",config.getString("ios_app_path"));

            }
            return new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        }catch (Exception e){
            throw  new RuntimeException("Error in Capabilities", e);
        }
    }
}
