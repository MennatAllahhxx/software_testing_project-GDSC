package com.fakeshop.testcases;

import com.fakeshop.pojo.LoginPojo;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * The type Login test.
 */
public class LoginTest {

    /**
     * Should be able to login.
     */
    @Test
    public void login() {
        LoginPojo body = new LoginPojo("mor_2314", "83r5^_");

        given()
                .baseUri("https://fakestoreapi.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
        .when()
                .post("auth/login")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
