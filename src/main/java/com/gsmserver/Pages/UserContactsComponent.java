package com.gsmserver.Pages;

import static com.codeborne.selenide.Selenide.$;

public class UserContactsComponent {

    public void fillPhoneNumber(String phoneNumberValue) {
        $("[name*='phone']").parent().$("input[type='tel']").val(phoneNumberValue);
    }
}
