package com.gsmserver.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class UserContactsComponent {

    @Step
    public void fillPhoneNumber(String phoneNumberValue) {
        $("[name*='phone']").parent().$("input[type='tel']").val(phoneNumberValue);
    }
}
