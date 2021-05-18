package com.sparta.eng82.components.pages.navpages.trainer.addpages;

import com.sparta.eng82.components.pages.navpages.trainer.ManageGroupPageImpl;
import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddGroupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddGroupPageImpl implements AddGroupPage {

    WebDriver driver;

    private By streamNameField = new By.ById("streamName");
    private By groupNameField = new By.ById("groupName");
    private By groupStartDateField = new By.ById("groupStartDate");
    private By createNewGroupButton = new By.ByLinkText("Create New Group");
    private By groupField = new By.ById("traineeGroup");

    //private By addTraineeButton = new By.ByLinkText("Add Trainee");

    public AddGroupPageImpl(WebDriver driver) {
        this.driver = driver;
    }

    //Changed the return types from AddGroupPage to void in the interface
    @Override
    public void selectStream(String streamName) {
        driver.findElement(streamNameField).click();
        driver.findElement(By.linkText(streamName)).click();
    }

    //Previously returned AddGroupPage
    @Override
    public void enterGroupName(String groupName) {
        driver.findElement(groupNameField).sendKeys(groupName);
    }

    //Previously returned AddGroupPage
    @Override
    public void enterGroupStartDate(String startDate) {
        driver.findElement(groupStartDateField).sendKeys(startDate);
    }

    @Override
    public ManageGroupPage createNewGroup() {
        driver.findElement(createNewGroupButton).click();
        return new ManageGroupPageImpl(driver);
    }

    // Added String arg
    //TODO: this
    @Override
    public boolean isGroupCreated(String groupName) {

        return false;
    }

    @Override
    public boolean isDuplicateGroupNameAllowed() {
        return false;
    }

    @Override
    public boolean isPastStartingDateAllowed() {
        return false;
    }

    @Override
    public boolean isEmptyStreamNameAllowed() {
        return false;
    }

    @Override
    public boolean isEmptyGroupNameAllowed() {
        return false;
    }

    @Override
    public boolean isGroupNameCharacterLimited() {
        return false;
    }
}
