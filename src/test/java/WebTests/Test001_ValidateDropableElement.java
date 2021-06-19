package WebTests;

import WebAutomation.Configurations.SetUpDriver.SetUpDriver;
import WebAutomation.Pages.BaseMethods;
import WebAutomation.Pages.DroppablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test001_ValidateDropableElement extends SetUpDriver {

    @Test
    public void test001_validateDropableElement() throws IOException {

        LOGGER.info("Step1: Application is Launched");
        SetUpDriver.setupApplication();

        LOGGER.info("Step2: Click on Droppable link");
        BaseMethods baseMethod = new BaseMethods();
        baseMethod.click_Element("droppableLink");

        LOGGER.info("Step3: Switchinng into Frames");
        DroppablePage dragElement = new DroppablePage();
        baseMethod.switchToFrame("dropableFrame");

        LOGGER.info("Step4: Drag and drop of Element");
        dragElement.dragAndDragElement("draggableElement", "dropableElement");

        LOGGER.info("Step5: Validate if the droppable Component is Highlighted");
        Assert.assertTrue(baseMethod.verify_Element("dropableColorHighlight"), "Drag and Drop Didn't Happen");
        }
    }
