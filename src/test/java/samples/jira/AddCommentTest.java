package samples.jira;

import static io.restassured.RestAssured.*;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import samples.common.Utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.parser.*;

public class AddCommentTest {
    @Test
    public void addCommentTest() throws ParseException {
        String jiraId = "RSA-6";
        String myComment = "This is to test new comment 2345";
        String newCommentId = "";
        String actualComment = "";
        baseURI = "http://192.168.1.99:8080";

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

        // Add Comment
        String addCommentResponse = given().pathParam("key", jiraId).log().all()
                    .header("Content-Type", "application/json")
                    .body("{\n" +
                            "    \"body\": \"" + myComment + "\",\n" +
                            "    \"visibility\": {\n" +
                            "        \"type\": \"role\",\n" +
                            "        \"value\": \"Administrators\"\n" +
                            "    }\n" +
                            "}")
                    .filter(session)
                .when().post("/rest/api/2/issue/{key}/comment")
                .then().log().all().assertThat().statusCode(201)
                .extract().response().asString();

        JsonPath jpCommentResponse = Utils.stringToJsonPath(addCommentResponse);
        newCommentId = jpCommentResponse.getString("id");

        // Check Added Comment
        // Get issue details
        System.out.println("===========ISSUE DETAILS:");
        String issueDetailsResponse = given().filter(session).pathParam("key", jiraId)
                                    .queryParam("fields", "comment").log().all()
                            .when().get("/rest/api/2/issue/{key}")
                            .then().log().all().statusCode(200)
                                .extract().response().asString();

        JsonPath jpIssueDetailsResponse = Utils.stringToJsonPath(issueDetailsResponse);


        // Way 1: Check the add comment with path

        int commentCount = jpIssueDetailsResponse.getInt("fields.comment.comments.size()");
        for(int i = 0; i < commentCount; i++){
            String commentId = jpIssueDetailsResponse.getString("fields.comment.comments[" + i + "].id");
            if(commentId.equalsIgnoreCase(newCommentId)){
                actualComment = jpIssueDetailsResponse.getString("fields.comment.comments[" + i + "].body");
                break;
            }
        }

        Assert.assertEquals(actualComment, myComment);

        // Way 2: Check the added comment with Hashmap
        ArrayList <HashMap> commentsJsonMap = jpIssueDetailsResponse.getJsonObject("fields.comment.comments");

        for (HashMap comment: commentsJsonMap){
//            HashMap author = (HashMap) comment.get("author");
//            System.out.println(author.get("emailAddress"));

            String commentId = comment.get("id").toString();
            if(commentId.equalsIgnoreCase(newCommentId)){
                actualComment = comment.get("body").toString();
                break;
            }
        }
        Assert.assertEquals(actualComment, myComment);


        // Way 3: Filter the comment by Id and compare
        // Refer the json as: jiraIssueDetails.json
        JSONParser parser = new JSONParser();
        Object object;
        object = parser.parse(issueDetailsResponse.toString());
        JSONObject jsonObject = (JSONObject) object;

        JSONObject fields = (JSONObject) jsonObject.get("fields");
        JSONObject comment = (JSONObject) fields.get("comment");
        JSONArray comments = (JSONArray) comment.get("comments"); // get the sub-json of comments

        JsonPath complexPayload = new JsonPath(comments.toString()); // paste the sub-json to JsonPath so that we can use FIND
        String commentBody = complexPayload.getString("find { it.id == '" + newCommentId + "'}.body");

        Assert.assertEquals(commentBody, myComment);

    }


}
