package samples.oauth2;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class OAutth2Test {

//    @Test
    public void oAuth2Test(){
        String code = "4%2F0AX4XfWhA9qf4cYJCO49309tiGPFrBZnEC0um-sQDYoRftPGiavPmRkMtKbyS7--DFpVCaQ";
        String accessToken = "";

        accessToken = "ya29.a0ARrdaM97T6aOi_K5P0BsocOmyQ0VL5q0g7MQ6PqVmKU7BaW2VAcWILnn3uakuaL-sEAGWC3eihIPOAaY215A5rDKzbZ8L7JJp1ikrLL7NbDf6L8uUhFjDGlEytsa2j3j70lqgS2c2kqq3Kw5DMHNQ0I7L8tqfg";

//        String getCodeRespose = given().urlEncodingEnabled(false) // not encode the URL such as % -> other character
//                    .log().all()
//                    .queryParam("code", code)
//                    .queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
//                    .queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
//                    .queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
//                    .queryParam("grant_type", "authorization_code")
//                .when().post("https://www.googleapis.com/oauth2/v4/token")
//                .then().log().all().assertThat().statusCode(200)
//                    .extract().response().asString();
//
//        JsonPath jpCodeResponse = Utils.stringToJsonPath(getCodeRespose);
//        accessToken = jpCodeResponse.getString("access_token");

        String getCourseResponse = given().param("access_token", accessToken)
                .when().get("https://rahulshettyacademy.com/getCourse.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
    }
}
