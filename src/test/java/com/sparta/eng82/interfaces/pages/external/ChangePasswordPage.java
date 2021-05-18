package com.sparta.eng82.interfaces.pages.external;

import com.sparta.eng82.interfaces.Page;

public interface ChangePasswordPage extends Page {

    ChangePasswordPage enterCurrentPassword(String password);

    ChangePasswordPage enterNewPassword(String password);

    ChangePasswordPage enterConfirmPassword(String password);

    Page clickChange();

    boolean changePasswordAttempt(String currentPassword, String newPassword, String confirmPassword);
}
