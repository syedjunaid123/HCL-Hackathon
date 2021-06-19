package MobileAutomation.Configuration.SetupDriver;

import MobileAutomation.Configuration.AppiumDriver.appiumDriver;
import MobileAutomation.Configuration.AppiumServer.appiumServerInit;
import MobileAutomation.Screens.LaunchAppScreen;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Configuration.SetupDriver.setupDriverInit;
import MobileAutomation.Screens.LaunchAppScreen;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.logging.Logger;


public class SetupLaunch {
    public static SoftAssert softAssert;
    public static final Logger LOGGER = Logger.getLogger(SetupLaunch.class.getName());

    public static void setupApplication() throws IOException {
        softAssert = new SoftAssert();
        appiumServerInit.Start();
        setupDriverInit.setUpDriver();

        AppiumDriver driver = setupDriverInit.getDriver();
        LaunchAppScreen launch = new LaunchAppScreen();
        launch.launch_screen(driver, "ContinueLaunch");
        launch.launch_screen(driver, "OkUpdates");
    }
}
