package com.sparta.eng82.interfaces.pages.accesspages;

import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.NavPage;

public interface ChangePasswordPage extends Page {

    ChangePasswordPage enterCurrentPassword(String password);

    ChangePasswordPage enterNewPassword(String password);

    ChangePasswordPage enterConfirmPassword(String password);

    NavPage clickChange(String user);

    boolean changePasswordAttempt(String user, String currentPassword, String newPassword, String confirmPassword);
}
