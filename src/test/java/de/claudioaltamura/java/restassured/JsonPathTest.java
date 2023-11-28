package de.claudioaltamura.java.restassured;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class JsonPathTest {

  @Test
  void shouldFindAllStarshipWithSpecificRating() {
    String response = get("https://swapi.dev/api/starships?format=json").asString();

    List<String> starshipWithSpecificRating =
        from(response).getList("results.findAll{it.hyperdrive_rating == '1.0'}.name");

    assertThat(starshipWithSpecificRating).isNotEmpty().hasSize(4);
  }

  /**
   * @Test void sumUpNamesLengthWithJsonPath() { String response =
   * get("http://restcountries.eu/rest/v1/").asString();
   *
   * <p>int sumNames = from(response).getInt("name*.length().sum()");
   *
   * <p>assertThat(sumNames).isEqualTo(2490); }
   */
}
