package MobileTests;

import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Screens.HomeScreen;
import org.testng.annotations.Test;
import java.io.IOException;


public class Test003_ValidateWebViewInteraction extends SetupLaunch{

    @Test
    public void test003_validateWebViewInteraction() throws IOException {

        LOGGER.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        LOGGER.info("Step2: Click Web View Button");
        HomeScreen home = new HomeScreen();
        home.click_Element("WebView_Btn");

        LOGGER.info("Step3: Validate if the Webview title is displayed");
        softAssert.assertTrue(home.verify_Element("WebViewTitle"), "WebView Title is not displayed");

        LOGGER.info("Step4: Enter Your Name in TextBox");
        String nameEntered = home.input_Element("EnterName_Txt", "Name");

        LOGGER.info("Step5: Click to open the dropdown");
        home.click_Element("SelectDropdown");

        LOGGER.info("Step6: Select option mercedes from the dropdown");
        home.click_Element("mercedesOption_Btn");

        LOGGER.info("Step7: Verify option selected from mercedes from the dropdown");
        String selectedDropdown= home.getText_Element("SelectDropdown");

        LOGGER.info("Step8: Click on Button 'Send me your name!'");
        home.click_Element("sendName_Btn");

        LOGGER.info("Step9: Verify if 'This is my way Text..' is displayed ");
        softAssert.assertTrue(home.verify_Element("ThisIsMyWay_Txt"), "'This is my way Text..' is not displayed");

        LOGGER.info("Step10: Verify Name entered from Previous screen");
        softAssert.assertEquals(home.getText_Element("verifyNameEntered_Lbl"), nameEntered);

        LOGGER.info("Step11: Verify Car entered from Previous screen");
        softAssert.assertEquals(home.getText_Element("verifyCarSelected_Lbl"), selectedDropdown);

        LOGGER.info("Step12: Click on Link ");
        home.click_Element("clickHere_Link");

        LOGGER.info("Step13: Verify Car Volvo is selected back again");
        softAssert.assertEquals(home.getText_Element("SelectDropdown"), "Volvo");

    }
}
