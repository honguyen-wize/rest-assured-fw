package samples.pojo;

import io.restassured.RestAssured;
import org.junit.Test;
import samples.pojo.entities.PayloadPlace;
import samples.pojo.entities.PayloadLocation;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SerializeJavaObject2JsonPayloadTest {

//    @Test
    public void payloadBuilderTest(){
        RestAssured.baseURI = "http://3.6.24.244";
        // Build the following json structure
            //        {
            //            "location": {
            //            "lat": -38.383494,
            //                    "lng": 33.427362
            //        },
            //            "accuracy": 50,
            //                "name": "Ho C6.02",
            //                "phone_number": "(+91) 983 893 3937",
            //                "address": "29, side layout, cohen 09",
            //                "types": [
            //                    "shoe park",
            //                    "shop"
            //                ],
            //            "website": "http://google.com",
            //                "language": "French-IN"
            //        }
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

        // use the Java object to send to the body
        given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(payloadPlace)
                .when().post("maps/api/place/add/json")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response();
    }
}
