package com.sparta.eng82.interfaces.pages.navpages;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.external.ChangePasswordPage;

public interface ProfilePage extends NavPage {

    ChangePasswordPage changePassword();

    String getName();

    boolean checkNameMatches();

    String getEmail();

    boolean checkEmailMatches();
}
