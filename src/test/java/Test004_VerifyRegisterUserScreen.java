import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Configuration.SetupDriver.setupDriverInit;
import MobileAutomation.Screens.HomeScreen;
import MobileAutomation.Screens.RegisterUserScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;


import java.io.IOException;


public class Test004_VerifyRegisterUserScreen extends SetupLaunch{

    AppiumDriver driver = setupDriverInit.getDriver();


    @Test
    public void test004_verifyRegisterUserScreen() throws IOException {

        LOGGER.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        LOGGER.info("Step2: Click Register Button");
        HomeScreen home = new HomeScreen();
        home.click_Element("Registration_Btn");

        LOGGER.info("Step3: Verify the Text of an element");
        softAssert.assertTrue(home.verifyText_Element("RegisterWelcome_Lbl", "Welcome to register a new User"));

        LOGGER.info("Step4: Click Back Button to hide the Input Keypad");
        home.pressBackButton();

        LOGGER.info("Step5: Validate if the register screen title is displayed");
        softAssert.assertTrue(home.verify_Element("RegisterScreenTitle"), "Register Screen Title is not displayed");

        LOGGER.info("Step6: Validate if the Username Label is displayed");
        softAssert.assertTrue(home.verify_Element("Username_Lbl"), "Userame label is not displayed");

        LOGGER.info("Step7: Validate if the Email Label is displayed");
        softAssert.assertTrue(home.verify_Element("Email_Lbl"), "Email Label is not displayed");

        LOGGER.info("Step8: Validate if the Password Label is displayed");
        softAssert.assertTrue(home.verify_Element("Password_Lbl"), "Password Label is not displayed");

        LOGGER.info("Step9: Validate if the Name Label is displayed");
        softAssert.assertTrue(home.verify_Element("Name_Lbl"), "Name Label is not displayed");

        LOGGER.info("Step10: Validate if the Programming Language Label is displayed");
        softAssert.assertTrue(home.verify_Element("ProgLang_Lbl"), "Programming Label is not displayed");

        LOGGER.info("Step11: Validate if the Terms and condition Label is displayed");
        softAssert.assertTrue(home.verify_Element("TandC_Lbl"), "TandC Label is not displayed");

        LOGGER.info("Step12: Validate if the Username Text Input is displayed");
        softAssert.assertTrue(home.verify_Element("Username_Txt"), "Username Text Input is not displayed");

        LOGGER.info("Step13: Validate if the Email Text Input is displayed");
        softAssert.assertTrue(home.verify_Element("Email_Txt"), "Email Text Input is not displayed");

        LOGGER.info("Step14: Validate if the Password Text Input is displayed");
        softAssert.assertTrue(home.verify_Element("Password_Txt"), "Password Text Input is not displayed");

        LOGGER.info("Step15: Validate if the Name Text Input is displayed");
        softAssert.assertTrue(home.verify_Element("Name_Txt"), "Name Text Input is not displayed");

        LOGGER.info("Step16: Validate if the Programming Language DropDown is displayed");
        softAssert.assertTrue(home.verify_Element("ProgLang_Drd"), "Programming Language DropDown is not displayed");

        LOGGER.info("Step17: Validate if the TandC Checkbox is displayed");
        softAssert.assertTrue(home.verify_Element("TandC_Chk"), "TandC Checkbox is not displayed");

        LOGGER.info("Step18: Validate if the RegisterUser Button is displayed");
        softAssert.assertTrue(home.verify_Element("RegisterUser_Btn"), "RegisterUser Button is not displayed");

        LOGGER.info("Step19: Validate the text if Name Text 'Mr. Burns' is displayed");
        softAssert.assertTrue(home.verifyText_Element("Name_Txt", "Mr. Burns"));

        LOGGER.info("Step20: Validate if Programming Language Dropdown is selected as 'Ruby'");
        softAssert.assertTrue(home.verifyText_Element("ProgLand_DrdSelectedTxt", "Ruby"));

        LOGGER.info("Step21: Enter Username");
        home.input_Element("Username_Txt", "Username");

        LOGGER.info("Step22: Enter Email Id");
        home.input_Element("Email_Txt", "Email");

        LOGGER.info("Step23: Enter Password");
        home.input_Element("Password_Txt", "Password");

        LOGGER.info("Step24: Click Terms and conditions CheckBox");
        home.click_Element("TandC_Chk");

        LOGGER.info("Step25: Click Register User Button");
        home.click_Element("RegisterUser_Btn");

        LOGGER.info("Step26: Verify the Username entered is matching");
        RegisterUserScreen compareDetails = new RegisterUserScreen();
        softAssert.assertTrue(compareDetails.compareTextRegisterUser("VerifyUsername_Lbl", "Username"), "Username is not reflected");

        LOGGER.info("Step27: Verify the password entered is matching");
        softAssert.assertTrue(compareDetails.compareTextRegisterUser("VerifyPassword_Lbl", "Password"), "Password is not reflected");

        LOGGER.info("Step28: Verify the Email_id entered is matching");
        softAssert.assertTrue(compareDetails.compareTextRegisterUser("VerifyEmail_Lbl", "Email"), "Email Id is not reflected");

        LOGGER.info("Step29: Click Verify Register User button");
        home.click_Element("VerifyRegisterUser_Btn");

        LOGGER.info("Step30: Validate if the flow is navigated back to HomeScreen");
        softAssert.assertTrue(home.verify_Element("HomeScreen"), "Flow is not navigated back to HomeScreen");

    }
}
