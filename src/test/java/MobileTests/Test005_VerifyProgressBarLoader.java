package MobileTests;

import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Screens.HomeScreen;
import MobileAutomation.Screens.HomeUserScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test005_VerifyProgressBarLoader extends SetupLaunch{

    @Test
    public void test005_verifyProgressBarLoader() throws IOException {

        LOGGER.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        LOGGER.info("Step2: Click on Progress Bar Button");
        HomeScreen home = new HomeScreen();
        home.click_Element("ShowProgressBar_Btn");

        LOGGER.info("Step3: Verify until when the Progress Bar is disappeared");
        HomeUserScreen home_screen = new HomeUserScreen();
        home_screen.verify_ProgressBar("ShowProgressBar_PopUp");

        LOGGER.info("Step4: Validate if the flow is navigated to Register Screen and Title is displayed");
        Assert.assertTrue(home.verify_Element("RegisterScreenTitle"), "RegisterScreen Title is not displayed");
    }
}
