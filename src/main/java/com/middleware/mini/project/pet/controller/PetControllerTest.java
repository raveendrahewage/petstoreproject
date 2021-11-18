package com.middleware.mini.project.pet.controller;

import javax.json.Json;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class PetControllerTest {

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
        given().contentType(
                MediaType.APPLICATION_JSON)
                .body(
                        Json.createObjectBuilder().
                                add("typeId",1).
                                add("petName","tyna").
                                add("birthday","2011-11-23").
                                add("gender","Male").
                                add("owner","Suneetha").
                                add("weight",20.34).
                                build().
                                toString()
                ).
                when().
                post("data/pet/add-pet").
                then().
                statusCode(200);

    }

    @org.junit.jupiter.api.Test
    void myCTest() {
        given().when().get("data/pet/2")
                .then()
                .statusCode(200)
                .body("petId",equalTo(2))
                .body("typeId",equalTo(1))
                .body("petName",equalTo("tyna"))
                .body("birthday",equalTo("2011-11-23"))
                .body("gender",equalTo("Male"))
                .body("owner",equalTo("Suneetha"));
    }

    @org.junit.jupiter.api.Test
    void myDTest() {
        given().when().get("data/pet").then().statusCode(200);
    }

    @org.junit.jupiter.api.Test
    void myETest() {
        given().contentType(
                        MediaType.APPLICATION_JSON)
                .body(
                        Json.createObjectBuilder().
                                add("petName","Pinky").
                                add("birthday","2012-10-23").
                                add("gender","Female").
                                add("owner","Kamal").
                                add("weight",18.50).
                                build().
                                toString()
                ).
                when().
                put("data/pet/2").
                then().
                statusCode(200);
    }

    @org.junit.jupiter.api.Test
    void myFTest() {
        given().when().get("data/pet/search-all?content=Pin").then().statusCode(200);
        given().when().get("data/pet/search-all?content=Male").then().statusCode(400);
    }

    @org.junit.jupiter.api.Test
    void myGTest() {
        given().when().delete("data/pet/2").then().statusCode(200);
    }
}