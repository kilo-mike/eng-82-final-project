package refactor.components.pages.other;


import refactor.components.NavPage;
import refactor.components.Page;

public interface ChangePasswordPage extends Page {

    ChangePasswordPage enterCurrentPassword(String password);

    ChangePasswordPage enterCurrentPassword();

    ChangePasswordPage enterNewPassword(String password);

    ChangePasswordPage enterConfirmPassword(String password);

    NavPage clickChange(String user);

    boolean changePasswordAttempt(String newPassword, String confirmPassword);

    int lengthOfCurrentPasswordInputValue();

    int lengthOfNewPasswordInputValue();

    int lengthOfConfirmPasswordInputValue();
}
