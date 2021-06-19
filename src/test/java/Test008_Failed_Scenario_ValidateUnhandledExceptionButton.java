import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Configuration.SetupDriver.setupDriverInit;
import MobileAutomation.Screens.HomeScreen;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test008_Failed_Scenario_ValidateUnhandledExceptionButton extends SetupLaunch{

    @Test
    public void test008_failedScenarioValidateUnhandledExceptionButton() throws IOException {

        LOGGER.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        LOGGER.info("Step2: Click on Exception Button");
        HomeScreen home = new HomeScreen();
        home.click_Element("ExceptionTest_Btn");

        LOGGER.info("Step3: Application is Launched");
        home.verify_Element("TitleHomeScreen");
    }
}
