package MobileTests;

import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Screens.HomeScreen;
import WebAutomation.Configurations.SetUpDriver;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test009_Failed_Scenario_ValidateUnhandledExceptionInputText extends SetupLaunch{
    String TestName = this.getClass().getSimpleName();

    @Test
    public void test009_failedScenarioValidateUnhandledExceptionButton() throws IOException {
        ExtentTest Step = SetUpDriver.report(TestName);

        
        Step.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        Step.info("Step2: Enter Exception in Input Field");
        HomeScreen home = new HomeScreen();
        home.input_Element("ExceptionInput_Txt", "InputExceptionText");

        Step.info("Step3: Verify HomeScreen Title");
        home.verify_Element("TitleHomeScreen");
    }
}
