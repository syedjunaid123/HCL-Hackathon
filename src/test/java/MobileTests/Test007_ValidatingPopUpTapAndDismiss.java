package MobileTests;

import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Screens.HomeScreen;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test007_ValidatingPopUpTapAndDismiss extends SetupLaunch{

    @Test
    public void test007_validatingPopUpTapAndDismiss() throws IOException {

        LOGGER.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        LOGGER.info("Step2: Click on Display Pop Up Button");
        HomeScreen home = new HomeScreen();
        home.click_Element("DispPopupWindow_Btn");

        LOGGER.info("Step3: Click Dismiss Button");
        home.verify_Element("PopUpDismiss_Btn");
    }
}
