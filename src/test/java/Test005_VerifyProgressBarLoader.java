import MobileAutomation.Configuration.SetupDriver.SetupLaunch;
import MobileAutomation.Configuration.SetupDriver.setupDriverInit;
import MobileAutomation.Screens.HomeScreen;
import MobileAutomation.Screens.HomeUserScreen;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test005_VerifyProgressBarLoader extends SetupLaunch{

    AppiumDriver driver = setupDriverInit.getDriver();


    @Test
    public void test005_verifyProgressBarLoader() throws IOException, InterruptedException {

        SetupLaunch.setupApplication();

        HomeScreen home = new HomeScreen();
        HomeUserScreen home_screen = new HomeUserScreen();

        home.click_Element("ShowProgressBar_Btn");
        home_screen.verify_ProgressBar(driver, "ShowProgressBar_PopUp");

        home.verify_Element("RegisterScreenTitle");

    }
}
