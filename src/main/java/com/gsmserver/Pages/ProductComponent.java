package com.gsmserver.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class ProductComponent {
    public SelenideElement findProductById(String productId) {
        return $(by("data-product-id", productId));
    }

}
