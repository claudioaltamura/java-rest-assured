package de.claudioaltamura.java.restassured;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class JsonPathTest {

  @Test
  void shouldFindAllStarshipWithSpecificRating() {
    String response = get("https://swapi.tech/api/starships?format=json").asString();

    List<String> starshipWithSpecificRating =
        from(response).getList("results.findAll{it.uid >= '2'}.name");

    assertThat(starshipWithSpecificRating).isNotEmpty().hasSize(4);
  }
}
