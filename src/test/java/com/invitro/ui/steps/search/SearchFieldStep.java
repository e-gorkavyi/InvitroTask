package com.invitro.ui.steps.search;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;

public class SearchFieldStep {

    private final SelenideElement searchField = $("input.search__input");

    @When("Вводим в поисковое поле {string}")
    public void fillSearchField(String searchString) {
        searchField.sendKeys(searchString);
    }

    @And("Нажимаем ENTER")
    public void searchFieldPressEnter() {
        searchField.pressEnter();
    }
}
