package com.gsmserver.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPopup {

    public LoginPopup fillLogin(String input) {
        $("input[name='username']").val(input);
        return this;
    }

    public LoginPopup fillPassword(String input) {
        $("input[name='password']").val(input);
        return this;
    }

    public LoginPopup clickLogin() {
        $("[class='col-12 col-sm-6'] [name]").click();
        return this;
    }

    public void notificationIsPresent() {
        $(".notification").isDisplayed();
    }
}
