package samples.place;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import samples.payload.PlacePayload;

public class JsonPathTest {

    @Test
    public void jsonPathTest() {
        JsonPath coursesJP = new JsonPath(PlacePayload.mockPayload());

        // Print total courses
        int totalCourses = coursesJP.getInt("courses.size()");
        System.out.println("totalCourses: " + totalCourses);

        // Get Purchase Amount
        int purchaseAmount = coursesJP.getInt("dashboard.purchaseAmount");
        System.out.println("purchaseAmount: " + purchaseAmount);

        // Get 1st course name
        String firstCourseName = coursesJP.getString("courses[1].title");
        System.out.println("firstCourseName: " + firstCourseName);

        // Get all course titles and prices
        System.out.println("========== Get all course titles and prices: ");
        for(int i = 0; i < totalCourses; i++){
            String title = coursesJP.getString("courses[" + i + "].title");
            String price = coursesJP.getString("courses[" + i + "].price");

            System.out.println("title: " + title);
            System.out.println("price: " + price);
        }

        // Get copies of Cypress course
        System.out.println("========== Get copies of Cypress course: ");
        String courseName = "Cypress";
        for(int i = 0; i < totalCourses; i++){
            String title = coursesJP.getString("courses[" + i + "].title");
            String price = coursesJP.getString("courses[" + i + "].price");

            if(title.equalsIgnoreCase(courseName)){
                System.out.println("title: " + title + " - price: " + price);
                break;
            }
        }
    }

    @Test
    public void sumOfCoursesTest(){
        JsonPath coursesJP = new JsonPath(PlacePayload.mockPayload());

        int actualSum = 0;
        int totalCourses = coursesJP.getInt("courses.size()");

        for(int i = 0; i < totalCourses; i++){
            int price = coursesJP.getInt("courses[" + i + "].price");
            int copies = coursesJP.getInt("courses[" + i + "].copies");
            int amount = price * copies;
            actualSum += amount;
        }

        int purchaseAmount = coursesJP.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(actualSum, purchaseAmount);
    }
}
