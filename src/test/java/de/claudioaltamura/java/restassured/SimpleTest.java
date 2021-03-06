package de.claudioaltamura.java.restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.jupiter.api.Test;

class SimpleTest {

  @Test
  void whenSuccessOnGetResponse200AndJsonHasRequiredKV() {
    get("http://swapi.dev/api/people/2/?format=json")
        .then()
        .statusCode(200)
        .assertThat()
        .body("name", equalTo("C-3PO"));
  }

  @Test
  void withRequestWhenSuccessOnGetResponse200() {
    when().request("GET", "http://swapi.dev/api/people/3/?format=json").then().statusCode(200);
  }

  @Test
  void whenSuccessOnGetResponse200AndCheckArray() {
    get("http://swapi.dev/api/people/3/?format=json")
        .then()
        .statusCode(200)
        .assertThat()
        .body("films", hasItems("http://swapi.dev/api/films/1/", "http://swapi.dev/api/films/2/"));
  }
}
