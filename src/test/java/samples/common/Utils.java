package samples.common;

import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
    public static JsonPath stringToJsonPath(String response){

        return new JsonPath(response);
    }

    public static String generateStringFromJsonFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
