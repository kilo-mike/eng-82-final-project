//package com.sparta.eng82.components.pages.navpages.trainer.addpages;
//
//import com.sparta.eng82.components.pages.navpages.trainer.ManageGroupPageImpl;
//import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;
//import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddGroupPage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class AddGroupPageImpl implements AddGroupPage {
//
//    private final By streamNameField = new By.ById("streamName");
//    private final By groupNameField = new By.ById("groupName");
//    private final By groupStartDateField = new By.ById("groupStartDate");
//    private final By createNewGroupButton = new By.ByLinkText("Create New Group");
//    private final By groupField = new By.ById("traineeGroup");
//    WebDriver driver;
//
//    //private By addTraineeButton = new By.ByLinkText("Add Trainee");
//
//    public AddGroupPageImpl(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    //Changed the return types from AddGroupPage to void in the interface
//    @Override
//    public AddGroupPageImpl selectStream(String streamName) {
//        driver.findElement(streamNameField).click();
//        driver.findElement(By.linkText(streamName)).click();
//        return this;
//    }
//
//    //Previously returned AddGroupPage
//    @Override
//    public AddGroupPageImpl enterGroupName(String groupName) {
//        driver.findElement(groupNameField).sendKeys(groupName);
//        return this;
//    }
//
//    //Previously returned AddGroupPage
//    @Override
//    public AddGroupPageImpl enterGroupStartDate(String startDate) {
//        driver.findElement(groupStartDateField).sendKeys(startDate);
//        return this;
//    }
//
//    @Override
//    public ManageGroupPage createNewGroup() {
//        driver.findElement(createNewGroupButton).click();
//        return new ManageGroupPageImpl(driver);
//    }
//
//    // Added String arg
//    //TODO: this
//    @Override
//    public boolean isGroupCreated(String groupName) {
//
//        return false;
//    }
//
//    @Override
//    public boolean isDuplicateGroupNameAllowed() {
//        return false;
//    }
//
//    @Override
//    public boolean isPastStartingDateAllowed() {
//        return false;
//    }
//
//    @Override
//    public boolean isEmptyStreamNameAllowed() {
//        return false;
//    }
//
//    @Override
//    public boolean isEmptyGroupNameAllowed() {
//        return false;
//    }
//
//    @Override
//    public boolean isGroupNameCharacterLimited() {
//        return false;
//    }
//}
