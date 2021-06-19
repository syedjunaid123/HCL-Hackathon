import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Screens.HomeScreen;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test002_ValidatingHomeScreenDisplayedAfterSelecting_EN_andDenied extends SetupLaunch{

    @Test
    public void test002_validatingHomeScreenDisplayedAfterSelecting_EN_andDenied() throws IOException {

        LOGGER.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        LOGGER.info("Step2: Click on EN-Button");
        HomeScreen home = new HomeScreen();
        home.click_Element("EN_Btn");

        LOGGER.info("Step3: Click on 'No,No' Button");
        home.click_Element("EN_Deny_Btn");

        LOGGER.info("Step3: Validate if the flow is navigated back to HomeScreen");
        softAssert.assertTrue(home.verify_Element("HomeScreen"), "Flow HomeScreen is not redirected to HomeScreen");

    }
}
