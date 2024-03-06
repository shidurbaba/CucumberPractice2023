package apiTests;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ComplexJsonParse {
    //Dynamic
    public static void main(String[] args)
    {
        JsonPath js1 = new JsonPath(apiPayLoads.CoursePrice());

        //Print No of courses returned by API

      int count =  js1.getInt("courses.size()");
        System.out.println(count);

      //Print Purchase Amount
      int total_purchaseAmount = js1.getInt("dashboard.purchaseAmount");
        System.out.println(total_purchaseAmount);

      //Print Title of the first course
      String titleFirstCourse = js1.get("courses[2].title");
        System.out.println(titleFirstCourse);

      //Print All Courses and respective prices
      for(int i = 0; i<count; i++)
      {
        String courseTitle = js1.get("courses["+i+"].title");
          System.out.println(courseTitle);

        int coursePrices = js1.getInt("courses["+i+"].price");
          System.out.println(coursePrices);

          System.out.println(js1.get("courses["+i+"].copies").toString());
      }

      //Print number of copies sold by RPA course
        System.out.println("Print number of copies solf by RPA course: ");
        for(int i = 0; i<count; i++)
        {
            String courseTitle = js1.get("courses["+i+"].title");
            if(courseTitle.equalsIgnoreCase("RPA"))
            {
                //return copies sold
                int copies = js1.get("courses["+i+"].copies");
                System.out.println(copies);
                break;
            }
        }

        //Verify if Sum of all Course prices matches with Purchase Amount
        //Declare an empty variable
        int sum = 0;
        for(int i = 0; i<count; i++)
        {
            //Declare an empty variable

            //Storing of course price in a variable coursePrice
            int coursePrice = js1.get("courses["+i+"].price");
            int courseCopies = js1.get("courses["+i+"].copies");
            int totalPrice = coursePrice*courseCopies;

            //Add sum plus totalPrice
            sum = sum + totalPrice;
        }
        System.out.println("Total Sum : " + sum);

        int purchaseAmount = js1.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum,purchaseAmount);
    }
}
