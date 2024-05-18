package com.fakeshop.testcases;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * The type Product test.
 */
public class ProductTest {

    /**
     * Should be able to get all products.
     */
    @Test
    public void getAllProducts() {
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .get("products")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to get product by id.
     */
    @Test
    public void getProductByID() {
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .get("products/5")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to limit products result.
     */
    @Test
    public void limitProductsResult() {
        HashMap<String, Integer> cartParam = new HashMap<>();
        cartParam.put("limit", 3);

        given()
                .baseUri("https://fakestoreapi.com")
                .queryParams(cartParam)
        .when()
                .get("products")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to sort products result.
     */
    @Test
    public void sortProductsResult() {
        HashMap<String, String> cartParam = new HashMap<>();
        cartParam.put("sort", "desc");

        given()
                .baseUri("https://fakestoreapi.com")
                .queryParams(cartParam)
        .when()
                .get("products")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to get categories.
     */
    @Test
    public void getCategories() {
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .get("products/categories")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to get product in category.
     */
    @Test
    public void getProductInCategory() {
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .get("products/category/jewelery")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to add product.
     */
    @Test
    public void addProduct() {
        File body = new File("src/test/resources/productData.json");

        given()
                .baseUri("https://fakestoreapi.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
        .when()
                .post("products")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to update product.
     */
    @Test
    public void updateProduct() {
        File body = new File("src/test/resources/productData.json");

        given()
                .baseUri("https://fakestoreapi.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
        .when()
                .put("products/3")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Should be able to delete product.
     */
    @Test
    public void deleteProduct() {
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .delete("products/6")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
