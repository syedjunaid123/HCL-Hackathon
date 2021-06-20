package WebAutomation.Pages;

import WebAutomation.Configurations.SetUpDriver;
import WebAutomation.ObjectRepository.GetLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.Properties;

public class DroppablePage extends GetLocators {
    WebDriver driver = SetUpDriver.getDriver();
    Properties props = this.gettingLocator();

    public DroppablePage() throws IOException {
    }

    public void dragAndDragElement(String Source, String Target){
        WebElement drag = driver.findElement(By.xpath(props.getProperty(Source)));
        WebElement drop = driver.findElement(By.xpath(props.getProperty(Target)));

        Actions action = new Actions(driver);
        action.dragAndDrop(drag, drop).perform();
    }

}
