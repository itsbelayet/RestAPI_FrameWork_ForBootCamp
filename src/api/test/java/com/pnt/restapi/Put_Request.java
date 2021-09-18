package com.pnt.restapi;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Put_Request {
/*
    public static HashMap map=new HashMap();
    String empName=RestUtils.getFirstName();
    String empSalary=RestUtils.getSalary();
    String empAge=RestUtils.getAge();
    int empID=24;

    @BeforeClass
    public static void putData(){
        map.put("name",empName);
        map.put("salary",empSalary);
        map.put("age",empAge);

        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath="/update/"+empID;
    }
 */

    @Test
    public void testRequest(){
        JSONObject reqParam = new JSONObject();
        reqParam.put("name", "Mohammed");
        reqParam.put("salary", "55000");
        reqParam.put("age", "57");
        int empID=24;

        given()
            .contentType("application/json")
            .body(reqParam.toString())
        .when()
            .put("http://dummy.restapiexample.com/api/v1/update/"+empID)
        .then()
            .statusCode(200)
            .assertThat().body("data.name",equalTo("Mohammed"))
            .assertThat().body("data.salary",equalTo("55000"))
            .assertThat().body("data.age",equalTo("57"))
            .log().all();
    }
}
