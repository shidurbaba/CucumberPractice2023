package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@Portal")
    public void beforeValidate()
    {

        System.out.println("Execute before portal tests");
        System.out.println("Open Chrome Browser");
    }

    @After("@Portal")
    public void afterValidate()
    {

        System.out.println("Execute after portal tests");
        System.out.println("Delete all cookies");
    }

}
