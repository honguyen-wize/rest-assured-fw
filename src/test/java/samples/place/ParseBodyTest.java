package samples.place;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import samples.common.Utils;
import samples.payload.Payload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParseBodyTest {
    public static void main(String[] args){
        // Validate if Add Place API works
        // Add Place -> Update Place with new address -> Get Place to validate if the new address is present

        // given: all input details
        // when: submit api - resource, http method
        // then: validate response

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // Add Place
        String response = given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(Payload.getPlacePayload())
            .when().post("maps/api/place/add/json")
            .then().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.18 (Ubuntu)")
                .extract().response().asString();

        JsonPath jsonPath = Utils.stringToJsonPath(response);
        String placeId = jsonPath.getString("place_id");

        System.out.println("place_id in the response: " + placeId);

        // Update the added place
        String updatedAddress = "Viettel Building";
        given().log().all()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + placeId + "\",\n" +
                        "\"address\":\"" + updatedAddress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
            .when().put("/maps/api/place/update/json")
            .then().assertThat().log().all().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        // Get the updated Place
        String getPlaceResponse = given()
                    .queryParam("key", "qaclick123")
                    .queryParam("place_id", placeId)
                .when().get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200)
                    .extract().response().asString();

        jsonPath = Utils.stringToJsonPath(getPlaceResponse);
        String actualAddress = jsonPath.getString("address");

        Assert.assertEquals(actualAddress, updatedAddress);

    }
}
