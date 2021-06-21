package ApiTests;

import API_Automation.Base.BaseMethods;
import WebAutomation.Configurations.SetUpDriver;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.util.HashMap;


public class Test001_API_Test_VerifyUsersList extends BaseMethods {
    String TestName = this.getClass().getSimpleName();

    public HashMap<String, String> setQueryParams() throws JSONException {
        return new HashMap<String, String>() {
            {
                put("page", "2");
            }
        };
    }


    @Test
    public void verifyUsersList_GET() {
        ExtentTest Step = SetUpDriver.report(TestName);

        Step.info("Step1: Execute the API");
        Response response = sendGetRequest(BASE_URL + rp.readProp("users"), null, setQueryParams(), null);

        Step.info("Step2: Validate if the response is 200 OK");
        assertThatStatusCodeIsOK(response);

        Step.info("Step3: Validate Schema of Response Payload");
        validateSchema(response, "users.json");

        Step.info("Step4: Validate if the Value of 'first_name' for 'id': 10 is ‘Byron’");
        assertThatResponseParameterEquals(response, "data[3].first_name", "Byron");
    }
}
