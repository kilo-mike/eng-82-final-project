package com.sparta.eng82.components.pages.navpages.trainee;

import com.sparta.eng82.components.pages.navpages.trainee.feedbackpages.TraineeTraineeFeedbackFormPageImpl;
import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TraineeHomePageImpl implements TraineeHomePage {
    private WebDriver driver;
    private final By feedbackBys = new By.ByClassName("list-group-item list-group-item-action fw-bold");
    private final List<WebElement> feedbackList = driver.findElements(feedbackBys);
    private final By nameBy = new By.ByCssSelector("h1");

    public TraineeHomePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public TraineeFeedbackFormPage clickCurrentWeek() {
        driver.findElement(By.linkText(getCurrentWeek())).click();
        return new TraineeTraineeFeedbackFormPageImpl(driver);
    }

    @Override
    public TraineeFeedbackFormPage clickFeedbackFormForWeek(int week) {
        driver.findElement(By.linkText(feedbackList.get(week).toString())).click();
        return new TraineeTraineeFeedbackFormPageImpl(driver);
    }

    @Override
    public String getCurrentWeek() {
        return feedbackList.get(0).toString();
    }

    @Override
    public boolean areAllPreviousWeeksShown() {
        String maxWeek = feedbackList.get(0).toString();
        int maxWeekNumber = Integer.parseInt(maxWeek.substring(5));
        return feedbackList.size() == maxWeekNumber + 1;
    }

    @Override
    public boolean areAllWeeksPriorToCurrentWeek() {
        boolean areAllWeeksPriorToCurrentWeek = true;
        String maxWeek = feedbackList.get(0).toString();
        int maxWeekNumber = Integer.parseInt(maxWeek.substring(5));
        for (WebElement currentWeekElement : feedbackList) {
            if (Integer.parseInt(currentWeekElement.toString().substring(5)) > maxWeekNumber) {
                areAllWeeksPriorToCurrentWeek = false;
                break;
            }
        }
        return areAllWeeksPriorToCurrentWeek;
    }

    @Override
    public boolean areAllWeeksDistinct() {
        boolean areAllWeeksDistinct = true;
        String maxWeek = feedbackList.get(0).toString();
        int maxWeekNumber = Integer.parseInt(maxWeek.substring(5));
        feedbackList.remove(0);
        for (int i = 0; i < maxWeekNumber; i++) {
            if (Integer.parseInt(feedbackList.get(i).toString()) != i) {
                areAllWeeksDistinct = false;
            }

        }
        return areAllWeeksDistinct;
    }

    @Override
    public String getCurrentTrafficLight() {
        //TODO currently unable to complete
        return null;
    }

    @Override
    public String getTrafficLightForWeek(int week) {
        //TODO currently unable to complete
        return null;
    }

    @Override
    public String getName() {
        return driver.findElement(nameBy).getText();
    }

    @Override
    public String getStream() {
        String[] course = driver.findElement(By.tagName("h5")).getText().split("-");
        return course[1];
    }

    @Override
    public String getGroup() {
        String[] course = driver.findElement(By.tagName("h5")).getText().split("-");
        return course[0];
    }

    @Override
    public String getTrainer() {
        List<WebElement> trainer = driver.findElements(By.tagName("label"));
        return trainer.get(1).getText();
    }
}
