package refactor.components.pages.trainer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.components.NavPage;
import refactor.components.frameworkutil.PropertiesLoader;
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
        return driver.findElement(new By.ByXPath("//*[@id=\"main-content\"]/div/div[2]/span/table/tbody/tr[1]/td[2]")).getText();
    }

    @Override
    public boolean checkNameMatches() {
        return PropertiesLoader.userProperties.containsValue(getName());
    }

    @Override
    public String getEmail() {
        return driver.findElement(new By.ByXPath("//*[@id=\"main-content\"]/div/div[2]/span/table/tbody/tr[2]/td[2]")).getText();
    }

    @Override
    public boolean checkEmailMatches() {
        return PropertiesLoader.userProperties.containsValue(getEmail());
    }
}
