package com.gsmserver.Pages;


import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    public String getSearchResultTitle() {
        return $(".search-title-highlight").getText();

    }
}
