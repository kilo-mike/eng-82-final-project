package com.sparta.eng82.interfaces.pages.external;

import com.sparta.eng82.interfaces.Page;

public interface LoginPage extends Page {

    LoginPage enterEmail(String email);

    LoginPage enterPassword(String password);

    Page login();

    boolean loginAttempt(String email, String password);

    boolean isLogoutMessageShowing();
}
