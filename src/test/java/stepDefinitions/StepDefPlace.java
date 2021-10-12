package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import common.BaseRequest;
import common.PayloadBuild;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class StepDefPlace extends BaseRequest {

    RequestSpecification resSpec;
    Response response;
    PayloadBuild payloadBuild = new PayloadBuild();

    @Given("the place Payload is created")
    public void add_place_payload_is_created() throws FileNotFoundException {
        // Make a general request specification
        resSpec = given().spec(getDefaultRequestSpecification())
                .body(payloadBuild.getAddPlacePayload());
    }
    @When("user calls {string} with Post http request")
    public void user_calls_with_post_http_request(String string) {
        response = resSpec.when().post("maps/api/place/add/json")
                .then().log().all().extract().response();
    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(int expectedStatusCode) {
        assertEquals(response.getStatusCode(), expectedStatusCode);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String apiField, String expectedValue) {
        String responseString = response.asString();
        JsonPath js = new JsonPath(responseString);
        String actualValue = js.getString(apiField);

        org.junit.Assert.assertEquals(actualValue,expectedValue);
    }
}
