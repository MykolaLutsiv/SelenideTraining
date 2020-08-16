package com.gsmserver.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    @Step
    public void searchFor(String searchQuery) {
        $("[name='searchword']").val(searchQuery).pressEnter();
    }

    public static class DropdownAccount {

        private final By  dropDownAccount = By.cssSelector("[space*='header/dropdown/account']"),
                    loginDropDownItem = By.cssSelector("[name='login']"),
                registrationDropDownItem = By.cssSelector("[name='registration']");

        public DropdownAccount openDropDownPopup() {
            $(dropDownAccount).click();
            return this;
        }

        public void openLoginPopup() {
            $(loginDropDownItem).click();
        }

        public void openRegistrationPopup() {
            $(registrationDropDownItem).click();
        }



    }




}
