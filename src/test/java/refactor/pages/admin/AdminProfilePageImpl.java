package refactor.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.NavPage;
import refactor.frameworkutil.PropertiesLoader;
import refactor.pages.ProfilePage;

public class AdminProfilePageImpl extends NavPage implements ProfilePage{

    private final WebDriver driver;
    private final String user;

    public AdminProfilePageImpl(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
        this.user = user;
    }

    @Override
    public String getUrl() {
        return driver.getCurrentUrl();
    }

//    @Override
//    public ChangePasswordPage changePassword() {
//    driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[3]/form/button")).submit();
//        return new ChangePasswordPageImpl(driver);
//        return null;
//    }

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
