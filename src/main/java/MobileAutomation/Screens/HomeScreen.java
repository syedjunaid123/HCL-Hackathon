package MobileAutomation.Screens;

import MobileAutomation.Configuration.SetupDriver.setupDriverInit;
import MobileAutomation.ObjectRepository.GetLocators;
import MobileAutomation.DataRepository.GetTestData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;




public class HomeScreen extends GetLocators {

    AppiumDriver driver = setupDriverInit.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 60);
    GetTestData dataProps = new GetTestData();
    Properties props = this.gettingLocator();

    public HomeScreen() throws IOException {
    }


    public boolean verify_Element(String param ) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(param)))).isDisplayed();
        return true;
    }

    public void click_Element(String param) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(param)))).click();
    }

    public void getText_Element(String param) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(param)))).getText();
        return;
    }

    public void input_Element(String param, String data) throws IOException {
        dataProps.gettingTestData();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(param)))).sendKeys(dataProps.gettingTestData(data));
    }

    public Boolean verifyText_Element(String param, String textToCompare) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(props.getProperty(param)), textToCompare));
        return  true;
    }

    public void scrollToBottom() {
        int  x = driver.manage().window().getSize().width / 2;
        int start_y = (int) (driver.manage().window().getSize().height * 0.2);
        int end_y = (int) (driver.manage().window().getSize().height * 0.8);
        TouchAction dragNDrop = new TouchAction(driver)
                .press(PointOption.point(x,start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, end_y))
                .release();
        dragNDrop.perform();

    }

    public void pressBackButton(){
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }

}

