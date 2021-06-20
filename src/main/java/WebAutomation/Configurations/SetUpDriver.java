package WebAutomation.Configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.logging.Logger;


public class SetUpDriver {
    public static SoftAssert softAssert;
    public static final Logger LOGGER = Logger.getLogger(SetUpDriver.class.getName());
    public static WebDriver driver;


    public static void setupApplication() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://jqueryui.com/");
        softAssert = new SoftAssert();
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDownDriver(){
        driver.quit();
    }


    public static WebDriver getDriver() {
        return driver;
    }
}


