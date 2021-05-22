package refactor.pages;

import refactor.NavPage;

public interface ProfilePage {

    //ChangePasswordPage changePassword();

    String getName();

    boolean checkNameMatches();

    String getEmail();

    boolean checkEmailMatches();

}
