package com.sparta.eng82.components.pages;

import com.sparta.eng82.components.pages.other.ChangePasswordPage;

public interface ProfilePage {

    ChangePasswordPage goToChangePasswordPage();

    String getName();

    boolean checkNameMatches();

    String getEmail();

    boolean checkEmailMatches();

}
