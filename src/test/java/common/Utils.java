package common;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ResourceBundle;

public class Utils {

    private static ResourceBundle bundle = ResourceBundle.getBundle(System.getProperty("env"));

    public static String getGlobalVariable(String key){
        return bundle.getString(key);
    }

    public static String getValueFromKeyInResponse(Response response, String key){
        JsonPath js = new JsonPath(response.asString());
        return js.getString(key);
    }
}
