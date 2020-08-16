package com.gsmserver;

import com.gsmserver.Pages.HomePage;
import com.gsmserver.Pages.LoginPopup;
import org.junit.jupiter.api.Test;

public class LoginPopupTests {


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
