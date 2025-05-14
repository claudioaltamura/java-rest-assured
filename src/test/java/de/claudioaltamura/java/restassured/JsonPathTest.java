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

  /*
  @Test
  void shouldResponseAllFilmsAnd200() {
    var films =
        given()
            .when()
            .get("http://swapi.tech/api/films/?format=json")
            .then()
            .assertThat()
            .statusCode(200)
            .and()
            .extract()
            .jsonPath();

    assertThat(films.getList("result.properties.title"))
        .contains(
            "A New Hope",
            "The Empire Strikes Back",
            "Return of the Jedi",
            "The Phantom Menace",
            "Attack of the Clones",
            "Revenge of the Sith");
  }
   */

  /*
   * @Test void sumUpNamesLengthWithJsonPath() { String response =
   * get("http://restcountries.eu/rest/v1/").asString();
   *
   * <p>int sumNames = from(response).getInt("name*.length().sum()");
   *
   * <p>assertThat(sumNames).isEqualTo(2490); }
   */
}
