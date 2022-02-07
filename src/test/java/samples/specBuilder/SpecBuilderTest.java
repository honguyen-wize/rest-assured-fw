package samples.specBuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;
import samples.common.Utils;
import samples.pojo.entities.PayloadLocation;
import samples.pojo.entities.PayloadPlace;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SpecBuilderTest {
    @Test
    public void payloadBuilderTest(){
        PayloadPlace payloadPlace = this.getPayloadPlace();
        RequestSpecification defaultRequestSpec= new RequestSpecBuilder().setBaseUri("http://3.6.24.244")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON)
                .build();

        ResponseSpecification defaultResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        // Make a general request specification
        RequestSpecification resSpec = given().spec(defaultRequestSpec).body(payloadPlace);

        // Call Add Place API with the created resSpec
        Response responseAddPlace = resSpec.when().post("maps/api/place/add/json")
                .then().log().all().spec(defaultResponseSpec).extract().response();

        String placeId = Utils.stringToJsonPath(responseAddPlace.asString()).getString("place_id");

        // Call Get Place API with the created resSpec
        Response responseGetPlace = resSpec.queryParam("place_id", placeId)
                .when().get("/maps/api/place/get/json")
                .then().log().all().spec(defaultResponseSpec).extract().response();
    }

    private PayloadPlace getPayloadPlace(){
        PayloadPlace payloadPlace = new PayloadPlace();
        payloadPlace.setName("Ho Payload");
        payloadPlace.setAccuracy(33);
        payloadPlace.setAddress("Moonlight Park View, KP5");
        payloadPlace.setLanguage("Vietnam - VN");
        payloadPlace.setPhone_number("(+64) 983 893 3937");
        payloadPlace.setWebsite("http://google.com");

        List<String> types = new ArrayList<>();
        types.add("Shoe Park");
        types.add("Aeon Mall");
        payloadPlace.setTypes(types);

        PayloadLocation location = new PayloadLocation();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        payloadPlace.setLocation(location);

        return payloadPlace;
    }
}
