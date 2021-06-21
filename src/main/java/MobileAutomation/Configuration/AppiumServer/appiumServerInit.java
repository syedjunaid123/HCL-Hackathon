package MobileAutomation.Configuration.AppiumServer;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.util.logging.Logger;



/**
 * Author By
 * Syed Junaid, Feb 2021
 **/


public class appiumServerInit {

    public static final Logger LOGGER = Logger.getLogger(appiumServerInit.class.getName());

    public static AppiumDriverLocalService getInstance(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .usingPort(4723);

        return AppiumDriverLocalService.buildService(builder);
    }

    public static void Start(){
        LOGGER.info("**************  Starting Appium Server  **************");
        if(!getInstance().isRunning()){
            getInstance().start();
        }
    }

    public static void Stop(){
        LOGGER.info("**************  Terminating Appium Server  **************");
        getInstance().stop();
    }
}