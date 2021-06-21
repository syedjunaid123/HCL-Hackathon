package MobileTests;

import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Screens.HomeScreen;
import WebAutomation.Configurations.SetUpDriver;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test001_Mobile_VerifyTitleAndOtherElements extends SetupLaunch {
    String TestName = this.getClass().getSimpleName();

    @Test
    public void test001_verifyScreenTitleAndOtherElements() throws IOException {
        ExtentTest Step = SetUpDriver.report(TestName);

        Step.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        Step.info("Step2: Validating if HomeScreen is Displayed");
        HomeScreen home = new HomeScreen();
        softAssert.assertTrue(home.verify_Element("HomeScreen"), "HomeScreen is not displayed");

        Step.info("Step3: Validating Title of HomeScreen");
        softAssert.assertTrue(home.verify_Element("TitleHomeScreen"), "Title HomeScreen is not displayed");

        Step.info("Step4: Validating EN-Button");
        softAssert.assertTrue(home.verify_Element("EN_Btn"), "EN-Button is not displayed");

        Step.info("Step4: Validating Chrome WebView Button");
        softAssert.assertTrue(home.verify_Element("WebView_Btn"), "WebView Button is not displayed");

        Step.info("Step5: Validating RegistrationButton");
        softAssert.assertTrue(home.verify_Element("Registration_Btn"), "RegistrationButton is not displayed");

        Step.info("Step6: Validating Input TextField");
        softAssert.assertTrue(home.verify_Element("TextField_Txt"), "TextField is not displayed");

        Step.info("Step6: Validating Show Progress Bar Button");
        softAssert.assertTrue(home.verify_Element("ShowProgressBar_Btn"), "Show Progress Bar Button is not displayed");

        Step.info("Step7: Validating Display Text View Button");
        softAssert.assertTrue(home.verify_Element("DispTxtView_Btn"), "Text View Button is not displayed");

        Step.info("Step8: Validating Display Toast Button");
        softAssert.assertTrue(home.verify_Element("DispToast_Btn"), "Toast Button is not displayed");

        Step.info("Step9: Validating Display Pop Up Window Button");
        softAssert.assertTrue(home.verify_Element("DispPopupWindow_Btn"), "Pop Up Window Button is not displayed");

        Step.info("Step10: Validating Display Exception Test Button");
        softAssert.assertTrue(home.verify_Element("ExceptionTest_Btn"), "Exception Test Button is not displayed");

        Step.info("Step11: Validating Display Exception Input Text");
        softAssert.assertTrue(home.verify_Element("ExceptionInput_Txt"), "Exception Input Text is not displayed");

        Step.info("Step12: Validating Display Focus Layout Button");
        softAssert.assertTrue(home.verify_Element("DispFocusLayout_Btn"), "Focus Layout Button is not displayed");

        softAssert.assertAll();
    }
}
