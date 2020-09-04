package com.gsmserver.decorators;

import com.codeborne.selenide.Selenide;

public class PriceCalculator {

    private final Double targetPrice;

    public PriceCalculator(String targetPrice) {
        this.targetPrice = Double.valueOf(targetPrice);
    }


    public String multiply(int secondDigit) {
        Double result = targetPrice * secondDigit;
        return String.valueOf(result);
    }


}
