package com.sparta.eng82.components.pages.other;

import com.sparta.eng82.components.Page;

public interface LoginPage extends Page {

    LoginPageImpl driverGet();

    LoginPageImpl enterEmail();

    LoginPageImpl enterEmail(String email);

    LoginPageImpl enterPassword();

    LoginPageImpl enterPassword(String password);

    Page login();

    Page login(String email, String password);

    Page clickLogin();

    boolean loginAttempt();

    boolean loginAttempt(String email, String password);

    boolean wrongPasswordAttempt(String wrongPassword);

    boolean isLogoutMessageShowing();
}
