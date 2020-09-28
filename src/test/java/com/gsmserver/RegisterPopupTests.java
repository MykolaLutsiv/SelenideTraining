package com.gsmserver;

import com.github.javafaker.Faker;
import com.gsmserver.pages.HomePage;
import com.gsmserver.pages.LoginPopup;
import com.gsmserver.pages.RegisterPopup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegisterPopupTests extends BaseTest {

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
    void openRegistrationPopupTest() {
        new HomePage.DropdownAccount()
                .openDropDownPopup()
                .openRegistrationPopup();

        new RegisterPopup()
                .clickRegister();
    }

    @Test
    void failedRegistrationPopupWithoutAcceptUserAgreementTest() {
        new HomePage.DropdownAccount()
                .openDropDownPopup()
                .openRegistrationPopup();

        new RegisterPopup()
                .fillFirstName(faker.name().fullName())
                .fillEmailLogin(faker.internet().emailAddress())
                .fillPassword(faker.internet().password())
                .selectCountry("United States")
                .selectPhonePrefix("+1")
                .fillCellPhone(faker.phoneNumber().cellPhone())
                .clickRegister()
                .errorIsPresent();
    }

    @Test
    void successRegistrationTest() {
        new HomePage.DropdownAccount()
                .openDropDownPopup()
                .openRegistrationPopup();

        new RegisterPopup()
                .fillFirstName(faker.name().fullName())
                .fillEmailLogin(faker.internet().emailAddress())
                .fillPassword(faker.internet().password())
                .selectCountry("United States")
                .selectPhonePrefix("+1")
                .fillCellPhone(faker.phoneNumber().cellPhone())
                .acceptUserAgreement()
                .clickRegister()
                .confirmRegistrationIsPresent();
    }
}
