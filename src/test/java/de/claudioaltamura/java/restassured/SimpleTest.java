package de.claudioaltamura.java.restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.jupiter.api.Test;

class SimpleTest {

  @Test
  void shouldResponse200AndJsonHasRequiredKV() {
    get("https://swapi.dev/api/people/2/?format=json")
        .then()
        .statusCode(200)
        .assertThat()
        .body("name", equalTo("C-3PO"));
  }

  @Test
  void shouldResponse200() {
    when().request("GET", "https://swapi.dev/api/people/3/?format=json").then().statusCode(200);
  }

  @Test
  void shouldResponse200AndCheckArray() {
    get("http://swapi.dev/api/people/3/?format=json")
        .then()
        .statusCode(200)
        .assertThat()
        .body(
            "films", hasItems("https://swapi.dev/api/films/1/", "https://swapi.dev/api/films/2/"));
  }
}
