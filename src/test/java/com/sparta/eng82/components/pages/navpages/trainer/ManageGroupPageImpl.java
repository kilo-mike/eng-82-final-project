package com.sparta.eng82.components.pages.navpages.trainer;

import com.sparta.eng82.components.pages.navpages.trainer.addpages.AddGroupPageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.addpages.AddStreamPageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.addpages.AddTraineePageImpl;
import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddGroupPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddStreamPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddTraineePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageGroupPageImpl implements ManageGroupPage {

    private final By removeButton = new By.ByLinkText("Remove");
    private final By deleteTrainerButton = new By.ByLinkText("Delete Trainer");
    private final By addTraineeButton = new By.ByLinkText("Add Trainee");
    private final By addGroupButton = new By.ByLinkText("Add Group");
    private final By addStreamButton = new By.ByLinkText("Add Stream");
    private final By listClassName = new By.ByClassName("list-group");
    WebDriver driver;
    private By removeButtonIdentifier;

    public ManageGroupPageImpl(WebDriver driver) {
        this.driver = driver;
    }

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
