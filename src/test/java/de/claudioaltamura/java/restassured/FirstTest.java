package de.claudioaltamura.java.restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.jupiter.api.Test;

class FirstTest {

  @Test
  void getC3PO() {

    get("http://swapi.co/api/people/2/?format=json")
        .then()
        .assertThat()
        .body("name", equalTo("C-3PO"));
  }
}
