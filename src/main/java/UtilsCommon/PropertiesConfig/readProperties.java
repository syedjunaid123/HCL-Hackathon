package UtilsCommon.PropertiesConfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readProperties {

        public String readProp(String property) {
            Properties prop = new Properties();
            FileInputStream ip = null;
            try {
                ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/MobileAutomation/Configuration/AppiumDriver/capabilities.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return prop.getProperty(property);
        }
    }

