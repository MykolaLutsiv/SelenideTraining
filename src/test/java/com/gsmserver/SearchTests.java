package com.gsmserver;

import com.codeborne.selenide.Condition;
import com.gsmserver.pages.HomePage;
import com.gsmserver.product.ProductComponent;
import com.gsmserver.pages.SearchComponent;
import com.gsmserver.pages.SearchResultPage;
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
    void searchProductByTitleTest() {

        var productName = "Z3X Easy-Jtag Plus Full Set";

        new HomePage().searchComponent.searchFor(productName);
        var actualSearchResultTitle = new SearchResultPage().getSearchResultTitle();
        Assertions.assertEquals(productName, actualSearchResultTitle);

        var actualSearchResultListSize = new SearchResultPage().getSearchResultListSize();
        Assertions.assertEquals(3, actualSearchResultListSize);

        var actualFirstProductInfoTitle = new SearchResultPage().getFirstProductInfoTitle();
        Assertions.assertEquals(productName, actualFirstProductInfoTitle);
    }

    @Test
    void searchForProductViaClickOnSeeAllTest() {
        var productName = "Z3X Easy-Jtag Plus Full Set";
        new HomePage().searchComponent.fillSearchQue(productName).clickOnSeeAll();
        var actualSearchResultTitle = new SearchResultPage().getSearchResultTitle();
        Assertions.assertEquals(productName, actualSearchResultTitle);

    }

    @Test
    void searchProductByTitleAndGoToCartTest() {
        clearBrowserCookies();
        clearBrowserLocalStorage();

        var productName = "Sigma Box with Cable Set";
        var productId = "891032";

        new SearchComponent().searchFor(productName);
        new SearchResultPage().verifySearchResultTitle(productName);

        ProductComponent productComponent = new ProductComponent(productId);

        productComponent
                .getProductTitle()
                .shouldHave(text(productName));

        productComponent.clickOnAddToCart()
                .getInCartQuantity()
                .shouldHave(Condition.value("1"));

        productComponent.clickOnPlus()
                .getInCartQuantity()
                .shouldHave(Condition.value("2"));

        productComponent.clickOnGoToCart()
                .getCartNumberOfProduct().shouldHaveSize(1);

        productComponent.verifyProductNameText(productName);
    }

}
