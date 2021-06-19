import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Configuration.SetupDriver.setupDriverInit;
import MobileAutomation.Screens.HomeScreen;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test007_ValidatingPopUpTapAndDismiss extends SetupLaunch{

    AppiumDriver driver = setupDriverInit.getDriver();

    @Test
    public void test007_validatingPopUpTapAndDismiss() throws IOException {

        SetupLaunch.setupApplication();

        HomeScreen home = new HomeScreen();
        home.click_Element("DispPopupWindow_Btn");
        home.verify_Element("PopUpDismiss_Btn");

    }
}
