package stepDefinitions;

import io.cucumber.java.Before;

public class Hooks {

    @Before("@Portal")
    public void beforeValidate()
    {
        System.out.println("Execute before portal tests");
    }



}
