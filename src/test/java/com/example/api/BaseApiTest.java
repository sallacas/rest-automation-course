package com.example.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseApiTest {

    protected static RequestSpecification requestSpecification;

    // BeforeAll -> Se ejecuta antes de todos los tests, para configurar la base URI y la especificación de la solicitud
    @BeforeAll
    static void configureRestAssured() {
        RestAssured.baseURI = "https://api.restful-api.dev";

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .setContentType("application/json")
                .log(LogDetail.URI)
                .build();
    }
}
