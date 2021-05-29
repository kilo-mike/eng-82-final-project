package com.sparta.eng82.components.pages.trainer.addpages;

import com.sparta.eng82.components.frameworkutil.ActionClicker;
import org.openqa.selenium.*;
import com.sparta.eng82.components.pages.trainer.ManageGroupPage;
import com.sparta.eng82.components.pages.trainer.ManageGroupPageImpl;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;
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
    public AddTraineePageImpl assignGroup(String groupName) {

        Select select = new Select(driver.findElement(traineeGroupField));

        select.selectByVisibleText(groupName);

        return this;
    }

    @Override
    public AddTraineePageImpl enterFirstName(String firstName) {
        driver.findElement(traineeFirstNameField).sendKeys(firstName);
        return this;
    }

    @Override
    public AddTraineePageImpl enterLastName(String lastName) {

        driver.findElement(traineeLastNameField).sendKeys(lastName);
        return this;
    }

    @Override
    public ManageGroupPageImpl createNewTrainee() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, createNewTraineeButton);
        return new ManageGroupPageImpl(driver,user);
    }

    @Override
    public boolean isTraineeCreated(String traineeName) {
        List<WebElement> students = driver.findElements(By.className("list-group-item-action"));
        boolean isPresent = false;
        for (WebElement student: students) {
            if (traineeName.equals(student.getText())){
                isPresent = true;
            }
            break;
        }
        return isPresent;
    }

    public boolean isGroupCreated(String groupName) {
        boolean isPresent = false;
        try {
            List<WebElement> groups = driver.findElements(By.id("traineeGroup"));

            for (WebElement group : groups) {
                if (groupName.equals(group.getText())) {
                    isPresent = true;
                }
                break;
            }
            return isPresent;
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable");
        }
        return isPresent;
    }

}
