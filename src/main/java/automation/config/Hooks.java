package automation.config;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.google.inject.Inject;
import com.typesafe.config.Config;

import io.appium.java_client.AppiumDriver;
import io.cucumber.core.api.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Hooks {

    private final Logger log = LoggerFactory.getLogger(Hooks.class);

    private final AppiumDriver appiumDriver;
    private final Config config;

    @Inject
    public Hooks(Config config, AppiumDriver appiumDriver){
        this.appiumDriver=appiumDriver;
        this.config = config;
    }

    @Before
    public void startExecution(){
        log.info("Start of execution");
    }

    @After
    public void getScreenshot(Scenario scenario) throws IOException {

        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                //This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);

                //Copy taken screenshot from source location to destination location

                File destinationPath = new File(System.getProperty("user.dir") + "/test-output/screenshots/" + screenshotName + ".png");
                FileUtils.copyFile(sourcePath, destinationPath);

                scenario.embed(FileUtils.readFileToByteArray(destinationPath),"image/png");
                String screenshot_scenario = "data:image/png;base64,"+ Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(destinationPath));

                ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshot_scenario);
            } catch (IOException   e) {
            }
        }

        log.info("End of Execution.");
        appiumDriver.quit();
    }
}
