package samples.place;

import io.restassured.RestAssured;
import samples.common.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DemoStaticJsonPayload {
    public static void main(String[] args) throws IOException {
        // Add Place API works

        String jsonFilePath = "src/test/java/samples/payload/staticPlacePayload.json";

        RestAssured.baseURI = "http://3.6.24.244";
        given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(Utils.generateStringFromJsonFile(jsonFilePath))
        .when().post("maps/api/place/add/json")
        .then().log().all()
                .assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.18 (Ubuntu)");
    }
}
