package MobileAutomation.Screens;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;

import MobileAutomation.ObjectRepository.GetLocators;


public class LaunchAppScreen extends GetLocators{

    public AppiumDriver<MobileElement> launch_screen(AppiumDriver<MobileElement> driver, String param ) throws IOException {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        Properties props = this.gettingLocator();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(props.getProperty(param)))).click();
        return  driver;

    }
}
