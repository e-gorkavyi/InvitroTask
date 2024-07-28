package com.invitro.ui.steps.menuClick;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$$x;

public class SideMenuStep {

    private final ElementsCollection serviceMenuList2 = $$x("//ul[@class='side-bar-second__list']//li");

    @Given("Переходим в раздел мед. услуг {string}")
    public void openSite(String url) {
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @When("Делаем клик на всех пунктах и подпунктах бокового меню")
    public void clickToAllItems() {
        System.out.println(serviceMenuList2.size());
        serviceMenuList2.asDynamicIterable().forEach(SelenideElement::click);
    }
}
