package WebTests;

import WebAutomation.Configurations.SetUpDriver;
import WebAutomation.Pages.BaseMethods;
import WebAutomation.Pages.DroppablePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test001_ValidateDropableElement extends SetUpDriver {
    String TestName = this.getClass().getSimpleName();

    @Test
    public void test001_validateDropableElement() throws IOException {

        ExtentTest Step = SetUpDriver.report(TestName);

        Step.info("Step1: Application is Launched");
        SetUpDriver.setupApplication();

        Step.info("Step2: Click on Droppable link");
        BaseMethods baseMethod = new BaseMethods();
        baseMethod.click_Element("droppableLink");

        Step.info("Step3: Switching into Frames");
        DroppablePage dragElement = new DroppablePage();
        baseMethod.switchToFrame("dropableFrame");

        Step.info("Step4: Drag and drop of Element");
        dragElement.dragAndDragElement("draggableElement", "dropableElement");

        Step.info("Step5: Validate if the droppable Component is Highlighted");
        Assert.assertTrue(baseMethod.verify_Element("dropableColorHighlight"), "Drag and Drop Didn't Happen");
        }
    }
