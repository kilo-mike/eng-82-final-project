package com.sparta.eng82.components.pages.navpages.trainer;

import com.sparta.eng82.components.pages.navpages.trainer.feedbackpages.TrainerTraineeFeedbackFormPageImpl;
import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.TrainerHomePage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.feedbackpages.TrainerTraineeFeedbackFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrainerHomePageImpl implements NavPage, TrainerHomePage {

    WebDriver driver;

    private By manageGroupButton = new By.ByLinkText("Manage Group");
    private By traineeNameLink;
    private By weekListName = new By.ByClassName("form-select mt-3 mb-3");
    private By weekName;

    public TrainerHomePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public ManageGroupPage manageGroupButton() {
        driver.findElement(manageGroupButton).click();
        return new ManageGroupPageImpl(driver);
    }

    @Override
    public TrainerTraineeFeedbackFormPage selectTraineeName(int week, String traineeName) {
        weekName = new By.ByXPath("//option[@value='" + week + "']");
        traineeNameLink = new By.ByLinkText(traineeName);

        driver.findElement(weekListName).findElement(weekName);
        driver.findElement(traineeNameLink).click();
        return new TrainerTraineeFeedbackFormPageImpl(driver, this.getClass().getSimpleName());
    }

    //TODO: Delete this
    public TrainerTraineeFeedbackFormPage selectJaneDoe() {
        driver.findElement(new By.ByCssSelector("#traineeTable2 td:nth-child(1)")).click();
        return new TrainerTraineeFeedbackFormPageImpl(driver, this.getClass().getSimpleName());
    }

    @Override
    public boolean menuDropdownDisplays() {
        return false;
    }

    @Override
    public boolean isUserDisplayNameCorrect() {
        return false;
    }

    @Override
    public boolean mainNavigationMenuAppears() {
        return false;
    }
}
