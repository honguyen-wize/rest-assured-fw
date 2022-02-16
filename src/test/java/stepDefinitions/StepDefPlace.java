package stepDefinitions;

import api.configuration.APIResources;
import common.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import common.BaseRequest;
import common.PayloadBuild;
import org.junit.Assert;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.FileNotFoundException;
import static io.restassured.RestAssured.given;

public class StepDefPlace extends BaseRequest {

    RequestSpecification resSpec;
    Response response;
    PayloadBuild payloadBuild = new PayloadBuild();
    protected static String placeIdFromAddPlaceResponse; // "static" to share place id among test cases

    @Given("Add place Payload with {string} {string} {string}")
    public void add_place_payload_is_created(String name, String language, String address) throws FileNotFoundException {
        // Prepare request specification
        resSpec = given().spec(getDefaultRequestSpecification())
                .body(payloadBuild.getAddPlacePayload(name, language, address));
    }
    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resourceName, String apiMethod) {
        APIResources resourcesAPI = APIResources.valueOf(resourceName);
        String resourcePath = resourcesAPI.getResource();

        if(apiMethod.equalsIgnoreCase("POST")){
            response = resSpec.when().post(resourcePath);
        } else if (apiMethod.equalsIgnoreCase("GET")){
            response = resSpec.when().get(resourcePath);
        }
    }

    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(int expectedStatusCode) {
        assertEquals(response.getStatusCode(), expectedStatusCode);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String apiField, String expectedValue) {
        String actualValue = Utils.getValueFromKeyInResponse(response, apiField);
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Then("verify created place_id maps to {string} using {string}")
    public void verify_created_maps_to_using(String expectedName, String resourceName) throws FileNotFoundException {
        // get place id from the ADD api call
        placeIdFromAddPlaceResponse = Utils.getValueFromKeyInResponse(response, "place_id");
        System.out.println("Added Place ID: " + placeIdFromAddPlaceResponse);

        // prepare the requestSpec with query para place_id
        resSpec = given().spec(getDefaultRequestSpecification())
                .queryParam("place_id", placeIdFromAddPlaceResponse);

        // call GET Place API from the created place_id
        user_calls_with_http_request(resourceName, "GET");

        String actualNameFromGetPlaceResponse= Utils.getValueFromKeyInResponse(response,"name");
        Assert.assertEquals(actualNameFromGetPlaceResponse, expectedName);
    }

    @And("the added place has the correct schema")
    public void verify_added_place_schema(){
        JsonSchemaValidator validator = JsonSchemaValidator.matchesJsonSchemaInClasspath("schema-place.json");
        response.then().assertThat().body(validator);
    }

    @Given("Delete place Payload")
    public void delete_place_payload() throws FileNotFoundException {
        System.out.println("delete place id: " + placeIdFromAddPlaceResponse);

        resSpec = given().spec(getDefaultRequestSpecification())
                .body(payloadBuild.deletePlacePayload(placeIdFromAddPlaceResponse));
    }
}
