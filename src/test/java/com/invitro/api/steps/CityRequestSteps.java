package com.invitro.api.steps;

import com.invitro.api.specs.Specifications;
import io.cucumber.java.en.Given;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.nullValue;

public class CityRequestSteps {

    @Given("Эндпоинт {string}, параметр {string} со значениями {string}, ключи {string} {string} {string} равны null")
    public void checkCityReq(String url, String param, String value, String key1, String key2, String key3) {
        Specifications.installSpecification(Specifications.responseSpecOK200());
        String out = given()
                .queryParam(param, value)
                .when()
                .get(url)
                .then()
                .body(key1, nullValue())
                .body(key2, nullValue())
                .body(key3, nullValue())
                .extract().body().asPrettyString();
        System.out.println(out);
    }
}
