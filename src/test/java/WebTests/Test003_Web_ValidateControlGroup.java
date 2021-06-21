package WebTests;

import WebAutomation.Configurations.SetUpDriver;
import WebAutomation.Pages.BaseMethods;
import WebAutomation.Pages.ControlGroupPage;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test003_Web_ValidateControlGroup extends SetUpDriver {
    String TestName = this.getClass().getSimpleName();

    @Test
    public void test003_validateControlGroup() throws IOException {
        ExtentTest Step = SetUpDriver.report(TestName);
        Step.info("Step1: Application is Launched");
        SetUpDriver.setupApplication();

        Step.info("Step2: Click on Control Group link");
        BaseMethods baseMethod = new BaseMethods();
        baseMethod.click_Element("controlGroupLink");

        Step.info("Step3: Switching into Frames");
        baseMethod.switchToFrame("controlGroupFrame");

        Step.info("Step4: Select Control Group Elements");
        ControlGroupPage select = new ControlGroupPage();
        select.selectControlGroupElements();
    }
}
