package com.invitro.steps.Results;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;

public class GetResultsStep {

    private final SelenideElement getResultButton = $("div.invitro_header-bottom_right > a.invitro_header-get_result");

    @When("Нажимаем на 'результаты анализов'")
    public void clickGetResults() {
        getResultButton.click();
    }
}
