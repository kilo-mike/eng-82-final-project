package com.sparta.eng82.components.pages.trainer.addpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.pages.trainer.ManageGroupPage;
import com.sparta.eng82.components.pages.trainer.ManageGroupPageImpl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddGroupPageImpl implements AddGroupPage {

    private final By streamNameField = new By.ById("streamName");
    private final By groupNameField = new By.ById("groupName");
    private final By groupStartDateField = new By.ById("groupStartDate");
    private final By createNewGroupButton = new By.ByCssSelector("#addNewGroup .btn");
    private final By groupField = new By.ById("traineeGroup");
    WebDriver driver;
    private final String user;

    //private By addTraineeButton = new By.ByLinkText("Add Trainee");

    public AddGroupPageImpl(WebDriver driver, String user) {

        this.driver = driver;
        this.user = user;
    }

    //Changed the return types from AddGroupPage to void in the interface
    @Override
    public AddGroupPageImpl selectStream(String streamName) {
        WebElement streamOptions = driver.findElement(By.id("streamName"));
        Select select = new Select(streamOptions);

        select.selectByVisibleText(streamName);

        return this;
    }

    @Override
    public AddGroupPageImpl enterGroupName(String groupName) {
        driver.findElement(groupNameField).sendKeys(groupName);
        return this;
    }

    @Override
    public AddGroupPageImpl enterGroupStartDate(String startDate) {
        driver.findElement(groupStartDateField).sendKeys(startDate);
        return this;
    }

    @Override
    public ManageGroupPage createNewGroup() {
        driver.findElement(createNewGroupButton).click();
        return new ManageGroupPageImpl(driver, user);
    }


    @Override
    public boolean isGroupCreated(String groupName) {
        List<WebElement> groups = driver.findElements(By.id("traineeGroup"));

        boolean isPresent = false;

        for (WebElement group: groups) {
            if (groupName.equals(group.getText())){
                isPresent = true;
            }
            break;
        }
        return isPresent;

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
