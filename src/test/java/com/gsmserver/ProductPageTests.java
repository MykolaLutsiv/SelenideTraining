package com.gsmserver;

import com.codeborne.selenide.Condition;
import com.gsmserver.product.ProductComponentSteps;
import com.gsmserver.product.ProductDto;
import com.gsmserver.product.Products;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.open;

public class ProductPageTests extends BaseTest {

    @ParameterizedTest
    @EnumSource
    void increaseAndDecreaseProductCountTest(Products product) {

        ProductDto productDto = product.getDto();

        open(productDto.getBasePath());
        ProductComponentSteps productSteps =  new ProductComponentSteps(productDto.getId());

        productSteps
                .addToCartProduct()
                .increaseProductCountTo(2)
                .decreaseProductCountTo(2)
                .getInCartQuantity()
                .shouldHave(Condition.value("1"));

        productSteps
                .getProductPageTitle()
                .shouldBe(Condition.text(productDto.getTitle()));

    }

}
