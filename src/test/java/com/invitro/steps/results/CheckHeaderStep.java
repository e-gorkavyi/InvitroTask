package com.invitro.steps.Results;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class CheckHeaderStep {

    private final SelenideElement pageHeader = $("div.UnauthResultsPage_bodyContainer__0oe6Z > h2");

    @Then("Заголовок должен быть равен {string}")
    public void checkHeader(String header) {
        Assertions.assertEquals(header, pageHeader.getText());
    }
}
