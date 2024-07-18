package com.invitro.ui.steps.cityChange;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.invitro.ui.cucumber.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.invitro.ui.enums.Context.CITY_NAME;

public class SityChangeStep {

    private final SelenideElement cityButton = $("span.city__name.city__btn");
    private final SelenideElement chooseAnotherCity = $("a.btn--empty.city__change-btn");
    private final SelenideElement changeCitySearch = $("input.change-city-search-input");
    private final ElementsCollection autoFoundCityName = $$(".easy-autocomplete-container .eac-item");
    private final ScenarioContext context = ScenarioContext.getInstance();

    @When("Нажимаем на элемент выбора города, нажимаем 'выбрать другой', в поле поиска вводим {string}")
    public void findCity(String cityName) {
        cityButton.click();
        chooseAnotherCity.click();
        changeCitySearch.sendKeys(cityName);
        context.setContext(CITY_NAME, cityName);
    }

    @And("Проверяем что в списке есть нужный город и кликаем на него")
    public void checkCityList() {
        autoFoundCityName
                .filterBy(exactText((String) context.getContext(CITY_NAME)))
                .forEach(x -> x.shouldBe(visible).click());
    }

    @Then("Проверяем что в элементе выбора города отобразился выбранный")
    public void checkCityLabel() {
        Assertions.assertEquals(context.getContext(CITY_NAME), cityButton.shouldBe(visible).getText());
    }
}
