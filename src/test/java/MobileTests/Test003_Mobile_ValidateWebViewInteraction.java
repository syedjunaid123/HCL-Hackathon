package MobileTests;

import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Screens.BaseMethod;
import WebAutomation.Configurations.SetUpDriver;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test003_Mobile_ValidateWebViewInteraction extends SetupLaunch {
    String TestName = this.getClass().getSimpleName();

    @Test
    public void test003_validateWebViewInteraction() throws IOException {
        ExtentTest Step = SetUpDriver.report(TestName);

        Step.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        Step.info("Step2: Click Web View Button");
        BaseMethod base = new BaseMethod();
        base.click_Element("WebView_Btn");

        Step.info("Step3: Validate if the Webview title is displayed");
        softAssert.assertTrue(base.verify_Element("WebViewTitle"), "WebView Title is not displayed");

        Step.info("Step4: Enter Your Name in TextBox");
        String nameEntered = base.input_Element("EnterName_Txt", "Name");

        Step.info("Step5: Click to open the dropdown");
        base.click_Element("SelectDropdown");

        Step.info("Step6: Select option mercedes from the dropdown");
        base.click_Element("mercedesOption_Btn");

        Step.info("Step7: Verify option selected from mercedes from the dropdown");
        String selectedDropdown = base.getText_Element("SelectDropdown");

        Step.info("Step8: Click on Button 'Send me your name!'");
        base.click_Element("sendName_Btn");

        Step.info("Step9: Verify if 'This is my way Text..' is displayed ");
        softAssert.assertTrue(base.verify_Element("ThisIsMyWay_Txt"), "'This is my way Text..' is not displayed");

        Step.info("Step10: Verify Name entered from Previous screen");
        softAssert.assertEquals(base.getText_Element("verifyNameEntered_Lbl"), nameEntered);

        Step.info("Step11: Verify Car entered from Previous screen");
        softAssert.assertEquals(base.getText_Element("verifyCarSelected_Lbl"), selectedDropdown);

        Step.info("Step12: Click on Link ");
        base.click_Element("clickHere_Link");

        Step.info("Step13: Verify Car Volvo is selected back again");
        softAssert.assertEquals(base.getText_Element("SelectDropdown"), "Volvo");
    }
}
