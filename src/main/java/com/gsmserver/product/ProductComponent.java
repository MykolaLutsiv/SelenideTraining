package com.gsmserver.product;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductComponent {

    private final String productId;
    private SelenideElement parentElement = $("html");

    public ProductComponent(String productId) {
        this.productId = productId;
    }
    public ProductComponent(String productId, SelenideElement parentElement) {
        this.productId = productId;
        this.parentElement = parentElement;
    }

    public ProductComponent findProductFromParentElement
            (String productId, SelenideElement parentElement) {
        return new ProductComponent(productId, parentElement);
    }

    @Step
    public SelenideElement findProductById() {
        return $(by("data-product-id", productId));
    }

    @Step
    public ProductComponent clickOnPlus() {
        findProductById().$("a[name='btn-plus']").click();
        return this;
    }

    @Step
    public ProductComponent clickOnMinus() {
        findProductById().$("a[name='btn-minus']").click();
        return this;
    }

    @Step
    public ProductComponent verifyProductNameText(String productName) {
        findProductById().shouldHave(text(productName));
        return this;
    }

    @Step
    public ProductComponent clickOnAddToCart() {
        findProductById().$("[data-action-click='site.cart.add']").click();
        return this;
    }

    @Step
    public ProductComponent clickOnGoToCart() {
        findProductById().$("[class='in-cart']").click();
        return this;
    }

    @Step
    public SelenideElement getProductTitle() {
        return findProductById().$(".product-info_title,[original-title]");
    }

    @Step
    public ElementsCollection getCartNumberOfProduct() {
        return $$("#cart tr[data-product-id]");
    }

    @Step
    public SelenideElement getInCartQuantityOnHeader() {
        return $(".hdr_cart > i");
    }

    @Step
    public SelenideElement getInCartQuantity() {
        return findProductById().$("[name='quantity']");
    }

    @Step
    public SelenideElement getProductPrice() {
        return findProductById().$(".product-price");
    }
}
