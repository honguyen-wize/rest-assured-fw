package samples.jira;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class AddAttachmentTest {
    @Test
    public void addAttachmentJiraTest(){
        String jiraId = "RSA-6";
        RestAssured.baseURI = "http://192.168.1.99:8080";

        // Get Session
        SessionFilter session = new SessionFilter();
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\t\"username\": \"honguyen1988\",\n" +
                        "\t\"password\": \"behieu123@\"\n" +
                        "}").log().all()
                .filter(session)
                .when().post("/rest/auth/1/session")
                .then().log().all().extract().response().asString();

        // Add Attachment with mutil-part method
        //curl -D- -u admin:admin -X POST -H "X-Atlassian-Token: no-check" -F "file=@myfile.txt" http://myhost/rest/api/2/issue/TEST-123/attachments
        System.out.println("=============ADD ATTACHMENT =");
        given().header("X-Atlassian-Token", "no-check")
                .filter(session) // to have user name & password
                .pathParam("key",jiraId).log().all()
                .header("Content-Type", "multipart/form-data") // required header when using multiPart
                .multiPart("file", new File("src/test/java/samples/jira/testUpload.txt"))
                .when().post("/rest/api/2/issue/{key}/attachments")
                .then().log().all().assertThat().statusCode(200);
    }

}
