package ApiTests;

import API_Automation.Base.BaseMethods;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;


public class TC001_Testone extends BaseMethods {

    @Test
    public void verifyUsersList_GET() {
        Response response = sendGetRequest(BASE_URL + rp.readProp("users"), null, null, null);
        assertThatStatusCodeIsOK(response);
        validateSchema(response, "src/main/resources/Schema/users.json");
    }


    @Test
    public void validateAddUser_POST() {
        JSONObject body = new JSONObject();
        body.put("name", "Bryant");
        body.put("job", "BA");

        Response response = sendPostRequest(BASE_URL + rp.readProp("users"), body, null, null);
        assertThatStatusCodeEquals(response, 201);
        assertThatResponseParameterNotNull(response, "id");
        validateSchema(response, "src/main/resources/Schema/addUser.json");
    }
}
