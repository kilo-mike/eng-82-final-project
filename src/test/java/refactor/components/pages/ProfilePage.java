package refactor.components.pages;

import refactor.components.pages.other.ChangePasswordPage;

public interface ProfilePage {

    ChangePasswordPage goToChangePasswordPage();

    String getName();

    boolean checkNameMatches();

    String getEmail();

    boolean checkEmailMatches();

}
