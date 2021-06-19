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

        SetupLaunch.setupApplication();

        HomeScreen home = new HomeScreen();
        home.click_Element("Registration_Btn");
        home.verifyText_Element(driver, "RegisterWelcome_Lbl", "Welcome to register a new User");

        home.pressBackButton();

        home.verify_Element("RegisterScreenTitle");
        home.verify_Element("Username_Lbl");
        home.verify_Element("Email_Lbl");


        home.verify_Element("Password_Lbl");
        home.verify_Element("Name_Lbl");


        home.verify_Element("ProgLang_Lbl");
        home.verify_Element("TandC_Lbl");

        home.verify_Element("Username_Txt");
        home.verify_Element("Email_Txt");
        home.verify_Element("Password_Txt");
        home.verify_Element("Name_Txt");
        home.verify_Element("ProgLang_Drd");
        home.verify_Element("TandC_Chk");
        home.verify_Element("RegisterUser_Btn");


//        Check if the Name field is pre-populated with 'Mr. Burns'
        home.verifyText_Element(driver, "Name_Txt", "Mr. Burns");

//        Check if 'Ruby' is selected as Programming Language by default
        home.verifyText_Element(driver, "ProgLand_DrdSelectedTxt", "Ruby");

        home.input_Element(driver, "Username_Txt", "Username");
        home.input_Element(driver, "Email_Txt", "Email");
        home.input_Element(driver, "Password_Txt", "Password");


        home.click_Element("TandC_Chk");
        home.click_Element("RegisterUser_Btn");


        RegisterUserScreen compareDetails = new RegisterUserScreen();
//        compareDetails.compareTextRegisterUser(driver, "VerifyName_Lbl", "Name");
        compareDetails.compareTextRegisterUser(driver, "VerifyUsername_Lbl", "Username");
        compareDetails.compareTextRegisterUser(driver, "VerifyPassword_Lbl", "Password");
        compareDetails.compareTextRegisterUser(driver, "VerifyEmail_Lbl", "Email");

        home.click_Element("VerifyRegisterUser_Btn");
        home.verify_Element("HomeScreen");

    }
}
