package WebTests;
import WebAutomation.Configurations.SetUpDriver;
import WebAutomation.Pages.BaseMethods;
import WebAutomation.Pages.ControlGroupPage;
import org.testng.annotations.Test;
import java.io.IOException;

public class Test003_ValidateControlGroup extends SetUpDriver {

    @Test
    public void test003_validateControlGroup() throws IOException {

        LOGGER.info("Step1: Application is Launched");
        SetUpDriver.setupApplication();

        LOGGER.info("Step2: Click on Control Group link");
        BaseMethods baseMethod = new BaseMethods();
        baseMethod.click_Element("controlGroupLink");

        LOGGER.info("Step3: Switching into Frames");
        baseMethod.switchToFrame("controlGroupFrame");

        LOGGER.info("Step4: Select Control Group Elements");
        ControlGroupPage select = new ControlGroupPage();
        select.selectControlGroupElements();
    }
}
