package com.fakeshop.testcases;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * The type Cart test.
 */
public class CartTest {

    /**
     * Should be able to get all carts.
     */
    @Test(priority = 0)
    public void getAllCarts() {
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .get("carts")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to get cart by id.
     */
    @Test
    public void getCartByID() {
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .get("carts/5")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to limit carts result.
     */
    @Test
    public void limitCartsResult() {
        HashMap<String, Integer> cartParam = new HashMap<>();
        cartParam.put("limit", 3);

        given()
                .baseUri("https://fakestoreapi.com")
                .queryParams(cartParam)
        .when()
                .get("carts")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to sort carts result.
     */
    @Test
    public void sortCartsResult() {
        HashMap<String, String> cartParam = new HashMap<>();
        cartParam.put("sort", "desc");

        given()
                .baseUri("https://fakestoreapi.com")
                .queryParams(cartParam)
        .when()
                .get("carts")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to get carts in date range.
     */
    @Test
    public void getCartsInDateRange() {
        HashMap<String, String> cartParams = new HashMap<>();
        cartParams.put("startdate", "2019-12-10");
        cartParams.put("enddate", "2020-01-10");

        given()
                .baseUri("https://fakestoreapi.com")
                .queryParams(cartParams)
        .when()
                .get("carts")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to get user cart.
     */
    @Test
    public void getUserCart() {
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .get("carts/user/8")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to add product to cart.
     */
    @Test
    public void addProductToCart() {
        File body = new File("src/test/resources/cartData.json");

        given()
                .baseUri("https://fakestoreapi.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
        .when()
                .post("carts")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to update cart product.
     */
    @Test
    public void updateCartProduct() {
        File body = new File("src/test/resources/cartData.json");

        given()
                .baseUri("https://fakestoreapi.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
        .when()
                .put("carts/3")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to delete cart.
     */
    @Test
    public void deleteCart() {
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .delete("carts/6")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
