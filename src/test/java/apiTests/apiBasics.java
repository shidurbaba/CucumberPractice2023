package apiTests;

import io.restassured.RestAssured;

public class apiBasics {

    public static void main(String[]args)
    {
       //validate if Add Place API is working as expected

       //given - all input details
       //when - Submit API
        //Then - validate the response

        RestAssured.baseURI = "https://rahulshettyacademy.com";


    }
}
