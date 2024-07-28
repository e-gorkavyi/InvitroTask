package com.invitro.ui.steps.priceCheck;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.invitro.ui.cucumber.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.*;
import static com.invitro.ui.enums.Context.*;

public class ProductSumAddStep {
    private final ScenarioContext context = ScenarioContext.getInstance();

    @Given("Переходим на страницу каталога анализов {string}")
    public void openSite(String url) {
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @When("Добавляем анализ {string} в корзину и запоминаем его цену")
    public void addProductToBasket(String productName) {
        SelenideElement productCartPrice =
                $x("//span[text()='" + productName + "']/ancestor::div[@class='analyzes-item ']//div[@class='analyzes-item__total--sum']");
        SelenideElement productAddToBasketButton =
                $x("//span[text()='" + productName + "']/ancestor::div[@class='analyzes-item ']//a[@class='analysis']");
        context.setContext(PRODUCT_NAME, productName);
        context.setContext(PRODUCT_PRICE, Double.parseDouble(productCartPrice.getText().replaceAll("[^0-9+]", "")));
        productAddToBasketButton.click();
    }

}
