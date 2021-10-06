package samples.place;

import io.restassured.RestAssured;
import samples.payload.PlacePayload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo {
    public static void main(String[] args){
        // Validate if Add Place API works

        // given: all input details
        // when: submit api - resource, http method
        // then: validate response

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(PlacePayload.getPlacePayload())
        .when().post("maps/api/place/add/json")
        .then().log().all()
                .assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.18 (Ubuntu)");
    }
}
