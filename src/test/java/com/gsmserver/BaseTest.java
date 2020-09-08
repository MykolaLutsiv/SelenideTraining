package com.gsmserver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public abstract class BaseTest {

    static {
        Configuration.baseUrl = "https://gsmserver.com";
        Configuration.browser = WebDriverRunner.CHROME;
//        Configuration.pageLoadStrategy = "none";
        Configuration.savePageSource = false;
        Configuration.screenshots = false;


        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false));

    }
}
