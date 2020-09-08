package com.gsmserver.product;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    @Step
    public SelenideElement getTitle() {
        return $("h1");
    }


}
