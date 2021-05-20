package com.sparta.eng82.components.pages.navpages.trainer;

import com.sparta.eng82.components.pages.navpages.trainer.feedbackpages.TrainerTraineeFeedbackFormPageImpl;
import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.TrainerHomePage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.feedbackpages.TrainerTraineeFeedbackFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TrainerHomePageImpl implements NavPage, TrainerHomePage {

    private final By manageGroupButton = new By.ByLinkText("Manage Group");
    private final By weekListName = new By.ByXPath("//select[@class=\"form-select mt-3 mb-3\"]");
    WebDriver driver;
    private By traineeNameTable;
    private By traineeNameFinder;
    private By weekName;
    private String userFullName;

    {
        try {
            InputStream input = new FileInputStream("src/test/resources/login.properties");
            Properties properties = new Properties();
            properties.load(input);
            userFullName = properties.getProperty("trainer_name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        traineeNameTable = new By.ById("traineeTable2");
        traineeNameFinder = new By.ByXPath("//td[\"" + traineeName + "\"]");

        driver.findElement(weekListName).findElement(weekName).click();
        String traineeNames = driver.findElement(traineeNameTable).findElement(traineeNameFinder).getText();
        if (traineeNames.isEmpty()) {
            System.out.println("NULL");
        }
        System.out.println(traineeNames);

        //driver.findElement(traineeNameLink).click();
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
        String userDisplayName = driver.findElement(By.cssSelector(".pb-3:nth-child(2)")).getText().substring(6);
        return (userFullName.equals(userDisplayName));
    }

    @Override
    public boolean mainNavigationMenuAppears() {
        String navBarShowing = "navbar-collapse bg-color-main collapse show";
        driver.findElement(By.cssSelector(".bi-list")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String navBarStatus = driver.findElement(By.id("navbarNav")).getAttribute("class");
        return navBarStatus.equals(navBarShowing);
    }
}
