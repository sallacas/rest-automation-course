package com.example.api;

import com.example.models.ApiObjectResponse;
import com.example.models.ObjectData;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// Imports de metodos estaticos
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

class ObjectApiTest extends BaseApiTest {

    String ID = "ff8081819d82fab6019f1b31fa5e7fc2";   //  ff8081819d82fab6019efc7d1737593c
    String EXISTING_OBJECT_ID = "7";

    @Test
    @DisplayName("Consulta un objeto por id")
    void shouldGetObjectById() {
        // Separar las configuraciones
        // Extender de una clase configuradora -> Con la anotación de @BeforeAll llenamos el requestSpecification
        // Lo usamos al momento de lanzar el test
        // Se separa la ejecucion de las validaciones
        Response response =
        given()
                .spec(requestSpecification)
                .log().all()
                .pathParam("id", ID)
        .when()
                .get("/objects/{id}");

        // Primeras validaciones
        response.then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(ID))
                .body("data", notNullValue())
                .header("Content-Type", Matchers.containsString("application/json"));

        // Objeto respuesta -> Construir el objeto de la respuesta completo
        ApiObjectResponse apiObject = response.as(ApiObjectResponse.class);

        // Aserciones con Hamcrest
        assertThat(apiObject.getName(), equalTo("Google Pixel 7"));
        assertThat(apiObject.getData().getCpuModel(), equalTo("Snapdragon 8 Gen 3"));
        assertThat(apiObject.getData().getHardDiskSize(), equalTo("512 GB"));
        assertThat(apiObject.getData().getYear(), equalTo(2024));
        assertThat(apiObject.getData().getPrice(), allOf(
                notNullValue(),
                closeTo(999.98, 0.01)
        ));
    }

    @Test
    @DisplayName("Crear un objeto nuevo")
    void shouldCreateObject() {
        // Crear el objeto de prueba
        ApiObjectResponse objeto = ApiObjectResponse.builder()
                .name("Google Pixel 7")
                .data(ObjectData.builder()
                        .year(2024)
                        .price(999.99)
                        .cpuModel("Snapdragon 8 Gen 3")
                        .hardDiskSize("512 GB")
                        .build())
                .build();

        Response response =
        given()
                .spec(requestSpecification)
                .log().all()
                .body(objeto)
        .when()
                .post("/objects");

        response.then()
                .log().all()
                .statusCode(200)
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }

    // Ejericio
    // Hacer el metodo DELETE (Similar al GET por ID)
    // Hacer la asersion de que message del BODY no sea nulo

    @Test
    @DisplayName("Modificar parcialmente (PATCH) un objeto")
    void shouldPartiallyModifyObject() {
        // JSON de entrada
        ApiObjectResponse modify = ApiObjectResponse.builder()
                //name("iPhone 15 Pro Max")
                .data(ObjectData.builder()
                        .year(2027)
                        .price(999.99)
                        .cpuModel("Snapdragon 9 Gen 3")
                        .hardDiskSize("1 TB")
                        .build())
                .build();

        Response response =
                given()
                        .spec(requestSpecification)
                        .log().all()
                        .pathParam("id", ID)
                        .body(modify)
                .when()
                    .patch("/objects/{id}");

        response.then()
                .log().all()
                .statusCode(200)
                .body("updatedAt", notNullValue());

        ApiObjectResponse apiObject = response.as(ApiObjectResponse.class);
        assertThat(apiObject.getData().getYear(), equalTo(modify.getData().getYear()));
    }

    @Test
    @DisplayName("Modificar completamente (PUT) un objeto")
    void shouldCompletelyModifyObject() {
        ApiObjectResponse modify = ApiObjectResponse.builder()
                .name("Apple MacBook Pro 16")
                .data(ObjectData.builder()
                        .year(2024)
                        .price(2499.99)
                        .cpuModel("Apple M2 Max")
                        .hardDiskSize("2 TB")
                        .build())
                .build();

        Response response =
                given()
                        .spec(requestSpecification)
                        .log().all()
                        .pathParam("id", ID)
                        .body(modify)
                .when()
                    .put("/objects/{id}");

        response.then()
                .log().all()
                .statusCode(200)
                .body("updatedAt", notNullValue())
                .body("id", equalTo(ID));

    }

    @Test
    @DisplayName("Eliminar un objeto")
    void shouldDeleteObject() {
        Response response =
                given()
                        .spec(requestSpecification)
                        .log().all()
                        .pathParam("id", ID)
                .when()
                        .delete("/objects/{id}");
        response.then()
                .log().all()
                .statusCode(200)
                .body("message", notNullValue());
    }

    @Test
    @DisplayName("Retorna 404 cuando el objeto no existe")
    void shouldReturnNotFoundElementForMissingObject(){
        given()
                .spec(requestSpecification)
                .log().all()
                .pathParam("id", "123456789")
            .when()
                .get("/objects/{id}")
            .then()
                .log().all()
                .statusCode(404)
                .body("error", Matchers.containsString("Object with id=123456789"));
    }
}
