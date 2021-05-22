package refactor.pages.trainer;

import org.openqa.selenium.WebDriver;
import refactor.NavPage;
import refactor.pages.ProfilePage;

public class TrainerProfilePageImpl extends NavPage implements ProfilePage {

    private final WebDriver driver;
    private final String user;

    public TrainerProfilePageImpl(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
        this.user = user;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean checkNameMatches() {
        return false;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public boolean checkEmailMatches() {
        return false;
    }
}
