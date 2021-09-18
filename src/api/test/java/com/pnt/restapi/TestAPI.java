package com.pnt.restapi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestAPI {
    @Test
    public void testStatusCode(){
        given()
                .when()
                    .get("https://reqres.in/api/users?page=2")
                    //.get("http://jsonplaceholder.typicode.com/posts/5")
                .then()
                    .statusCode(200)
                    .log().all();

    }
    @Test
    public void testSingleContent(){
        given()
                .when()
                    .get("https://reqres.in/api/users?page=2")
                    //.get("http://services.groupkt.com/country/get/iso2code/IN")
                .then()
                    .statusCode(200);
                    //.body(".data[0].first_name",equals("India"));
    }

}
