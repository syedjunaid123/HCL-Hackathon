package WebAutomation.Pages;
import WebAutomation.Configurations.SetUpDriver;
import WebAutomation.ObjectRepository.GetLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;
import java.util.Properties;

public class SelectablePage extends GetLocators {
    WebDriver driver = SetUpDriver.getDriver();
    Properties props = this.gettingLocator();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions action = new Actions(driver);

    public SelectablePage() throws IOException {
    }

    public void selectItems(){

        WebElement Item1 = driver.findElement(By.xpath(props.getProperty("Item1")));
        WebElement Item3 = driver.findElement(By.xpath(props.getProperty("Item3")));
        WebElement Item7 = driver.findElement(By.xpath(props.getProperty("Item7")));

        js.executeScript("arguments[0].scrollIntoView(true);", Item1);
        action.keyDown(Keys.COMMAND)
            .click(Item1)
            .click(Item3)
            .click(Item7)
            .keyUp(Keys.COMMAND)
            .build()
            .perform();
    }
}
