package com.gsmserver.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.gsmserver.product.ProductComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class HomePage {

    public SearchComponent searchComponent = new SearchComponent();

    public ProductComponent targetProduct(String productId) {
        return new ProductComponent(productId);
    }



    public static class DropdownAccount {

        private final By  dropDownAccount = By.cssSelector("[space*='header/dropdown/account']"),
                    loginDropDownItem = By.cssSelector("[name='login']"),
                registrationDropDownItem = By.cssSelector("[name='registration']"),
                logoutDropDownItem = By.cssSelector(".icon-logout"),
                titleAboveMyAccount = By.cssSelector(".s-g_title-pretext");

        @Step
        public DropdownAccount verifyTitleAboveMyAccount(String text) {
            $(dropDownAccount).$(titleAboveMyAccount).shouldBe(Condition.text(text));
            return this;
        }

        @Step
        public DropdownAccount logout() {
            $(logoutDropDownItem).click();
            return this;
        }

        @Step
        public DropdownAccount openDropDownPopup() {
            sleep(300);
            $(dropDownAccount).click();
            return this;
        }

        @Step
        public void openLoginPopup() {
            $(loginDropDownItem).click();
        }

        @Step
        public void openRegistrationPopup() {
            $(registrationDropDownItem).click();
        }

    }




}
