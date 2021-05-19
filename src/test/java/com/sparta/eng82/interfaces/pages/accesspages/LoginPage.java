package com.sparta.eng82.interfaces.pages.accesspages;

import com.sparta.eng82.interfaces.Page;

import java.util.Properties;

public interface LoginPage extends Page {

    LoginPage enterEmail(String email, Properties properties);

    LoginPage enterPassword(String password, Properties properties);

    Page login(String userPropertyName);

    boolean loginAttempt(String userPropertyName, String userPropertyUsername, String userPropertyPassword, Properties properties);

    boolean isLogoutMessageShowing();
}
