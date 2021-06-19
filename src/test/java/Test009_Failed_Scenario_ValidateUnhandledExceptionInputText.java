import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Configuration.SetupDriver.setupDriverInit;
import MobileAutomation.Screens.HomeScreen;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test009_Failed_Scenario_ValidateUnhandledExceptionInputText extends SetupLaunch{

    AppiumDriver driver = setupDriverInit.getDriver();

    @Test
    public void test009_failedScenarioValidateUnhandledExceptionButton() throws IOException {

        SetupLaunch.setupApplication();

        HomeScreen home = new HomeScreen();
        home.input_Element(driver, "ExceptionInput_Txt", "InputExceptionText");
        home.verify_Element("TitleHomeScreen");
    }
}
