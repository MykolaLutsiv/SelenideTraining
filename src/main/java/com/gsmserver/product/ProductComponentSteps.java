package com.gsmserver.product;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ProductComponentSteps extends ProductComponent {

    public ProductComponentSteps(String productId) {
        super(productId);
    }

    @Step
    public ProductComponentSteps addToCartProduct() {
        clickOnAddToCart();
        return this;
    }

    @Step
    public ProductComponentSteps increaseProductCountTo(int count) {
        for (int i = 0; i < count; i++) {
            clickOnPlus();
        }
        return this;
    }

    @Step
    public ProductComponentSteps decreaseProductCountTo(int count) {
        for (int i = 0; i < count; i++) {
            clickOnMinus();
        }
        return this;
    }

    @Step
    public SelenideElement getProductPageTitle() {
        return new ProductPage().getTitle();
    }
}
