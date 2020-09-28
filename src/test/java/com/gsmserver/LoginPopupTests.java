package com.gsmserver;

import com.github.javafaker.Faker;
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

    }

    @AfterEach
    void  clearData() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Test
    void openLoginPopupTest() {
        Faker faker = new Faker();

        new HomePage.DropdownAccount()
                .openDropDownPopup()
                .openLoginPopup();

        new LoginPopup()
                .fillLogin("mykola.test@mailinator.com")
                .fillPassword("Changeme123!")
                .clickLogin();

        new HomePage.DropdownAccount()
                .verifyTitleAboveMyAccount("Hello, Mykola");
    }

    @Test
    void loginAndLogoutTest() {

        new HomePage.DropdownAccount()
                .openDropDownPopup()
                .openLoginPopup();

        new LoginPopup()
                .fillLogin("mykola.test@mailinator.com")
                .fillPassword("Changeme123!")
                .clickLogin();

        new HomePage.DropdownAccount()
                .verifyTitleAboveMyAccount("Hello, Mykola")
                .openDropDownPopup()
                .logout()
                .verifyTitleAboveMyAccount("Log In");
    }

    @Test
    void failedLoginTest() {

        new HomePage.DropdownAccount()
                .openDropDownPopup()
                .openLoginPopup();

        new LoginPopup()
                .fillLogin("mykola.test@mailinator.com")
                .fillPassword("invalidPass")
                .clickLogin()
                .notificationIsPresent();

        new HomePage.DropdownAccount()
                .verifyTitleAboveMyAccount("Log In");
    }
}
