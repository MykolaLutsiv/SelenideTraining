package com.gsmserver;

import com.gsmserver.Pages.HomePage;
import com.gsmserver.Pages.ProductComponent;
import com.gsmserver.Pages.SearchResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests extends BaseTest {

    @BeforeEach
    void openHomePage() {
        open("/");
//        sleep(300);
    }

    @Test
    void searchProductByTitleTestWithKissDry() {
        var productName = "Sigma Box with Cable Set";
        var productId = "891032";

        $("[name='searchword']").val(productName).pressEnter();
        $(".search-title-highlight").shouldHave(text(productName));

        ProductComponent productComponent = new ProductComponent();

        productComponent.findProductById(productId).$(".product-info_title").shouldHave(text(productName));

        productComponent.findProductById(productId).$("[data-action-click='site.cart.add']").click();
        $(".hdr_cart > i").shouldHave(text("1"));

        productComponent.findProductById(productId).$("a[name='btn-plus']").click();
        $(".hdr_cart > i").shouldHave(text("2"));
        productComponent.findProductById(productId).$("input[data-value='2']").shouldBe(visible);
        productComponent.findProductById(productId).$(".in-cart").click();

        $$("#cart tr[data-product-id]").shouldHaveSize(1);
        productComponent.findProductById(productId).shouldHave(text(productName));
        actions().dragAndDrop($("#cart tr[data-product-id]"), $("#cart tr[data-product-id]"));
    }


    @Test
    void searchProductByTitleTest() {

        var productName = "Z3X Easy-Jtag Plus Full Set";
        new HomePage().searchFor(productName);

        var actualSearchResultTitle = new SearchResultPage().getSearchResultTitle();
        Assertions.assertEquals(productName, actualSearchResultTitle);

        var actualSearchResultListSize = new SearchResultPage().getSearchResultListSize();
        Assertions.assertEquals(3, actualSearchResultListSize);

        var actualFirstProductInfoTitle = new SearchResultPage().getFirstProductInfoTitle();
        Assertions.assertEquals(productName, actualFirstProductInfoTitle);
    }

}
