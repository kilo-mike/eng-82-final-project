package com.sparta.eng82.interfaces.pages.accesspages;

import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.NavPage;

public interface LoginPage extends Page {

    LoginPage enterEmail();

    LoginPage enterEmail(String email);

    LoginPage enterPassword();

    LoginPage enterPassword(String password);

    NavPage login();

    boolean loginAttempt();

    boolean wrongPasswordAttempt();
}
