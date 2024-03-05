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
}
