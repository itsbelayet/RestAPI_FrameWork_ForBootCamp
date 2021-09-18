package com.pnt.restapi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Test_Requests {

    @Test(priority=1)
    public void testGetAPI(){
        given()
        .when()
            .get("https://reqres.in/api/users/2")
        .then()
            .statusCode(200)
            .statusLine("HTTP/1.1 200 OK")
            .assertThat().body("data.first_name", equalTo("Janet"))
            .header("Content-Type","application/json; charset=utf-8")
            .log().all();

    }


}
