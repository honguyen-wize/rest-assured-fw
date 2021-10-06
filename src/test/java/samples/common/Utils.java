package samples.common;

import io.restassured.path.json.JsonPath;

public class Utils {
    public static JsonPath stringToJsonPath(String response){
        return new JsonPath(response);
    }
}
