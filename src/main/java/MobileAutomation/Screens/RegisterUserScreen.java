package MobileAutomation.Screens;

import MobileAutomation.Configuration.SetupDriver.setupDriverInit;
import MobileAutomation.DataRepository.GetTestData;
import MobileAutomation.ObjectRepository.GetLocators;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.Properties;

public class RegisterUserScreen extends GetLocators {

    AppiumDriver driver = setupDriverInit.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    Properties props = this.gettingLocator();
    GetTestData dataProps = new GetTestData();
    private String TextRetrieved;
    private String TextInput;

    public RegisterUserScreen() throws IOException {
    }

    public boolean compareTextRegisterUser(String param, String data) throws IOException {
        TextRetrieved = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(param)))).getText();
        Assert.assertEquals(dataProps.gettingTestData(data), TextRetrieved);
        return  true;
    }
}