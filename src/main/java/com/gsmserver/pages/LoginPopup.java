package com.gsmserver.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPopup {

    @Step
    public LoginPopup fillLogin(String input) {
        $("input[name='username']").val(input);
        return this;
    }

    @Step
    public LoginPopup fillPassword(String input) {
        $("input[name='password']").val(input);
        return this;
    }

    @Step
    public LoginPopup clickLogin() {
        $("[class='col-12 col-sm-6'] [name]").click();
        return this;
    }

    @Step
    public void notificationIsPresent() {
        $("[space='form/login/password'] .error-text").isDisplayed();
    }
}
