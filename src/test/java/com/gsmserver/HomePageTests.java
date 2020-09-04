package com.gsmserver;

import com.gsmserver.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class HomePageTests extends BaseTest {

    @BeforeEach
    void openHomePage() {
        open("/");
//        sleep(300);
    }

    @Test
    public void addToCartProductFromCaruselTest() {
        new HomePage().targetProduct("860988")
                .clickOnAddToCart();
    }

}
