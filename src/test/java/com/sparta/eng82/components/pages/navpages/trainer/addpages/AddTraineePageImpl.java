package com.sparta.eng82.components.pages.navpages.trainer.addpages;

import com.sparta.eng82.components.pages.navpages.trainer.ManageGroupPageImpl;
import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddTraineePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTraineePageImpl implements AddTraineePage {

    private final By traineeGroupField = new By.ById("traineeGroup");
    private final By traineeFirstNameField = new By.ById("traineeFirstName");
    private final By traineeLastNameField = new By.ById("traineeLastName");
    private final By createNewTraineeButton = new By.ByLinkText("Create New Trainee");
    WebDriver driver;
    private By groupNames;

    public AddTraineePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public AddTraineePage assignGroup(String groupName) {
        groupNames = new By.ByLinkText(groupName);

        driver.findElement(traineeGroupField).click();
        driver.findElement(groupNames).click();
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
        driver.findElement(createNewTraineeButton).click();
        return new ManageGroupPageImpl(driver);
    }

    @Override
    public boolean isTraineeCreated() {
        return false;
    }
}
