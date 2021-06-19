package MobileAutomation.Configuration.SetupDriver;

import UtilsCommon.PropertiesConfig.readProperties;
import MobileAutomation.Configuration.AppiumDriver.appiumDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.util.logging.Logger;

/**
 * Author
 * Vani Goyal, 2020
 */

public class setupDriverInit {
    public static AppiumDriver driver;
    public static AppiumDriverLocalService service;
    public static SoftAssert softAssert;
    public static final Logger LOGGER = Logger.getLogger(setupDriverInit.class.getName());

    static readProperties rp = new readProperties();
    static String Platform = rp.readProp("PLATFORM");


    public static void setUpDriver() throws MalformedURLException {
        softAssert = new SoftAssert();
        LOGGER.info("**************  Initializing driver  **************");
        try {

                LOGGER.info("********************* Launched in Android Driver *******************");
                driver = appiumDriver.InitiateApp();
                Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void tearDownDriver() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (driver != null) {
            driver.quit();
            driver = null;
            LOGGER.info("**************  Closing driver  **************");
        }
    }
    public static AppiumDriver getDriver() {
        return driver;
    }
}
