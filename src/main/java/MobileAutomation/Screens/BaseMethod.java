package MobileAutomation.Screens;

import MobileAutomation.Configuration.SetupDriver.setupDriverInit;
import MobileAutomation.ObjectRepository.GetLocators;
import MobileAutomation.DataRepository.GetTestData;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class BaseMethod extends GetLocators {

    AppiumDriver driver = setupDriverInit.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 60);
    GetTestData dataProps = new GetTestData();
    Properties props = this.gettingLocator();

    public BaseMethod() throws IOException {
    }

    public boolean verify_Element(String param) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(param)))).isDisplayed();
        return true;
    }

    public void click_Element(String param) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(param)))).click();
    }

    public void click_ElementId(String param) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(props.getProperty(param)))).click();
    }

    public void click_Element1(String locator, String by) {
        switch (by) {
            case "id":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(props.getProperty(locator)))).click();
        }
    }

    public String getText_Element(String param) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(param)))).getText();
    }

    public String input_Element(String param, String data) throws IOException {
        dataProps.gettingTestData();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(param)))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(param)))).sendKeys(dataProps.gettingTestData(data));
        return data;
    }

    public Boolean verifyText_Element(String param, String textToCompare) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(props.getProperty(param)), textToCompare));
        return true;
    }

    public void pressBackButton() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }
}

