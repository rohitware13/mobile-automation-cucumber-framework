package automation.utils;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class Helper {

    private final  AppiumDriver appiumDriver;

    @Inject
    public Helper(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void pullToRefresh(){
        Dimension size = appiumDriver.manage().window().getSize();
        int start_x = size.getWidth() / 2 ;
        int start_y, end_y;

        start_y = (int) (size.getHeight() * 0.15);
        end_y = (int) (size.getHeight() * 0.9);

        TouchAction action = new TouchAction(appiumDriver);
        action.press(PointOption.point(start_x, start_y))
                .moveTo(PointOption.point(start_x, end_y))
                .waitAction(WaitOptions.waitOptions(ofSeconds(3)))
                .release()
                .perform();
    }
}
