package GreenKartStepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@Portal")
    public void beforeValidate()
    {

        System.out.println("Execute Before portal tests");
        System.out.println("Open Chrome Browser");
    }

    @After("@Portal")
    public void afterValidate()
    {

        System.out.println("Execute After portal tests");
        System.out.println("Delete all cookies");
    }

    @Before("@WebTest")
    public void beforeWebTests()
    {
        System.out.println("Execute Before Web suite");
    }
    @After("@WebTest")
    public void afterWebTests()
    {
        System.out.println("Execute After Web suite");
    }
}
