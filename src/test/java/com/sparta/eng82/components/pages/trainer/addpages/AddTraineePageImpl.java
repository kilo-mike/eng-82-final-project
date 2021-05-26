package com.sparta.eng82.components.pages.trainer.addpages;

import com.sparta.eng82.components.frameworkutil.ActionClicker;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.pages.trainer.ManageGroupPage;
import com.sparta.eng82.components.pages.trainer.ManageGroupPageImpl;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class AddTraineePageImpl implements AddTraineePage {

    private final By traineeGroupField = new By.ById("traineeGroup");
    private final By traineeFirstNameField = new By.ById("traineeFirstName");
    private final By traineeLastNameField = new By.ById("traineeLastName");
    private final By createNewTraineeButton = new By.ById("addNewTrainee");
    WebDriver driver;
    private By groupNames;
    private final String user;

    public AddTraineePageImpl(WebDriver driver,String user) {

        this.driver = driver;
        this.user = user;
    }

    @Override
    public AddTraineePage assignGroup(String groupName) {

        Select select = new Select(driver.findElement(traineeGroupField));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        select.selectByVisibleText(groupName);

        return this;
    }

    @Override
    public AddTraineePage enterFirstName(String firstName) {

        driver.findElement(traineeFirstNameField).sendKeys(firstName);
        return this;
    }

    @Override
    public AddTraineePage enterLastName(String lastName) {

        driver.findElement(traineeLastNameField).sendKeys(lastName);
        return this;
    }

    @Override
    public ManageGroupPage createNewTrainee() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, createNewTraineeButton);
        return new ManageGroupPageImpl(driver,user);
    }

    @Override
    public boolean isTraineeCreated() {
        return false;
    }
}
