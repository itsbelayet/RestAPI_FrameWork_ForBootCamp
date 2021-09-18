package com.pnt.restapi;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get_Request {
    @Test()
    public void getData(){
        given()
        .when()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .statusLine("HTTP/1.1 200 OK")
            .assertThat().body("data[0].first_name",equalTo("Michael"))
            .header("Content-Type","application/json; charset=utf-8")
            .log().all();

    }
    @Test
    public void getPostData(){
        given()
        .when()
            .get("https://reqres.in/api/users")
        .then()
            .statusCode(200)
            .statusLine("HTTP/1.1 200 OK")
            .header("Content-Type","application/json; charset=utf-8")
            .log().all();

    }

}
