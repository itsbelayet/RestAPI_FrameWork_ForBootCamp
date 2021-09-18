package com.pnt.restapi;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Post_Request1 {
    public static HashMap map=new HashMap();

    @BeforeClass
    public static void postData(){
        map.put("name",RestUtils.getFirstName());
        map.put("job",RestUtils.getJob());

        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="/api/users";
    }
    @Test
    public void testPost(){
        given()
            .contentType("application/json")
            .body(map)
        .when()
            .post()
        .then()
            .statusCode(200);
//            .and()
//            .body("name",equalTo(RestUtils.getFirstName()))
//            .and()
//            .body("job",equalTo(RestUtils.getJob()));
    }

}
