package MobileTests;

import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Screens.HomeScreen;
import WebAutomation.Configurations.SetUpDriver;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test008_Failed_Scenario_ValidateUnhandledExceptionButton extends SetupLaunch {
    String TestName = this.getClass().getSimpleName();

    @Test
    public void test008_failedScenarioValidateUnhandledExceptionButton() throws IOException {
        ExtentTest Step = SetUpDriver.report(TestName);

        Step.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        Step.info("Step2: Click on Exception Button");
        HomeScreen home = new HomeScreen();
        home.click_Element("ExceptionTest_Btn");

        Step.info("Step3: Application is Launched");
        home.verify_Element("TitleHomeScreen");
    }
}
