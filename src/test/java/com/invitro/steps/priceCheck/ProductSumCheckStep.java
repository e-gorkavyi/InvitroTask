package com.invitro.steps;

import com.codeborne.selenide.SelenideElement;
import com.invitro.cucumber.ScenarioContext;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static com.invitro.enums.Context.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductSumCheckStep {

    private final ScenarioContext context = ScenarioContext.getInstance();
    private final SelenideElement basketButton = $("#headerCartDynamic > div > a");

    @Then("Переходим в корзину, цена товара в каталоге и в корзине должны быть равны, если цена > или < {double} - выводим в нонсоль {string} или {string}, если = - вызов ошибки")
    public void compareProductPrices(double checkSum, String higher, String lower) {
        double productPrice = (double) context.getContext(PRODUCT_PRICE);
        String productName = (String) context.getContext(PRODUCT_NAME);
        basketButton.click();
        double basketProductPrice =
                Double.parseDouble(
                        $x("//span[text()='" + productName + "']/ancestor::div[@class='CartProduct_product__euiRX']//div[@class='CartProduct_productPrice__1lW-7']//span")
                                .getText()
                                .replaceAll("[^0-9+]", "")
                );
        Assertions.assertEquals(productPrice, basketProductPrice);
        Assertions.assertTrue(basketProductPrice != checkSum);
        if (basketProductPrice > checkSum)
            System.out.println(higher);
        else
            System.out.println(lower);
    }
}
