package MobileTests;

import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Screens.BaseMethod;
import WebAutomation.Configurations.SetUpDriver;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class Test006_Mobile_ValidatingToastOnClickingDisplayToast extends SetupLaunch {
    String TestName = this.getClass().getSimpleName();

    @Test
    public void test006_validatingToastOnClickingDisplayToast() throws IOException {
        ExtentTest Step = SetUpDriver.report(TestName);
        
        Step.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        Step.info("Step2: Click on Display Toast Button");
        BaseMethod base = new BaseMethod();
        base.click_Element("DispToast_Btn");

        Step.info("Step3: Validate the Toast Button");
        Assert.assertTrue(base.verify_Element("Display_Toast"), "Toast Message is not displayed");
    }
}
