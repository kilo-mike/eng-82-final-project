package com.sparta.eng82.components.pages.admin;

import com.sparta.eng82.components.frameworkutil.ActionClicker;
import com.sparta.eng82.components.frameworkutil.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EditTrainerPageImpl implements EditTrainerPage {

    private final WebDriver driver;
    private final String user;

    public EditTrainerPageImpl(WebDriver driver, String user) {
        this.driver = driver;
        this.user = user;
    }

    @Override
    public EditTrainerPageImpl editFirstName(String firstName) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ByXPath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[1]/div/input")).clear();
        driver.findElement(new By.ByXPath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[1]/div/input")).sendKeys(firstName);

        return this;
    }

    @Override
    public EditTrainerPageImpl editLastName(String lastName) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ByXPath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[2]/div/input")).clear();
        driver.findElement(new By.ByXPath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[2]/div/input")).sendKeys(lastName);
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

    public AdminHomePageImpl resetTrainerInfo(String firstName, String lastName){
        editFirstName(firstName);
        editLastName(lastName);
        editGroup("No Group");
        saveChanges();
        return new AdminHomePageImpl(driver,user);
    }

    public boolean checkFirstNameInputValueCorrect(String input) {
        return driver.findElement(By.xpath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[1]/div/input")).getAttribute("value").equals(input);
    }

    public boolean checkLastNameInputValueCorrect(String input) {
        return driver.findElement(By.xpath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[2]/div/input")).getAttribute("value").equals(input);
    }

    public boolean checkGroupNameSelectValueCorrect(String input) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[3]/div/select"));
        Select select = new Select(webElement);
        return select.getFirstSelectedOption().getText().equals(input);

//        return driver.findElement(By.xpath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[3]/div/select")).getAttribute("selected").equals(input);
    }
}
