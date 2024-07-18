package com.invitro.ui.steps.menuClick;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$$;

public class SideMenuStep {

    private final ElementsCollection serviceMenuList = $$("li.side-bar-second__items");

    @Given("Переходим в раздел мед. услуг {string}")
    public void openSite(String url) {
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @When("Делаем клик на всех пунктах и подпунктах бокового меню")
    public void clickToAllItems() {
        for (int i = 0; i < serviceMenuList.size(); i++) {
            serviceMenuList.get(i).click();
            ElementsCollection serviceSublist = serviceMenuList.get(i).$$("div > ul > li.side-bar-third__items");
            if (!serviceSublist.isEmpty())
                for (int j = 0; j < serviceSublist.size(); j++) {
                    serviceSublist.get(j).click();
                }
        }
    }
}
