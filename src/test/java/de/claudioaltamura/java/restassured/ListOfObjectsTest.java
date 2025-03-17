package de.claudioaltamura.java.restassured;

import static io.restassured.RestAssured.get;
import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Test;

class ListOfObjectsTest {

  @Test
  void shouldResponseAllFilmsAnd200() {
    var films =
        get("http://swapi.dev/api/films/?format=json")
            .then()
            .statusCode(200)
            .extract()
            .as(new TypeRef<Films>() {});

    assertThat(films.count()).isEqualTo(6);
    assertThat(films.results())
        .extracting(Film::title)
        .contains(
            "A New Hope",
            "The Empire Strikes Back",
            "Return of the Jedi",
            "The Phantom Menace",
            "Attack of the Clones",
            "Revenge of the Sith");
  }
}
