package com.sparta.eng82.interfaces.pages.external;

import com.sparta.eng82.interfaces.Page;

public interface LoginPage extends Page {

    LoginPage enterEmail();

    LoginPage enterPassword();

    LoginPage enterIncorrectEmail();

    LoginPage enterIncorrectPassword();

    Page login();
}
