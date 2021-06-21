package MobileTests;

import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Screens.HomeScreen;
import WebAutomation.Configurations.SetUpDriver;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test007_Mobile_ValidatingPopUpTapAndDismiss extends SetupLaunch{
    String TestName = this.getClass().getSimpleName();

    @Test
    public void test007_validatingPopUpTapAndDismiss() throws IOException {
        ExtentTest Step = SetUpDriver.report(TestName);

        Step.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        Step.info("Step2: Click on Display Pop Up Button");
        HomeScreen home = new HomeScreen();
        home.click_Element("DispPopupWindow_Btn");

        Step.info("Step3: Click Dismiss Button");
        home.verify_Element("PopUpDismiss_Btn");
    }
}
