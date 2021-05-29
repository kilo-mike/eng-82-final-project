package com.sparta.eng82.components.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.sparta.eng82.components.frameworkutil.ActionClicker;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AddTrainerPageImpl implements AddTrainerPage {

    private final By addTrainerButton = new By.ByLinkText("Add Trainer");
    private final By firstNameTextBox = new By.ById("addtrainerFirstName");
    private final By lastNameTextBox = new By.ById("addtrainerLastName");
    private final String user;
    WebDriver driver;

    public AddTrainerPageImpl(WebDriver driver, String user) {
        this.user = user;
        this.driver = driver;
    }

    @Override
    public AddTrainerPage enterFirstName(String firstName) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(firstNameTextBox).sendKeys(firstName);
        return new AddTrainerPageImpl(driver, user);
    }

    @Override
    public AddTrainerPage enterSecondName(String lastName) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(lastNameTextBox).sendKeys(lastName);
        return new AddTrainerPageImpl(driver, user);
    }

    @Override
    public AddTrainerPage selectGroup(String groupName) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(new By.ById("addTrainerGroup"))));
        Select drpsGroup = new Select(driver.findElement(new By.ById("addTrainerGroup")));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        drpsGroup.selectByVisibleText(groupName);
        return new AddTrainerPageImpl(driver, user);
    }

    @Override
    public AdminHomePage addNewTrainer() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElement(addNewTrainerButton).click();
        ActionClicker.timedSingleMouseClicker(driver,ActionClicker.TIME,new By.ByXPath("//*[@id=\"trainerModal\"]/div/div/form/div[2]/button"));
        return new AdminHomePageImpl(driver, user);
    }


    //TODO fill out these methods later
    //public String currentValueInFirstNameBox(){}

    //public String currentValueInLastNameBox(){}

//    public String currentGroupSelected(){
//        return driver.findElement(By.id("addTrainerGroup")).getAttribute("value");
//    }
}
