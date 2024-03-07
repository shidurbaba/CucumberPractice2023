package apiTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.GenericUtils;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DynamicJson {



/*
    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle)
    {
        RestAssured .baseURI=apiPayLoads.baseURI();
        String response = given().header("Content-Type","application/json").body(apiPayLoads.AddBook(isbn,aisle)).when().post(apiPayLoads.postAddBook()).then().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = GenericUtils.rawtoJson(response);
        String id = js.get("ID");
        System.out.println("Response ID : "+id);
    }

    @DataProvider(name="BooksData")
    public Object[][] getData()
        {
         return new Object[][] {{"xy2z","1234"},{"ab1c","2889"},{"zz4z","3759"}};
        }
*/

    @Test
    public void addPlace() throws IOException {
        RestAssured .baseURI=apiPayLoads.baseURI();
        String response = given().header("Content-Type","application/json").body(apiPayLoads.getAddPlace()).when().post(apiPayLoads.postResponse()).then().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = GenericUtils.rawtoJson(response);
        String place_id = js.getString("place_id");
        System.out.println(place_id);
    }










}
