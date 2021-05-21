package com.sparta.eng82.interfaces.pages.accesspages;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.NavPage;

public interface LoginPage extends Page {

    LoginPageImpl driverGet();

    LoginPageImpl enterEmail();

    LoginPageImpl enterEmail(String email);

    LoginPageImpl enterPassword();

    LoginPageImpl enterPassword(String password);

    NavPage clickLogin();

    boolean loginAttempt();

    boolean loginAttempt(String email, String password);

    boolean wrongPasswordAttempt(String wrongPassword);

    boolean isLogoutMessageShowing();
}
