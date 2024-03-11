package apiTests;
import org.testng.Assert;
import pojo.Api;
import pojo.GetCourse;
import io.restassured.path.json.JsonPath;
import pojo.WebAutomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

public class oAuthTest {

    public static void main(String [] arg)
    {
        String response = given().formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type","client_credentials")
                .formParam("scope","trust")
                .when().log().all().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

        System.out.println(response);
        //{"access_token":"3er5IHD04fMDmvnXpHpR8w==","token_type":"Bearer","expires_in":3600,"refresh_token":"ZNTwCr1JRW2stkbaZBI+Dw==","scope":"create"}
      JsonPath jsonPath = new JsonPath(response);
      String accessToken =  jsonPath.getString("access_token");
        System.out.println(accessToken);

      //Get Course Details Call After Receving Access Toke:
        //Return me GetCourse object
        GetCourse gc= given()
                .queryParams("access_token", accessToken)
                .when().log().all()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
        System.out.println(gc.getLinkedIn());
        System.out.println(gc.getInstructor());

        //Get the course prices in nested JSON API
/*       String APICoursePrice =  "";

        List<Api> apiCourses = gc.getCourses().getApi();

        for(int i = 0; i < apiCourses.size();i++)
        {
            if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
            {
                APICoursePrice =  apiCourses.get(i).getPrice();
            }

        }
        System.out.println(APICoursePrice);*/

        //Get the course titles in nested WebAutomation and compare against an array of expected list
        String [] expectedCourseTitle = {"Selenium Webdriver Java","Cypress","Protractor"};

        //Get the object of WebAutomation
        List<WebAutomation> webAutomation = gc.getCourses().getWebAutomation();

        ArrayList<String> a = new ArrayList<>();

        for(int i = 0; i < webAutomation.size();i++)
        {
          a.add(webAutomation.get(i).getCourseTitle());

        }
        //Printing ArrayList using enchanced for loop:
        System.out.println("Course Ttiles");
        for(String courseTitles: a)
        {
            System.out.println(courseTitles);
        }


        List<String> expectedList = Arrays.asList(expectedCourseTitle);
        Assert.assertTrue(a.equals(expectedList));








    }





}
