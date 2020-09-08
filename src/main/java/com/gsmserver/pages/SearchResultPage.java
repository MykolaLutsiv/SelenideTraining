package com.gsmserver.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {

    private final By productListItem = By.cssSelector(".product-view-list li");

    @Step
    public SelenideElement getSearchResultTitle() {
        return $(".search-title-highlight");
    }

    @Step
    public void verifySearchResultTitle(String productName) {
        $(".search-title-highlight").shouldBe(Condition.text(productName));
    }

    public ElementsCollection getSearchResultListSize() {
        return $$(productListItem);
    }

    public SelenideElement getFirstProductInfoTitle() {
        return $(productListItem).$(".product-info_title");
    }
}
