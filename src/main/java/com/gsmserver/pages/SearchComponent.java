package com.gsmserver.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchComponent extends BasePage {

    @Step
    public void searchFor(String searchQuery) {
        $("[name='searchword']").val(searchQuery).pressEnter();
    }

    @Step
    public SearchComponent fillSearchQue(String searchQuery) {
        $("[name='searchword']").val(searchQuery);
        return this;
    }

    @Step
    public void clickOnSeeAll() {
        $("[data-quicksearch='bottom-block'] a").click();
    }

    @Step
    public SelenideElement fillSearch(String searchQuery) {
        return $("[name='searchword']").val(searchQuery);
    }

}
