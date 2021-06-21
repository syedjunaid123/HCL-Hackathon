package WebAutomation.Configurations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;


public class SetUpDriver {
    public static SoftAssert softAssert;
    public static final Logger LOGGER = Logger.getLogger(SetUpDriver.class.getName());
    public static WebDriver driver;
    public static ExtentReports extent = new ExtentReports();

    public static String projectPath = System.getProperty("user.dir");
    public static String timestamp = String.valueOf(new Date().getTime());
    public static String reportPath = projectPath+"/src/test/resources/ExtentReport/Report"+timestamp+".html";

    public static void setupApplication() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://jqueryui.com/");
        softAssert = new SoftAssert();
        driver.manage().window().maximize();

    }

    public static ExtentTest report(String TestCase) {
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent.attachReporter(spark);
        ExtentTest test = extent.createTest(TestCase);
        return test;
    }

    @AfterClass
    public static void tearDownDriver() {
        extent.flush();
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}


