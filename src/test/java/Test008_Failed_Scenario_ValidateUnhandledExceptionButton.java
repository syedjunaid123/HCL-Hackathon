import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Configuration.SetupDriver.setupDriverInit;
import MobileAutomation.Screens.HomeScreen;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test008_Failed_Scenario_ValidateUnhandledExceptionButton extends SetupLaunch{

    AppiumDriver driver = setupDriverInit.getDriver();

    @Test
    public void test008_failedScenarioValidateUnhandledExceptionButton() throws IOException {

        SetupLaunch.setupApplication();

        HomeScreen home = new HomeScreen();
        home.click_Element("ExceptionTest_Btn");
        home.verify_Element("TitleHomeScreen");
    }
}
