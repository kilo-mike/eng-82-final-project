package com.sparta.eng82.components.pages.trainee;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.sparta.eng82.components.NavPage;
import com.sparta.eng82.components.frameworkutil.ActionClicker;
import com.sparta.eng82.components.pages.trainee.feedback.TraineeTraineeFeedbackFormPageImpl;

import java.util.List;


public class TraineeHomePageImpl extends NavPage implements TraineeHomePage {

    private final By feedbackBys = new By.ByClassName("list-group-item-action");
    private final By nameBy = new By.ByCssSelector("h1");
    private final List<WebElement> feedbackList;
    private final By currentWeekTrafficLightBy = new By.ByXPath("//*[@id=\"main-content\"]/div/div/div/div[2]/div/ul/li[1]/span");

    private final WebDriver driver;
    private final String user;


    public TraineeHomePageImpl(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
        this.user = user;
        feedbackList = driver.findElements(feedbackBys);
    }

    @Override
    public TraineeTraineeFeedbackFormPageImpl clickCurrentWeek() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.linkText(getCurrentWeek()));
        return new TraineeTraineeFeedbackFormPageImpl(driver, user);
    }

    @Override
    public TraineeTraineeFeedbackFormPageImpl clickFeedbackFormForWeek(int week) {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.linkText(feedbackList.get(week).getText()));
        return new TraineeTraineeFeedbackFormPageImpl(driver, user);
    }

    @Override
    public String getCurrentWeek() {
        return this.feedbackList.get(0).getText();
    }

    public int getCurrentWeekInt(){
        return Integer.parseInt(this.feedbackList.get(0).getText().substring(5));
    }

    @Override
    public boolean areAllPreviousWeeksShown() {
        int maxWeekNumber = retryingFindCurrentWeek(feedbackBys);
        return feedbackList.size() == maxWeekNumber + 1;
    }

    public int retryingFindCurrentWeek(By by) {
        int attempts = 0;
        while(attempts < 5) {
            try {
                return Integer.parseInt(driver.findElement(by).getAttribute("value"));
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return 0;
    }

    @Override
    public boolean areAllWeeksPriorToCurrentWeek() {
        boolean areAllWeeksPriorToCurrentWeek = true;
        String maxWeek = feedbackList.get(0).getText();
        int maxWeekNumber = Integer.parseInt(maxWeek.substring(5));
        for (WebElement currentWeekElement : feedbackList) {
            if (Integer.parseInt(currentWeekElement.getText().substring(5)) > maxWeekNumber) {
                areAllWeeksPriorToCurrentWeek = false;
                break;
            }
        }
        return areAllWeeksPriorToCurrentWeek;
    }

    @Override
    public boolean areAllWeeksDistinct() {
        boolean areAllWeeksDistinct = true;
        String maxWeek = feedbackList.get(0).getText();
        int maxWeekNumber = Integer.parseInt(maxWeek.substring(5));
        feedbackList.remove(0);
        for (int i = 0; i < maxWeekNumber; i++) {
            if (Integer.parseInt(feedbackList.get(i).getText().substring(5)) != i + 1) {
                areAllWeeksDistinct = false;
            }
        }
        return areAllWeeksDistinct;
    }

    @Override
    public String getCurrentTrafficLight() {
        String elementClass = driver.findElement(currentWeekTrafficLightBy).getAttribute("class");
        if (elementClass.contains("green")) return "Green";
        else if (elementClass.contains("amber")) return "Amber";
        else return "Red";
    }

    @Override
    public String getTrafficLightForWeek(int week) {
        String newXPath = String.format("//*[@id=\"main-content\"]/div/div/div/div[2]/div/ul/li[%2d]/span", week + 1);
        String elementClass = driver.findElement(new By.ByXPath(newXPath)).getAttribute("class");
        if (elementClass.contains("green")) return "Green";
        else if (elementClass.contains("amber")) return "Amber";
        else return "Red";
    }

    @Override
    public String getName() {
        return driver.findElement(nameBy).getText();
    }

    @Override
    public String getStream() {
        String[] course = driver.findElement(By.tagName("h5")).getText().split("-");
        return course[1].trim();
    }

    @Override
    public String getGroup() {
        String[] course = driver.findElement(By.tagName("h5")).getText().split("-");
        return course[0].trim();
    }

    @Override
    public String getTrainer() {
        List<WebElement> trainer = driver.findElements(By.tagName("label"));
        return trainer.get(1).getText();
    }

    @Override
    public String getMaxWeek() {
        return feedbackList.get(feedbackList.size() - 1).getText();
    }

    @Override
    public String getUrl() {
        return null;
    }
}
