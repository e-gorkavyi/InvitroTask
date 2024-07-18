package com.invitro.ui.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;

public class MainPageOpenStep {
    @Given("Находимся на главной странице {string}")
    public void openSite(String url) {
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}
