package apiTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.GenericUtils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DynamicJson {



    @Test
    public void addBook()
    {
        RestAssured .baseURI=apiPayLoads.baseURI();
        Response response = given().header("Content-Type","application/json").body(apiPayLoads.AddBook("abed","289")).when().post(apiPayLoads.postAddBook()).then().assertThat().statusCode(200)
                .extract().response();
        JsonPath js = GenericUtils.rawtoJson(response);
        String id = js.get("ID");
        System.out.println("Response ID : "+id);
    }
}
