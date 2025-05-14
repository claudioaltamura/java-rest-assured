package de.claudioaltamura.java.restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.jupiter.api.Test;

class SimpleTest {

  @Test
  void shouldResponse200AndJsonHasRequiredKV() {
    given()
        .when()
        .get("https://swapi.tech/api/people/2/?format=json")
        .then()
        .log()
        .ifError()
        .assertThat()
        .statusCode(200)
        .and()
        .body("result.properties.name", equalTo("C-3PO"));
  }

  @Test
  void shouldResponse200() {
    given()
        .when()
        .request("GET", "https://swapi.tech/api/people/3/?format=json")
        .then()
        .assertThat()
        .statusCode(200);
  }
}
