package com.invitro.ui.steps.results;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;

public class EmptyFindStep {

    private final SelenideElement findResultButton = $("div.UnauthResultsPage_bodyContainer__0oe6Z > div > button");

    @When("Не заполняя поля, нажимаем 'найти результаты'")
    public void find() {
        findResultButton.click();
    }
}
