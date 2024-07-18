package com.invitro.ui.hooks;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Configuration.*;

public class DriverHooks {

    @Before
    public void setUp() {
        browserCapabilities = new ChromeOptions()
                .addArguments("--accept-lang=ru-RU");
        pageLoadTimeout = 60000;
        pageLoadStrategy = "eager";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }
}
