package de.claudioaltamura.java.restassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ResponseTimeTest {

  @Disabled("response time is never 1ms")
  @Test
  void shouldFailIfMeasuredResponseTimeIsNotOk() {
    var thresholdInMs = 100L;
    given()
        .when()
        .get("https://swapi.tech/api/people/2/?format=json")
        .then()
        .log()
        .ifError()
        .assertThat()
        .time(lessThan(thresholdInMs));
  }
}
