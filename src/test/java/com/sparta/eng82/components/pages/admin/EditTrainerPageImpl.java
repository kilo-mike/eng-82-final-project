package com.sparta.eng82.components.pages.admin;

import com.sparta.eng82.components.frameworkutil.ActionClicker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EditTrainerPageImpl implements EditTrainerPage {

    private final WebDriver driver;
    private final String user;

    public EditTrainerPageImpl(WebDriver driver, String user) {
        this.driver = driver;
        this.user = user;
    }

    @Override
    public EditTrainerPageImpl editFirstName(String firstName) {
//        driver.findElement(By.id("editTrainerFirstName")).clear();
//        ActionClicker.timedMouseClicker(driver,ActionClicker.TIME,By.id("editTrainerFirstName"));

        driver.findElement( By.id("main-content")).sendKeys(Keys.TAB);
        driver.findElement( By.id("main-content")).sendKeys(Keys.TAB);
        driver.findElement( By.id("editTrainerFirstName")).sendKeys(firstName);
        return this;
    }

    @Override
    public EditTrainerPageImpl editLastName(String lastName) {
        driver.findElement(By.id("editTrainerLastName")).clear();
        driver.findElement( By.id("editTrainerLastName")).sendKeys(lastName);
        return this;
    }

    @Override
    public EditTrainerPageImpl editGroup(String groupName) {
        new Select(driver.findElement( By.id("editTrainerGroup"))).selectByVisibleText(groupName);
        return this;
    }

    @Override
    public EditTrainerPageImpl tickRemove() {
        ActionClicker.timedMouseClicker(driver,ActionClicker.TIME,By.id("confirmation"));
        return this;
    }

    @Override
    public AdminHomePageImpl saveChanges() {
        ActionClicker.timedMouseClicker(driver,ActionClicker.TIME,By.xpath("//*[@id=\"adminEditTrainerModal111\"]/div/div/div[3]/input[1]"));
        return new AdminHomePageImpl(driver,user);
    }

    @Override
    public AdminHomePageImpl removeTrainer() {
        ActionClicker.timedMouseClicker(driver,ActionClicker.TIME,By.xpath("//*[@id=\"adminEditTrainerModal111\"]/div/div/div[3]/input[2]"));
        return new AdminHomePageImpl(driver,user);
    }

    @Override
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public boolean checkFirstNameInputValueCorrect(String input) {
        return driver.findElement(By.id("editTrainerFirstName")).getAttribute("value").equals(input);
    }
}
