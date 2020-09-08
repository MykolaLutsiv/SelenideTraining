package com.gsmserver;

import com.codeborne.selenide.Condition;
import com.gsmserver.pages.HomePage;
import com.gsmserver.product.ProductComponent;
import com.gsmserver.pages.SearchComponent;
import com.gsmserver.pages.SearchResultPage;
import com.gsmserver.product.ProductDto;
import com.gsmserver.product.Products;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests extends BaseTest {

    @BeforeEach
    void openHomePage() {
        open("/");
    }

    @AfterEach
    void  clearData() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Test
    void searchProductByTitleTest() {

        var productName = "Z3X Easy-Jtag Plus Full Set";

        new HomePage().searchComponent.searchFor(productName);
        new SearchResultPage()
                .verifySearchResultTitle(productName);

        new SearchResultPage()
                .getSearchResultListSize()
                .shouldHaveSize(3);

        new SearchResultPage()
                .getFirstProductInfoTitle()
                .shouldBe(text(productName));
    }

    @Test
    void searchForProductViaClickOnSeeAllTest() {
        ProductDto productDto = Products.MedusaBox.getDto();
        var productName = productDto.getTitle();

        new HomePage().searchComponent.fillSearchQue(productName).clickOnSeeAll();
        new HomePage().targetProduct(productDto.getId()).verifyProductNameText(productName);
        new SearchResultPage()
                .getSearchResultTitle()
                .shouldBe(text(productName));

    }

    @Test
    void searchProductByTitleAndGoToCartTest() {

        ProductDto productDto = Products.MedusaBox.getDto();
        var productName = productDto.getTitle();
        var productId = productDto.getId();

        new SearchComponent().searchFor(productName);
        new SearchResultPage().verifySearchResultTitle(productName);

        ProductComponent productComponent = new ProductComponent(productId);

        productComponent
                .getProductTitle()
                .shouldHave(text(productName));

        productComponent.clickOnAddToCart()
                .getInCartQuantity()
                .shouldHave(value("1"));

        productComponent.clickOnPlus()
                .getInCartQuantity()
                .shouldHave(value("2"));

        productComponent.clickOnGoToCart()
                .getCartNumberOfProduct().shouldHaveSize(1);

        productComponent.verifyProductNameText(productName);
    }

}
