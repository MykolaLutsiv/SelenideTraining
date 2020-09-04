package com.gsmserver;

import com.gsmserver.pages.HomePage;
import com.gsmserver.pages.LoginPopup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPopupTests extends BaseTest {


    @BeforeEach
    void openHomePage() {
        open("/");
//        sleep(300);
    }

    @Test
    void openLoginPopupTest() {

        new HomePage.DropdownAccount()
                .openDropDownPopup()
                .openLoginPopup();

        new LoginPopup()
                .fillLogin()
                .fillPassword()
                .clickLogin();


    }
}