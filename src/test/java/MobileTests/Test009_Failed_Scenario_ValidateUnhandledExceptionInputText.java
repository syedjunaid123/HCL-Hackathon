package MobileTests;

import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Configuration.SetupDriver.setupDriverInit;
import MobileAutomation.Screens.HomeScreen;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test009_Failed_Scenario_ValidateUnhandledExceptionInputText extends SetupLaunch{

    @Test
    public void test009_failedScenarioValidateUnhandledExceptionButton() throws IOException {

        LOGGER.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        LOGGER.info("Step2: Enter Exception in Input Field");
        HomeScreen home = new HomeScreen();
        home.input_Element("ExceptionInput_Txt", "InputExceptionText");

        LOGGER.info("Step3: Verify HomeScreen Title");
        home.verify_Element("TitleHomeScreen");
    }
}
