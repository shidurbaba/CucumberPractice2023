package apiTests;

public class apiPayLoads {

    public static String AddPlace()
    {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
    }

    public static String postResponse()
    {
        return "/maps/api/place/add/json";
    }

    public static String putResponse()
    {
        return "/maps/api/place/update/json";
    }
    public static String getResponse()
    {
        return "/maps/api/place/get/json";
    }

    public static String UpdatePlace(String placeID, String address)
    {
        return "{\n" +
                "\"place_id\":\""+placeID+"\",\n" +
                "\"address\":\""+address+"\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}\n";
    }
    public static String CoursePrice()
    {

        return "{\r\n" +
                "  \"dashboard\": {\r\n" +
                "    \"purchaseAmount\": 1162,\r\n" +
                "    \"website\": \"rahulshettyacademy.com\"\r\n" +
                "  },\r\n" +
                "  \"courses\": [\r\n" +
                "    {\r\n" +
                "      \"title\": \"Selenium Python\",\r\n" +
                "      \"price\": 50,\r\n" +
                "      \"copies\": 6\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"Cypress\",\r\n" +
                "      \"price\": 40,\r\n" +
                "      \"copies\": 4\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"RPA\",\r\n" +
                "      \"price\": 45,\r\n" +
                "      \"copies\": 10\r\n" +
                "    },\r\n" +
                "     {\r\n" +
                "      \"title\": \"Appium\",\r\n" +
                "      \"price\": 36,\r\n" +
                "      \"copies\": 7\r\n" +
                "    }\r\n" +
                "    \r\n" +
                "    \r\n" +
                "    \r\n" +
                "  ]\r\n" +
                "}\r\n" +
                "";
    }

    public static String baseURI()
    {
        return "http://216.10.245.166";
    }

    public static String AddBook(String isbn, String aisle)
    {
        return "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}";
    };
    public static String postAddBook(){ return "Library/Addbook.php ";};

    public static String getBookFromLibrary(String argument, String argument2) {
        String getBookVariable="";
        if (argument.equalsIgnoreCase("author")) {
            getBookVariable = "/Library/GetBook.php?AuthorName=" + argument2 + "";
        } else if (argument.equalsIgnoreCase("ID")) {
            getBookVariable=  "/Library/GetBook.php?ID=" + argument2 + "";
        }
        return getBookVariable;
    }
}
