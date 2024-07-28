package com.invitro.ui.steps.sections;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.invitro.ui.enums.SiteSections;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChooseSectionStep {

    private final SelenideElement chooseButton = $("div.invitro_header-bottom div.invitro_header-target_audience");
    private final ElementsCollection selectors = $$("div.mfp-content > div.popup-block > a");
    private final SelenideElement popupCloseButton = $("div.mfp-content > div.popup-block > button");

    @When("Кликаем кнопку выбора разделов")
    public void clickSectionChooseButton() {
        chooseButton.click();
    }

    @And("^Кликаем \"(Пациентам|Врачам|Франчайзинг|Корпоративным клиентам|Прессе)\"$")
    public void clickSectionByName(String sectionName) {
        String sectionUrl = SiteSections.getSectionUrl(sectionName);
        Assertions.assertNotNull(sectionUrl, "Наименование пункта не может быть произвольным");

        SelenideElement selector = selectors.find(href(sectionUrl));
        if (!selector.has(cssClass("active")))
            selector.click();
        else
            popupCloseButton.click();
    }
}
