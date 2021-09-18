package com.pnt.restapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
@Test
public class Delete_Request {
    public void deleteData(){
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath="/delete/23";

        Response response=
                given()
                .when()
                    .delete()
                .then()
                    .statusCode(200)
                    .log().all()
                    .extract().response();
                String jAsString= response.asString();
        //Assert.assertEquals(jAsString.contains("Successfully! Record has been deleted"));
    }
}
