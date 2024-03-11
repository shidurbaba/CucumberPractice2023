package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class serializationTest {

    public static void main(String [] args)
    {
    //Not OAuth so we are using queryParam
        AddPlace a = new AddPlace();
        a.setAccuracy(50);
        a.setName("Frontline house");
        a.setPhone_number("(+91) 983 893 3937");
        a.setAddress( "29, side layout, cohen 09");
        a.setWebsite("http://google.com");
        a.setLanguage("French-IN");

        Location location = new Location();
        location.setLatitude(-38.383494);
        location.setLongitude(33.427362);
        a.setLocation(location); //Passing knowledge of location to parent class from child location class

        List<String> mylist = new ArrayList<String>();
        mylist.add("shoe park");
        mylist.add("shop");
        a.setTypes(mylist);


     /*   RestAssured.baseURI = "https://rahulshettyacademy.com";
        String res =  given().queryParam("key","qaclick123")
                .body(a).when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println("Response: " + res);*/
        //Add Place - Post
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response =  given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(a).when().post(apiPayLoads.postResponse())
                .then().assertThat().statusCode(200).extract().response().asString();

        System.out.println("Response: " + response);







    }



}
