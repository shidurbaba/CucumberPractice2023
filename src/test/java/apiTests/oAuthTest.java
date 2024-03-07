package apiTests;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import utils.GenericUtils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

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
      String accessToken =  jsonPath.get("access_token");

      //Get Course Details Call After Receving Access Toke:
      String response2 =    given().formParam("access_token",accessToken).log().all().when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
        System.out.println(response2);







    }





}
