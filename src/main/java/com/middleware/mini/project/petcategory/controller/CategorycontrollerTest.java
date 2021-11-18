package com.middleware.mini.project.petcategory.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class CategorycontrollerTest {

    @org.junit.jupiter.api.Test
    void myATest() {
        given().contentType(
                        MediaType.APPLICATION_JSON)
                .body(
                        Json.createObjectBuilder().
                                add("name","Bird").
                                add("dynasty","Mamelia").
                                add("region","Asian").
                                add("scientificName","Birdano Birdiano").
                                build().
                                toString()
                ).
                when().
                post("data/pet-category/add-category").
                then().
                statusCode(200);
    }

    @org.junit.jupiter.api.Test
    void myBTest() {
        given().when().get("data/pet-category/1").then()
                .statusCode(200)
                .body("name", equalTo("Bird"))
                .body("dynasty", equalTo("Mamelia"))
                .body("region",  equalTo("Asian"))
                .body("scientificName",  equalTo("Birdano Birdiano"));
    }

    @org.junit.jupiter.api.Test
    void myCTest() {
        given().when().get("data/pet-category").then().statusCode(200);
    }

    @org.junit.jupiter.api.Test
    void myDTest() {
        given().contentType(
                        MediaType.APPLICATION_JSON)
                .body(
                        Json.createObjectBuilder().
                                add("name","Iguana").
                                add("dynasty","Reptile").
                                add("region","East").
                                add("scientificName","Reptileo Reptile").
                                build().
                                toString()
                ).
                when().
                put("data/pet-category/1").
                then().
                statusCode(200);
    }

    @org.junit.jupiter.api.Test
    void myETest() {
        given().when().delete("data/pet-category/1").then().statusCode(200);
    }
}