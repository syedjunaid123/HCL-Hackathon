package API_Automation.Base;

import API_Automation.Endpoints.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BaseMethods {
    public static ReadProperties rp = new ReadProperties();
    static String CONTENT_TYPE_APPLICATION_JSON = "application/json";
    public static String BASE_URL = rp.readProp("baseurl");
//    public static String testEnv;
//    public static String loginurl = BASE_URL + rp.readProp("onboardingPrefix") + rp.readProp("access_public") + rp.readProp("login_url");
//    //public static String accessToken = rp.readProp("accessToken");
//
//    public static String deviceHash;
//    public static String deviceId;
//    public static String mobileNumber;
//    public static String accessToken;
//    public static String refreshToken;
//    public static String userId;
//    public static String otp;


    public Response sendGetRequest(String url, Map<String, String> headerParameters, Map<String, String> queryParameters, Map<String, String> pathParameters) {
        // Create RequestSpecification
        String apiUrl = url;
        RequestSpecification requestSpecification = RestAssured.given().baseUri(apiUrl);

        //requestSpecification = setHeader(requestSpecification, apiUrl);

        // Build Query parameters into RequestSpecification
        if (queryParameters != null) {
            requestSpecification.queryParams(queryParameters);
        }

        // Build Path parameters into RequestSpecification
        if (pathParameters != null) {
            requestSpecification.pathParams(pathParameters);
        }

        // Build Header parameters into RequestSpecification
        if (headerParameters != null) {
            for (Map.Entry<String, String> headerParameter : headerParameters.entrySet()) {
                requestSpecification.header(headerParameter.getKey(), headerParameter.getValue());
            }
        }

        // Send Get Request
        Response response = requestSpecification.log().all().request(Method.GET, apiUrl);
        System.out.println("Response Code: " + response.statusCode() + "\n" + response.asString());
        return response;
    }


    public Response sendPostRequest(String url, JSONObject requestBody, Map<String, String> headerParameters, Map<String, String> queryParameters) {
        // Create RequestSpecification
        String apiUrl = url;
        RequestSpecification requestSpecification;

        if (requestBody == null) {
            requestSpecification = RestAssured.given();
        } else {
            requestSpecification = RestAssured.given().body(requestBody.toString()).with().contentType(CONTENT_TYPE_APPLICATION_JSON);
        }

        // Build Query parameters
        if (queryParameters != null) {
            requestSpecification.queryParams(queryParameters);
        }

        // Build Header parameters into RequestSpecification
        if (headerParameters != null) {
            for (Map.Entry<String, String> headerParameter : headerParameters.entrySet()) {
                requestSpecification.header(headerParameter.getKey(), headerParameter.getValue());
            }
        }

        // Send Post Request
        Response response = requestSpecification.when().log().all().post(apiUrl);
        System.out.println("Response Code: " + response.statusCode() + "\n" + response.asString());
        return response;
    }

    public void assertThatStatusCodeIsOK(Response response) {
        assertThatStatusCodeEquals(response, 200);
    }


    public void assertThatStatusCodeEquals(Response response, int expectedStatusCode) {
        assertThatResponseIsNotNull(response);
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "The Status code of the Response is different than expected");
    }


    public void assertThatResponseIsNotNull(Response response) {
        Assert.assertNotNull(response, "The Response object is null");
    }


    public Object getNodeResponseValue(Response response, String parameterPath) {
        return (response.getBody().jsonPath().get(parameterPath)).toString();
    }

    public void assertThatResponseParameterNotNull(Response response, String parameterPath) {
        Assert.assertNotNull(response.getBody());
        Assert.assertNotNull(getNodeResponseValue(response, parameterPath));
    }


    public void assertThatResponseParameterEquals(Response response, String parameterPath, Object expectedParameterValue) {
        Assert.assertEquals(getNodeResponseValue(response, parameterPath), expectedParameterValue, String.format("The value of '%s' parameter is different than expected", parameterPath));
    }

    public void validateSchema(Response response, String schemaPath) {
        System.out.println("json schema path " + schemaPath);
        System.out.println(this.getClass().getResource("/").getPath());

        response.then().assertThat().body(matchesJsonSchemaInClasspath(schemaPath));
    }


//    public void verifySchema(string response, String schemaPath){
//        response.then().assertThat().body(matchesJsonSchemaInClasspath(schemaPath));
//    }
}
