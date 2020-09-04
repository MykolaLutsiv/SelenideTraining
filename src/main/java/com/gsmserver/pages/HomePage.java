package com.gsmserver.pages;

import com.gsmserver.product.ProductComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public SearchComponent searchComponent = new SearchComponent();

    public ProductComponent targetProduct(String productId) {
        return new ProductComponent(productId);
    }



    public static class DropdownAccount {

        private final By  dropDownAccount = By.cssSelector("[space*='header/dropdown/account']"),
                    loginDropDownItem = By.cssSelector("[name='login']"),
                registrationDropDownItem = By.cssSelector("[name='registration']");

        @Step
        public DropdownAccount openDropDownPopup() {
            $(dropDownAccount).hover();
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
