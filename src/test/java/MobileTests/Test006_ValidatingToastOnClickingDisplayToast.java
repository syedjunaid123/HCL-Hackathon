package MobileTests;

import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Screens.HomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class Test006_ValidatingToastOnClickingDisplayToast extends SetupLaunch{

    @Test
    public void test006_validatingToastOnClickingDisplayToast() throws IOException {

        LOGGER.info("Step1: Application is Launched");
        SetupLaunch.setupApplication();

        LOGGER.info("Step2: Click on Display Toast Button");
        HomeScreen home = new HomeScreen();
        home.click_Element("DispToast_Btn");

        LOGGER.info("Step3: Validate the Toast Button");
        Assert.assertTrue(home.verify_Element("Display_Toast"), "Toast Message is not displayed");
    }
}
