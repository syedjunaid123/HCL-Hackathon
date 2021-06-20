package WebAutomation.Pages;

import WebAutomation.Configurations.SetUpDriver.SetUpDriver;
import WebAutomation.ObjectRepository.GetLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.Properties;

public class ControlGroupPage extends GetLocators {
    WebDriver driver = SetUpDriver.getDriver();
    Properties props = this.gettingLocator();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions action = new Actions(driver);

    public ControlGroupPage() throws IOException {
    }

    public void selectControlGroupElements() {
        WebElement Automatic_Opt = driver.findElement(By.xpath(props.getProperty("Automatic_Opt")));
        WebElement InsuranceHorizontal_Chk = driver.findElement(By.xpath(props.getProperty("InsuranceHorizontal_Chk")));
        WebElement Standard_Opt = driver.findElement(By.xpath(props.getProperty("Standard_Opt")));
        WebElement InsuranceVertical_Chk = driver.findElement(By.xpath(props.getProperty("InsuranceVertical_Chk")));

        Automatic_Opt.click();
        InsuranceHorizontal_Chk.click();
        Standard_Opt.click();
        InsuranceVertical_Chk.click();
    }
}
