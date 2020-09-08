package com.gsmserver;

import com.gsmserver.pages.HomePage;
import com.gsmserver.product.ProductDto;
import com.gsmserver.product.Products;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public class HomePageTests extends BaseTest {

    @BeforeEach
    void openHomePage() {
        open("/");
//        sleep(300);
    }
    @AfterEach
    void  clearData() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Test
    public void addToCartProductFromCaruselTest() {
        ProductDto productDto = Products.MedusaBox.getDto();
        new HomePage().targetProduct(productDto.getId())
                .clickOnAddToCart();
    }

}
