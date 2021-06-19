package MobileAutomation.Configuration.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class appiumDriver {
    public static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> InitiateApp() {
        String projectPath = System.getProperty("user.dir");
        Properties capabilities_data = new Properties();
        InputStream input;
        {
            try {
                input = new FileInputStream(projectPath+"/src/main/java/MobileAutomation/Configuration/AppiumDriver/capabilities.properties");
                capabilities_data.load(input);

                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, capabilities_data.getProperty("PLATFORM_NAME"));
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, capabilities_data.getProperty("PLATFORM_VERSION"));
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, capabilities_data.getProperty("DEVICE_NAME"));
                caps.setCapability(MobileCapabilityType.UDID, capabilities_data.getProperty("UDID"));
                caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, capabilities_data.getProperty("AUTOMATION_NAME"));
                caps.setCapability("appPackage", capabilities_data.getProperty("appPackage"));
                caps.setCapability("appActivity", capabilities_data.getProperty("appActivity"));
                driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub")  , caps);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
}
