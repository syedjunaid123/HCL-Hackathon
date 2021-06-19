import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Configuration.SetupDriver.setupDriverInit;
import MobileAutomation.Screens.HomeScreen;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test006_ValidatingToastOnClickingDisplayToast extends SetupLaunch{

    AppiumDriver driver = setupDriverInit.getDriver();

    @Test
    public void test006_validatingToastOnClickingDisplayToast() throws IOException {

        SetupLaunch.setupApplication();

        HomeScreen home = new HomeScreen();
        home.click_Element("DispToast_Btn");
        home.verify_Element("Display_Toast");

    }
}
