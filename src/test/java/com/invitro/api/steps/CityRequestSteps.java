package com.invitro.api.steps;

import com.invitro.api.specs.Specifications;
import io.cucumber.java.en.Given;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.nullValue;

public class CityRequestSteps {

    @Given("Эндпоинт {string}, параметр {string} со значениями {string}")
    public void checkCityReq(String url, String param, String value) {
        Specifications.installSpecification(Specifications.responseSpecOK200());
        given()
                .queryParam(param, value)
                .when()
                .get(url)
                .then().log().all()
                .body("city", nullValue())
                .body("code", nullValue())
                .body("guid", nullValue())
                .extract().response();
    }
}
