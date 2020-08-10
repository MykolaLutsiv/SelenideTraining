package com.gsmserver;

import com.codeborne.selenide.SelenideElement;
import com.gsmserver.Pages.HomePage;
import com.gsmserver.Pages.SearchResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests extends BasePage {

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
        findProductById(productId).$(".product-info_title").shouldHave(text(productName));

        findProductById(productId).$("[data-action-click='site.cart.add']").click();
        $(".hdr_cart > i").shouldHave(text("1"));

        findProductById(productId).$("a[name='btn-plus']").click();
        $(".hdr_cart > i").shouldHave(text("2"));
        findProductById(productId).$("input[data-value='2']").shouldBe(visible);
        findProductById(productId).$(".in-cart").click();

        $$("#cart tr[data-product-id]").shouldHaveSize(1);
        findProductById(productId).shouldHave(text(productName));
        actions().dragAndDrop($("#cart tr[data-product-id]"), $("#cart tr[data-product-id]"));
    }

    private SelenideElement findProductById(String productId) {
        return $(by("data-product-id", productId));
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
