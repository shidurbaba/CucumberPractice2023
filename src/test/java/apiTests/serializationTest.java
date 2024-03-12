package apiTests;

import io.restassured.RestAssured;
import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class serializationTest {

    public static void main(String [] args)
    {
    //Not OAuth so we are using queryParam
        AddPlace a = AddPlace.addplaceInitialize();
        a.setAccuracy(50);
        a.setName("Frontline house");
        a.setPhone_number("(+91) 983 893 3937");
        a.setAddress( "29, side layout, cohen 09");
        a.setWebsite("http://google.com");
        a.setLanguage("French-IN");

        List<String> mylist = new ArrayList<String>();
        mylist.add("shoe park");
        mylist.add("shop");
        a.setTypes(mylist);

        Location location = Location.locationInitialize();
        location.setLatitude(-38.383455);
        location.setLongitude(33.427358);
        a.setLocation(location); //Passing knowledge of location to parent class from child location class

        double latitude =    a.getLocation().getLatitude();
        System.out.println(latitude);
        double longtit =    a.getLocation().getLongitude();
        System.out.println(longtit);

        System.out.println(a.getAccuracy());




     /*   RestAssured.baseURI = "https://rahulshettyacademy.com";
        String res =  given().queryParam("key","qaclick123")
                .body(a).when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println("Response: " + res);*/
        //Add Place - Post
    /*    RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response =  given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(a).when().post(apiPayLoads.postResponse())
                .then().assertThat().statusCode(200).extract().response().asString();

        System.out.println("Response: " + response);*/







    }



}
