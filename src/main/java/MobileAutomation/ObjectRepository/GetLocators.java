package MobileAutomation.ObjectRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class GetLocators {

    public Properties gettingLocator() throws IOException {
        String projectPath = System.getProperty("user.dir");
        Properties props = new Properties();
        InputStream input;
        input = new FileInputStream(projectPath+"/src/main/java/MobileAutomation/ObjectRepository/locators.properties");
        props.load(input);
        return props;
    }
}