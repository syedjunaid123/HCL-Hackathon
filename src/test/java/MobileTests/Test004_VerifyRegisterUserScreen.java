package MobileTests;

import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Screens.HomeScreen;
import MobileAutomation.Screens.RegisterUserScreen;
import WebAutomation.Configurations.SetUpDriver;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test004_VerifyRegisterUserScreen extends SetupLaunch{
    String TestName = this.getClass().getSimpleName();

    @Test
    public void test004_verifyRegisterUserScreen() throws IOException {
        ExtentTest Step = SetUpDriver.report(TestName);
        
        Step.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        Step.info("Step2: Click Register Button");
        HomeScreen home = new HomeScreen();
        home.click_Element("Registration_Btn");

        Step.info("Step3: Verify the Text of an element");
        softAssert.assertTrue(home.verifyText_Element("RegisterWelcome_Lbl", "Welcome to register a new User"));

        Step.info("Step4: Click Back Button to hide the Input Keypad");
        home.pressBackButton();

        Step.info("Step5: Validate if the register screen title is displayed");
        softAssert.assertTrue(home.verify_Element("RegisterScreenTitle"), "Register Screen Title is not displayed");

        Step.info("Step6: Validate if the Username Label is displayed");
        softAssert.assertTrue(home.verify_Element("Username_Lbl"), "Userame label is not displayed");

        Step.info("Step7: Validate if the Email Label is displayed");
        softAssert.assertTrue(home.verify_Element("Email_Lbl"), "Email Label is not displayed");

        Step.info("Step8: Validate if the Password Label is displayed");
        softAssert.assertTrue(home.verify_Element("Password_Lbl"), "Password Label is not displayed");

        Step.info("Step9: Validate if the Name Label is displayed");
        softAssert.assertTrue(home.verify_Element("Name_Lbl"), "Name Label is not displayed");

        Step.info("Step10: Validate if the Programming Language Label is displayed");
        softAssert.assertTrue(home.verify_Element("ProgLang_Lbl"), "Programming Label is not displayed");

        Step.info("Step11: Validate if the Terms and condition Label is displayed");
        softAssert.assertTrue(home.verify_Element("TandC_Lbl"), "TandC Label is not displayed");

        Step.info("Step12: Validate if the Username Text Input is displayed");
        softAssert.assertTrue(home.verify_Element("Username_Txt"), "Username Text Input is not displayed");

        Step.info("Step13: Validate if the Email Text Input is displayed");
        softAssert.assertTrue(home.verify_Element("Email_Txt"), "Email Text Input is not displayed");

        Step.info("Step14: Validate if the Password Text Input is displayed");
        softAssert.assertTrue(home.verify_Element("Password_Txt"), "Password Text Input is not displayed");

        Step.info("Step15: Validate if the Name Text Input is displayed");
        softAssert.assertTrue(home.verify_Element("Name_Txt"), "Name Text Input is not displayed");

        Step.info("Step16: Validate if the Programming Language DropDown is displayed");
        softAssert.assertTrue(home.verify_Element("ProgLang_Drd"), "Programming Language DropDown is not displayed");

        Step.info("Step17: Validate if the TandC Checkbox is displayed");
        softAssert.assertTrue(home.verify_Element("TandC_Chk"), "TandC Checkbox is not displayed");

        Step.info("Step18: Validate if the RegisterUser Button is displayed");
        softAssert.assertTrue(home.verify_Element("RegisterUser_Btn"), "RegisterUser Button is not displayed");

        Step.info("Step19: Validate the text if Name Text 'Mr. Burns' is displayed");
        softAssert.assertTrue(home.verifyText_Element("Name_Txt", "Mr. Burns"));

        Step.info("Step20: Validate if Programming Language Dropdown is selected as 'Ruby'");
        softAssert.assertTrue(home.verifyText_Element("ProgLand_DrdSelectedTxt", "Ruby"));

        Step.info("Step21: Enter Username");
        home.input_Element("Username_Txt", "Username");

        Step.info("Step22: Enter Email Id");
        home.input_Element("Email_Txt", "Email");

        Step.info("Step23: Enter Password");
        home.input_Element("Password_Txt", "Password");

        Step.info("Step24: Click Terms and conditions CheckBox");
        home.click_Element("TandC_Chk");

        Step.info("Step25: Click Register User Button");
        home.click_Element("RegisterUser_Btn");

        Step.info("Step26: Verify the Username entered is matching");
        RegisterUserScreen compareDetails = new RegisterUserScreen();
        softAssert.assertTrue(compareDetails.compareTextRegisterUser("VerifyUsername_Lbl", "Username"), "Username is not reflected");

        Step.info("Step27: Verify the password entered is matching");
        softAssert.assertTrue(compareDetails.compareTextRegisterUser("VerifyPassword_Lbl", "Password"), "Password is not reflected");

        Step.info("Step28: Verify the Email_id entered is matching");
        softAssert.assertTrue(compareDetails.compareTextRegisterUser("VerifyEmail_Lbl", "Email"), "Email Id is not reflected");

        Step.info("Step29: Click Verify Register User button");
        home.click_Element("VerifyRegisterUser_Btn");

        Step.info("Step30: Validate if the flow is navigated back to HomeScreen");
        softAssert.assertTrue(home.verify_Element("HomeScreen"), "Flow is not navigated back to HomeScreen");

    }
}
