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

        private By  dropDownAccount = By.cssSelector("[space*='header/dropdown/account']"),
                    LoginPopup = By.cssSelector("[name='login']"),
                    registrationPopup = By.cssSelector("[name='registration']");

        public void openDropDownPopup() {
            $(dropDownAccount).click();
        }

        public void openLoginPopup() {
            $(LoginPopup).click();
        }

        public void openRegistrationPopup() {
            $(registrationPopup).click();
        }



    }




}
