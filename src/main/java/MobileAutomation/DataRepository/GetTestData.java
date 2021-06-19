package MobileAutomation.DataRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class GetTestData {

    public CharSequence gettingTestData(String data) throws IOException {
        String projectPath = System.getProperty("user.dir");
        Properties dataProps = new Properties();
        InputStream input;
        input = new FileInputStream(projectPath+"/src/main/java/MobileAutomation/DataRepository/testData.properties");
        dataProps.load(input);
        return data;
    }

    public void gettingTestData() {
    }
}