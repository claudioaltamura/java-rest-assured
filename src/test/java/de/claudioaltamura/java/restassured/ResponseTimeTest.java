package de.claudioaltamura.java.restassured;

import static io.restassured.RestAssured.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ResponseTimeTest {

  @Disabled("response time is never 1ms")
  @Test
  void shouldFailIfMeasuredResponseTimeIsNotOk() {
    var response = get("https://swapi.dev/api/people/2/?format=json");

    assertEquals(1, response.timeIn(TimeUnit.MILLISECONDS));
  }
}
