package de.claudioaltamura.java.restassured;

import java.util.List;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.from;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class JsonPathTest {

  @Test
  void findAll() {
    String response = get("http://restcountries.eu/rest/v1/").asString();

    List<String> largeCountries = from(response).getList("findAll { it.population > 100000000 }.name");

    assertThat(largeCountries).isNotEmpty().hasSize(12);
  }

  @Test
  void sumUpNamesLengthWithJsonPath() {
    String response = get("http://restcountries.eu/rest/v1/").asString();

    int sumNames = from(response).getInt("name*.length().sum()");

    assertThat(sumNames).isEqualTo(12);
  }

}
