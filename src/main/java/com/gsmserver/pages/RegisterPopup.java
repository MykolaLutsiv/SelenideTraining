package com.gsmserver.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPopup {

    @Step
    public RegisterPopup fillFirstName(String input) {
        $("input[name='firstName']").val(input);
        return this;
    }

    @Step
    public RegisterPopup fillEmailLogin(String input) {
        $("input[name='email']").val(input);
        return this;
    }

    @Step
    public RegisterPopup fillPassword(String input) {
        $("[space=\"form/registration/password\"] [name='password']").val(input);
        return this;
    }

    @Step
    public RegisterPopup selectCountry(String country) {
        $("div[name='countryId'] div[name='trigger']").click();
        $(by("data-title", country)).click();
        return this;
    }

    @Step
    public RegisterPopup selectPhonePrefix(String prefix) {
        $("div[name='phone'] div[name='trigger']").click();
        $(by("data-title", prefix)).click();
        return this;
    }


    @Step
    public RegisterPopup fillCellPhone(String input) {
        $("input[name='phone']").val(input);
        return this;
    }

    @Step
    public RegisterPopup acceptUserAgreement() {
        $(".option-box_icon").click();
        return this;
    }

    @Step
    public RegisterPopup clickRegister() {
        $("[space='popup\\/auth\\/sign-up'] [name='submit']").click();
        return this;
    }

    @Step
    public void errorIsPresent() {
        $(".option-box .error-text").isDisplayed();
    }

    @Step
    public void confirmRegistrationIsPresent() {
        $("h1").shouldBe(Condition.text("Confirm Registration"));
    }




}
