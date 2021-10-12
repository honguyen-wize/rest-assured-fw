package samples.pojo;

import io.restassured.parsing.Parser;
import static org.junit.Assert.*;

import org.testng.annotations.Test;
import samples.pojo.entities.EntityAcademy;
import samples.pojo.entities.EntityWebAutomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DeserializeJson2JavaObjectTest {

    @Test
    public void pojoTest(){
        String [] expectedAutoCoursesArray = {"Selenium Webdriver Java", "Cypress", "Protractor"};
        List<String> expectedCourses =  Arrays.asList(expectedAutoCoursesArray);
        List<String> actualAutoCourses = new ArrayList<>();

        String accessToken = "ya29.a0ARrdaM8PRV0mjg3A6w_qdjVlGZC-QQMYDr3yTnC3WinjGcHdPTv1MsHkPaT5sTlN19UKxRjWQM3JCo31-ONvuBv8glDOOE9Q5UeltOJKxcYGbrI1ySEpMtkcikVF3U4gocEBAIzA985cxzVYFus_4gu46CUhJA";
        EntityAcademy academy = given().param("access_token", accessToken)
                    .expect().defaultParser(Parser.JSON) // to make sure to parse response to Json instead of the default text/html
                .when()
                    .get("https://rahulshettyacademy.com/getCourse.php")
                    .as(EntityAcademy.class); // convert json response to pojo Java class => SERIALIZATION

        System.out.println(academy.getInstructor());

        List<EntityWebAutomation> webAutoEntityList = academy.getCourses().getWebAutomation();
        for(EntityWebAutomation webAutomationEntity: webAutoEntityList){
            actualAutoCourses.add(webAutomationEntity.getCourseTitle());
            System.out.println(webAutomationEntity.getCourseTitle());
        }

        assertTrue(expectedCourses.equals(actualAutoCourses));
    }
}
