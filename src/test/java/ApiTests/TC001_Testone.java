package ApiTests;

import API_Automation.Base.BaseMethods;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;


public class TC001_Testone extends BaseMethods {
    public HashMap<String, String> setQueryParams() throws JSONException {
        return new HashMap<String, String>() {
            {
                put("page", "2");
            }
        };
    }


    @Test
    public void verifyUsersList_GET() {

        Response response = sendGetRequest(BASE_URL + rp.readProp("users"), null, setQueryParams(), null);
        assertThatStatusCodeIsOK(response);
        validateSchema(response, "users.json");
        assertThatResponseParameterEquals(response, "data[3].first_name", "Byron");
    }

    @Test
    public void validateAddUser_POST() {
        JSONObject body = new JSONObject();
        body.put("name", "Bryant");
        body.put("job", "BA");

        Response response = sendPostRequest(BASE_URL + rp.readProp("users"), body, null, null);
        assertThatStatusCodeEquals(response, 201);
        assertThatResponseParameterNotNull(response, "id");
        validateSchema(response, "addUser.json");
    }
}
