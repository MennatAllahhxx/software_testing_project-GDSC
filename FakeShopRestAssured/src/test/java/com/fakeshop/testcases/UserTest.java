package com.fakeshop.testcases;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * The type User test.
 */
public class UserTest {

    /**
     * Should be able to get all users.
     */
    @Test
    public void getAllUsers() {
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .get("users")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to get user by id.
     */
    @Test
    public void shouldBeAbleToGetUserByID() {
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .get("users/5")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to limit users result.
     */
    @Test
    public void limitUsersResult() {
        HashMap<String, Integer> userParam = new HashMap<>();
        userParam.put("limit", 3);

        given()
                .baseUri("https://fakestoreapi.com")
                .queryParams(userParam)
        .when()
                .get("users")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to sort users result.
     */
    @Test
    public void sortUsersResult() {
        HashMap<String, String> userParam = new HashMap<>();
        userParam.put("sort", "desc");

        given()
                .baseUri("https://fakestoreapi.com")
                .queryParams(userParam)
        .when()
                .get("users")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to add user.
     */
    @Test
    public void addUser() {
        File body = new File("src/test/resources/userData.json");

        given()
                .baseUri("https://fakestoreapi.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
        .when()
                .post("users")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to update user.
     */
    @Test
    public void updateUser() {
        File body = new File("src/test/resources/userData.json");

        given()
                .baseUri("https://fakestoreapi.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
        .when()
                .put("users/3")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void deleteUser() {
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .delete("users/6")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
