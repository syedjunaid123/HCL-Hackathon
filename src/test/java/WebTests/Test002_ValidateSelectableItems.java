package WebTests;

import WebAutomation.Configurations.SetUpDriver.SetUpDriver;
import WebAutomation.Pages.BaseMethods;
import WebAutomation.Pages.DroppablePage;
import WebAutomation.Pages.SelectablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test002_ValidateSelectableItems extends SetUpDriver {

    @Test
    public void test002_validateSelectableItems() throws IOException {

        LOGGER.info("Step1: Application is Launched");
        SetUpDriver.setupApplication();

        LOGGER.info("Step2: Click on Selectable link");
        BaseMethods baseMethod = new BaseMethods();
        baseMethod.click_Element("selectableLink");

        LOGGER.info("Step3: Switching into Frames");
        DroppablePage dragElement = new DroppablePage();
        baseMethod.switchToFrame("selectableFrame");

        LOGGER.info("Step4: Select Drop 1,3,7");
        SelectablePage select = new SelectablePage();
        select.selectItems();

        LOGGER.info("Step5: Select Drop 1");



        }
    }
