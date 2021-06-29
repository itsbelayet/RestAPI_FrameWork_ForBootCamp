package com.pnt.restapi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFiles {

    public static JSONArray getJsonArray(String filePath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(filePath));

        return jsonArray;
    }

    @Test(priority = 1)
    public void readSingleJson() throws IOException, ParseException {
        JSONArray jsa = getJsonArray("src/api/test/java/com/pnt/restapi/SingleArray_SingleJson.json");
        System.out.println(jsa);

        JSONObject jsonData = (JSONObject) jsa.get(0);

        System.out.println(jsonData);
        System.out.println(jsonData.get("id"));
        System.out.println(jsonData.get("timestamp"));
        System.out.println(jsonData.get("feature"));
    }

    @Test(priority = 2)
    public void readDoubleJson() throws IOException, ParseException {
        JSONArray jsa2 = getJsonArray("src/api/test/java/com/pnt/restapi/SingleArray_DoubleJson.json");
        JSONObject jsondata2 = (JSONObject) jsa2.get(0);

        System.out.println(jsondata2.get("id"));
    }

    @Test(priority = 3)
    public void readMultipleJson() throws IOException, ParseException {
        JSONArray jsa3 = getJsonArray("src/api/test/java/com/pnt/restapi/SingleArray_ArrayInMultipleJson.json");
        JSONObject jsondata3 = (JSONObject) jsa3.get(1);

        System.out.println(jsondata3);
        System.out.println(jsondata3.get("data"));

        JSONArray jsonArrayOfData = (JSONArray) jsondata3.get("data");

        System.out.println(jsonArrayOfData.get(0));

        JSONObject jsonObjectRohan = (JSONObject) jsonArrayOfData.get(0);

        System.out.println(jsonObjectRohan);
        System.out.println(jsonObjectRohan.get("id"));
    }
}
