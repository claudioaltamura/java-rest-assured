package de.claudioaltamura.java.restassured;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.lessThan;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ResponseTimeTest {

  @Disabled("response time is never 1ms")
  @Test
  void shouldFailIfMeasuredResponseTimeIsNotOk() {
    var thresholdInMs = 100L;
    get("https://swapi.dev/api/people/2/?format=json").then().time(lessThan(thresholdInMs));
  }
}
