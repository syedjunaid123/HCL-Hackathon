package MobileAutomation.Screens;

import MobileAutomation.Configuration.SetupDriver.setupDriverInit;
import MobileAutomation.ObjectRepository.GetLocators;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class HomeUserScreen extends GetLocators {

    AppiumDriver driver = setupDriverInit.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 60);
    Properties props = this.gettingLocator();

    public HomeUserScreen() throws IOException {
    }

    public boolean verify_ProgressBar(String param ){
        try{
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(props.getProperty(param))));
        return false;
        }
        catch(NoSuchElementException e){
            return true;
        }
    }
}
