package MobileTests;

import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Screens.BaseMethod;
import MobileAutomation.Screens.HomeUserScreen;
import WebAutomation.Configurations.SetUpDriver;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test005_Mobile_VerifyProgressBarLoader extends SetupLaunch {
    String TestName = this.getClass().getSimpleName();

    @Test
    public void test005_verifyProgressBarLoader() throws IOException {
        ExtentTest Step = SetUpDriver.report(TestName);

        Step.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        Step.info("Step2: Click on Progress Bar Button");
        BaseMethod base = new BaseMethod();
        base.click_Element("ShowProgressBar_Btn");

        Step.info("Step3: Verify until when the Progress Bar is disappeared");
        HomeUserScreen home_screen = new HomeUserScreen();
        home_screen.verify_ProgressBar("ShowProgressBar_PopUp");

        Step.info("Step4: Validate if the flow is navigated to Register Screen and Title is displayed");
        Assert.assertTrue(base.verify_Element("RegisterScreenTitle"), "RegisterScreen Title is not displayed");
    }
}
