package samples.library;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
import samples.common.Utils;
import samples.payload.Payload;

public class DynamicPayloadTest {

//    @Test(dataProvider = "BooksData")
    public void addBookTest(String isbnProvider, String aisleProvider){
        RestAssured.baseURI = "http://216.10.245.166";

        // Add new book
        String response =
                given().log().all().header("Content-Type", "application/json")
                    .body(Payload.getBookPayLoad(isbnProvider, aisleProvider))
                .when().post("Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                    .extract().response().asString();

        JsonPath jsonPath = Utils.stringToJsonPath(response);
        String bookId = jsonPath.getString("ID");
        System.out.println("bookId: " + bookId);

        // Delete the added book
        given().log().all().header("Content-Type", "application/json")
                .body("{\"ID\" : \"" + bookId + "\"} ")
                .when().post("Library/DeleteBook.php")
                .then().log().all().assertThat().statusCode(200)
                    .body("msg", equalTo("book is successfully deleted"));

    }

//    @DataProvider (name = "BooksData")
    public Object[][] getBookData(){
        return new Object[][]
                {
                        {"bcbcbc", "01091988"},
                        {"bdbdbd", "01091988"}
                };
    }

}
