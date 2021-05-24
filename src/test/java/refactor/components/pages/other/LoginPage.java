package refactor.components.pages.other;

import refactor.components.Page;

public interface LoginPage extends Page {

    LoginPageImpl driverGet();

    LoginPageImpl enterEmail();

    LoginPageImpl enterEmail(String email);

    LoginPageImpl enterPassword();

    LoginPageImpl enterPassword(String password);

    Object clickLogin();

    boolean loginAttempt();

    boolean loginAttempt(String email, String password);

    boolean wrongPasswordAttempt(String wrongPassword);

    boolean isLogoutMessageShowing();
}
