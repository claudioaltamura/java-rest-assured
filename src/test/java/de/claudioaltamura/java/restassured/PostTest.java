package de.claudioaltamura.java.restassured;

import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class PostTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void shouldResponse201WhenCreateAResource() {
    given()
        .header("Content-Type", "application/json; charset=UTF-8")
        .body(new Post("test", "This is a test", 1))
        .when()
        .request("POST", "https://jsonplaceholder.typicode.com/posts")
        .then()
        .statusCode(201);
  }
}
