package ApiTests;

import API_Automation.Base.BaseMethods;
import WebAutomation.Configurations.SetUpDriver;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class Test002_API_Test_ValidateAddUser extends BaseMethods {
    String TestName = this.getClass().getSimpleName();

    @Test
    public void validateAddUser_POST() {
        ExtentTest Step = SetUpDriver.report(TestName);

        JSONObject body = new JSONObject();
        body.put("name", "Bryant");
        body.put("job", "BA");

        Step.info("Step1: Execute the API");
        Response response = sendPostRequest(BASE_URL + rp.readProp("users"), body, null, null);

        Step.info("Step2: Validate if the response is '201 Created'");
        assertThatStatusCodeEquals(response, 201);

        Step.info("Step3: Validate if the value for 'id' is retrieving");
        assertThatResponseParameterNotNull(response, "id");

        Step.info("Step4: Validate Schema of Response Payload");
        validateSchema(response, "addUser.json");
    }
}
