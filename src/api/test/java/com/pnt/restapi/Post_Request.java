package com.pnt.restapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Post_Request {

    public static HashMap map=new HashMap();
    @BeforeClass
    public static void postData(){
        map.put("name",RestUtils.getFirstName());
        map.put("job",RestUtils.getJob());

//        RestAssured.baseURI="https://reqres.in/";
//        RestAssured.basePath="/api/users";
    }

    @Test
    public void postSingleData() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject reqParam = new JSONObject();
        reqParam.put("name", "Mohammed");
        reqParam.put("job", "QA");

        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(reqParam.toString());

        Response response = httpRequest.request(Method.POST, "/api/users");

        String resBody = response.getBody().asString();
        Assert.assertEquals(resBody.contains("Mohammed"), true);
        Assert.assertEquals(resBody.contains("QA"), true);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

    @Test
    public void postMultiData(){

        JSONObject reqParam = new JSONObject();
        reqParam.put("name", "Mohammed");
        reqParam.put("job", "QA");
        given()
                .contentType("application/json")
                .body(reqParam.toString())
        .when()
                .post("https://reqres.in/api/users")
        .then()
                .statusCode(201);
//            .and()
//            .body("name",equalTo(RestUtils.getFirstName()))
//            .and()
//            .body("job",equalTo(RestUtils.getJob()));
    }
}
