package refactor.components.pages;

public interface ProfilePage {

    //ChangePasswordPage changePassword();

    String getName();

    boolean checkNameMatches();

    String getEmail();

    boolean checkEmailMatches();

}
