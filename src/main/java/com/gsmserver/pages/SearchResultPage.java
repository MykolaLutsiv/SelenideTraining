package com.gsmserver.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {

    private final By productListItem = By.cssSelector(".product-view-list li");

    @Step
    public String getSearchResultTitle() {
        return $(".search-title-highlight").getText();
    }

    @Step
    public void verifySearchResultTitle(String productName) {
        $(".search-title-highlight").shouldBe(Condition.text(productName));
    }

    public int getSearchResultListSize() {
        return $$(productListItem).size();
    }

    public String getFirstProductInfoTitle() {
        return $(productListItem).$(".product-info_title").getText();
    }
}