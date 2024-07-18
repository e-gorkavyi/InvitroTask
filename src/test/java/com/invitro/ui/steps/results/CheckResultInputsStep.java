package com.invitro.ui.steps.results;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.*;

public class CheckResultInputsStep {

    private static final String ERROR_INPUT_CLASS = "Input_error__TVQ0l";
    private final SelenideElement pageErrorHeader = $("div.UnauthResultsPage_error__m2C-2");
    private final SelenideElement orderNumberInput = $$("input.Input_input__C7FoV").find(Condition.name("orderNumber"));
    private final SelenideElement birthdayInput = $$("input.Input_input__C7FoV").find(Condition.name("birthday"));
    private final SelenideElement lastNameInput = $$("input.Input_input__C7FoV").find(Condition.name("lastName"));

    @Then("Все поля должны стать красными, появилось предупреждение {string}")
    public void checkAttention(String errorHeader) {
        Assertions.assertEquals(errorHeader, pageErrorHeader.getText());
        Assertions.assertTrue(orderNumberInput.has(cssClass(ERROR_INPUT_CLASS)));
        Assertions.assertTrue(birthdayInput.has(cssClass(ERROR_INPUT_CLASS)));
        Assertions.assertTrue(lastNameInput.has(cssClass(ERROR_INPUT_CLASS)));
    }

    @When("Заполнить поля: код {string}, дата рождения {string}, фамилия {string}")
    public void fillTheGaps(String code, String birthday, String lastName) {
        orderNumberInput.sendKeys(code);
        birthdayInput.click();
        birthdayInput.sendKeys(birthday);
        lastNameInput.sendKeys(lastName);
    }

    @Then("Проверить что в полях указано: код {string}, дата рождения {string}, фамилия {string}")
    public void checkInputs(String code, String birthday, String lastName) {
        orderNumberInput.shouldHave(value(code));
        birthdayInput.shouldHave(value(birthday));
        lastNameInput.shouldHave(value(lastName));
    }
}
