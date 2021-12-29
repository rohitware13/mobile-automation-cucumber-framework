package automation.config;

import com.google.inject.Inject;
import com.typesafe.config.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class MobileAndroidDriver extends AndroidModule {

    private final Logger log = LoggerFactory.getLogger(MobileAndroidDriver.class);
    private final Config config;

    @Inject
    public MobileAndroidDriver(Config config) {
        this.config = config;
    }

    public AppiumDriver<MobileElement> androidDriver () {
        log.info("Invoking Android Driver");
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("platformVersion","10.0");
            capabilities.setCapability("deviceName","emulator-5554");
            capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
            capabilities.setCapability("appPackage","com.android.calculator2");
            capabilities.setCapability("automationName","UiAutomator2");

           return new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        }catch (Exception e){
            throw  new RuntimeException("Error in Capabilities", e);
        }
    }


}
