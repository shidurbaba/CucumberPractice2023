package apiTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import utils.GenericUtils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class apiBasics {

    public static void main(String[]args)
    {
       //validate if Add Place API is working as expected

       //given - all input details
       //when - Submit API - resource, http methods
        //Then - validate the response

        //Add Place - Post
        RestAssured.baseURI = "https://rahulshettyacademy.com";
       String response =  given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(apiPayLoads.AddPlace()).when().post(apiPayLoads.postResponse())
                .then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("server","Apache/2.4.52 (Ubuntu)")
                .extract().response().asString();

        //Add place -> Update place with New Address -> Get Place to validate if New Address is present in response.
        System.out.println("My response: "+ response);
        JsonPath js = GenericUtils.rawtoJson(response);
        String place_id = js.getString("place_id");
        System.out.println(place_id);

        //Update Place - Put
        String updateAddress = "Bovine Vile Rd, PA";

        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(apiPayLoads.UpdatePlace(place_id, updateAddress))
                .when().put(apiPayLoads.putResponse())
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

        //Get Place - Get
        String getPlaceResponse =  given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .queryParam("place_id", place_id).when().get(apiPayLoads.getResponse()).then().assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath js1 = GenericUtils.rawtoJson(getPlaceResponse);
        String actualAddress = js1.getString("address");
        System.out.println(actualAddress);
        //Asset Using TestNG
        Assert.assertEquals(actualAddress, updateAddress);


    }
}
