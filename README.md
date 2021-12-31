# Mobile Automation Framework

# Technologies

 - Selenium
 - Appium 
 - Java
 - Cucumber
 - Maven
 - Extent Report
 - Android
 - iOS


# Writing a test
The cucumber features goes in the src/test/resources/FeatureFiles library and should have the ".feature" extension.
You can start out by looking at FeatureFiles/Login.feature. You can extend this feature or make your own features.

Under `main.java.automation.pages` use android or ios packages for maintaining page objects

# Application Test Data
You can keep application specific test data under `main/resources/application.conf`

# Executing of test
Provide tag to the scenario and mention the tag in runner file (src/test/java/runner/RunnerClass.java)

In IDE, you can create/ edit junit run configuration and make sure to pass below variable
    - platform

Configuration should look like
`-ea -Dplatform=android`

# Reporting
You can find execution report under test-output directory
 - Extent HTML Report with screenshot of failed scenarios
 - Logger Report
 - Screenshots

You can customize the report details from `extent-config.xml`
