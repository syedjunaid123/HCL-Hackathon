package WebAutomation.Pages;


import WebAutomation.Configurations.SetUpDriver.SetUpDriver;
import WebAutomation.ObjectRepository.GetLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;


public class BaseMethods extends GetLocators {

    WebDriver driver = SetUpDriver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 60);
    Properties props = this.gettingLocator();

    public BaseMethods() throws IOException {
    }

    public boolean verify_Element(String param) {
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

    public void switchToFrame(String frameLocator){
        WebElement Frame = driver.findElement(By.xpath(props.getProperty(frameLocator)));
        driver.switchTo().frame(Frame);
    }


//    public void input_Element(String param, String data) throws IOException {
//        dataProps.gettingTestData();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(param)))).sendKeys(dataProps.gettingTestData(data));
//    }

    public Boolean verifyText_Element(String param, String textToCompare) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(props.getProperty(param)), textToCompare));
        return  true;
    }

    }


