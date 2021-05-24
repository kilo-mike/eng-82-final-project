//package com.sparta.eng82.components.pages.navpages.admin.addpages;
//
//import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
//import com.sparta.eng82.interfaces.pages.navpages.admin.AdminHomePage;
//import com.sparta.eng82.interfaces.pages.navpages.admin.addpages.AddTrainerPage;
//import com.sparta.eng82.tests.unit.frameworkutil.PropertiesUtil;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.Select;
//
//public class AddTrainerPageImpl implements AddTrainerPage {
//
//    private final By addTrainerButton = new By.ByLinkText("Add Trainer");
//    private final By firstNameTextBox = new By.ById("addtrainerFirstName");
//    private final By lastNameTextBox = new By.ById("addtrainerLastName");
//    private final By addNewTrainerButton = new By.ByCssSelector(".modal-footer");
//    WebDriver driver;
//
//    public AddTrainerPageImpl(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    @Override
//    public AddTrainerPage addTrainer() {
//        driver.findElement(addTrainerButton).click();
//        return new AddTrainerPageImpl(driver);
//    }
//
//    @Override
//    public AddTrainerPage enterFirstName(String firstName) {
//        driver.findElement(firstNameTextBox).sendKeys(firstName);
//        return new AddTrainerPageImpl(driver);
//    }
//
//    @Override
//    public AddTrainerPage enterSecondName(String lastName) {
//        driver.findElement(lastNameTextBox).sendKeys(lastName);
//        return new AddTrainerPageImpl(driver);
//    }
//
//    @Override
//    public AddTrainerPage selectGroup(String groupName) {
//        Select drpsGroup = new Select(driver.findElement(new By.ById("addTrainerGroup")));
//        drpsGroup.selectByVisibleText(groupName);
//        return new AddTrainerPageImpl(driver);
//    }
//
//    @Override
//    public AdminHomePage addNewTrainer() {
////        driver.findElement(addNewTrainerButton).click();
//        PropertiesUtil.timedMouseClicker(driver,400,new By.ByXPath("//*[@id=\"trainerModal\"]/div/div/form/div[2]/button"));
//        return new AdminHomePageImpl(driver);
//    }
//}
