package com.sparta.eng82.components.pages.navpages.trainer;

import com.sparta.eng82.components.pages.navpages.trainer.addpages.AddGroupPageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.addpages.AddStreamPageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.addpages.AddTraineePageImpl;
import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.accesspages.LoginPage;
import com.sparta.eng82.interfaces.pages.navpages.CompetenciesPage;
import com.sparta.eng82.interfaces.pages.navpages.ProfilePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageGroupPageImpl implements ManageGroupPage {

    WebDriver driver;

    private By removeButton = new By.ByLinkText("Remove");
    private By deleteTrainerButton = new By.ByLinkText("Delete Trainer");
    private By addTraineeButton = new By.ByLinkText("Add Trainee");
    private By addGroupButton = new By.ByLinkText("Add Group");
    private By addStreamButton = new By.ByLinkText("Add Stream");
    private By listClassName = new By.ByClassName("list-group");
    private By removeButtonIdentifier;

    public ManageGroupPageImpl(WebDriver driver) {
        this.driver = driver;


    @Override
    public ManageGroupPage removeTrainee(String traineeName) {
        int numberOfRemoveButtons = driver.findElements(removeButton).size();
        removeButtonIdentifier = new By.ByXPath("//a[@class='list-group-item list-group-item-action' and text()='" + traineeName + "']");

        if (numberOfRemoveButtons == 1) {
            driver.findElement(removeButton).click();
        } else {
            driver.findElement(listClassName).findElement(removeButtonIdentifier).findElement(removeButton).click();
            driver.findElement(deleteTrainerButton).click();
        }
        return this;

    }

    @Override
    public AddTraineePage addTrainee() {
        driver.findElement(addTraineeButton).click();
        return new AddTraineePageImpl(driver);

    }

    @Override
    public AddGroupPage addGroup() {
        driver.findElement(addGroupButton).click();
        return new AddGroupPageImpl(driver);

    }

    @Override
    public AddStreamPage addStream() {
        driver.findElement(addStreamButton).click();
        return new AddStreamPageImpl(driver);

    }

    @Override
    public boolean isTraineeRemoved(String traineeName) {
        return false;
    }
}
