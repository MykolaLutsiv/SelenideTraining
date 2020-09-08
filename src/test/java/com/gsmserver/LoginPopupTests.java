package com.gsmserver;

import com.gsmserver.pages.HomePage;
import com.gsmserver.pages.LoginPopup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public class LoginPopupTests extends BaseTest {


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
    void openLoginPopupTest() {

        new HomePage.DropdownAccount()
                .openDropDownPopup()
                .openLoginPopup();
        sleep(3000);

        new LoginPopup()
                .fillLogin("koka@mail.com")
                .fillPassword("koka")
                .clickLogin();

        new LoginPopup()
                .notificationIsPresent();


    }
}
