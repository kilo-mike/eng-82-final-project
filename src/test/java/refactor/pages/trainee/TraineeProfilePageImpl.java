package refactor.pages.trainee;

import org.openqa.selenium.WebDriver;
import refactor.NavPage;
import refactor.pages.ProfilePage;

public class TraineeProfilePageImpl extends NavPage implements ProfilePage {

    private final WebDriver driver;
    private final String user;

    public TraineeProfilePageImpl(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
        this.user = user;
    }

    @Override
    public String getUrl() {
        return driver.getCurrentUrl();
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
