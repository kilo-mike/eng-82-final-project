package refactor.components.pages.trainer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.components.NavPage;
import refactor.components.pages.ProfilePage;
import refactor.components.pages.other.ChangePasswordPage;
import refactor.components.pages.other.ChangePasswordPageImpl;

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
    public ChangePasswordPage goToChangePasswordPage() {
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[3]/form/button")).submit();
        return new ChangePasswordPageImpl(driver, user);
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
