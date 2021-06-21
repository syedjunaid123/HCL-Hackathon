package WebTests;

import WebAutomation.Configurations.SetUpDriver;
import WebAutomation.Pages.BaseMethods;
import WebAutomation.Pages.DroppablePage;
import WebAutomation.Pages.SelectablePage;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test002_ValidateSelectableItems extends SetUpDriver {
    String TestName = this.getClass().getSimpleName();

    @Test
    public void test002_validateSelectableItems() throws IOException {
        ExtentTest Step = SetUpDriver.report(TestName);
        
        Step.info("Step1: Application is Launched");
        SetUpDriver.setupApplication();

        Step.info("Step2: Click on Selectable link");
        BaseMethods baseMethod = new BaseMethods();
        baseMethod.click_Element("selectableLink");

        Step.info("Step3: Switching into Frames");
        baseMethod.switchToFrame("selectableFrame");

        Step.info("Step4: Select Drop 1,3,7");
        SelectablePage select = new SelectablePage();
        select.selectItems();
    }
}
