package com.sparta.eng82.components.pages.trainer.feedbackpages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.pages.FeedbackFormPage;
import com.sparta.eng82.components.pages.trainer.TrainerHomePageImpl;

public class TrainerTrainerFeedbackFormPageImpl extends FeedbackFormPage implements TrainerTrainerFeedbackFormPage {

    private final By trainerCommentsTextField = new By.ById("trainerComments");

    private final By stopTrainerTextField = new By.ById("stopTrainer");
    private final By startTrainerTextField = new By.ById("startTrainer");
    private final By continueTrainerTextField = new By.ById("continueTrainer");

    private final By saveButton = new By.ById("saveBtn");
    private final By submitButton = new By.ById("submitBtn");

    private final By trainerDiv = new By.ById("trainer");

    private final WebDriver driver;
    private final String user;

    public TrainerTrainerFeedbackFormPageImpl(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
        this.user = user;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl enterTrainerComments(String comments) {
        driver.findElement(trainerCommentsTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl clickOnTrainer() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/label[2]")).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl clickOnStop() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/div[1]/label[1]")).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl enterTrainerStopComments(String comments) {
        driver.findElement(stopTrainerTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl clickOnStart() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/div[1]/label[2]")).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl enterTrainerStartComments(String comments) {
        driver.findElement(startTrainerTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl clickOnCont() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/div[1]/label[3]")).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl enterTrainerContComments(String comments) {
        driver.findElement(continueTrainerTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPageImpl clickOnTrainee() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/label[1]")).click();
        return new TrainerTraineeFeedbackFormPageImpl(driver, this.getClass().getSimpleName());
    }

    @Override
    public TrainerHomePageImpl clickSave() {
        driver.findElement(saveButton).click();
        return new TrainerHomePageImpl(driver, user);
    }

    @Override
    public TrainerHomePageImpl clickSubmit() {
        driver.findElement(submitButton).click();
        return new TrainerHomePageImpl(driver, user);
    }

    @Override
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getStopInputValue() {
        return driver.findElement(By.id("stopTrainer")).getAttribute("value");
    }

    public String getStartInputValue() {
        return driver.findElement(By.id("startTrainer")).getAttribute("value");
    }

    public String getContInputValue() {
        return driver.findElement(By.id("continueTrainer")).getAttribute("value");
    }

    public String getTrainerCommentInputValue() {
        return driver.findElement(By.id("trainerComments")).getAttribute("value");
    }

    public TrainerTrainerFeedbackFormPageImpl enterAllComments(String stopComments, String startComments, String contComments, String trainerComment) {
        return clickOnStop()
                .enterTrainerStopComments(stopComments)
                .clickOnStart()
                .enterTrainerStartComments(startComments)
                .clickOnCont()
                .enterTrainerContComments(contComments)
                .enterTrainerComments(trainerComment);
    }

    public boolean checkAllCommentsHaveBeenInputSuccessfully(String stopComment, String startComment, String continueComment, String trainerComment) {
        return clickOnStop().getStopInputValue().equals(stopComment)
                && clickOnStart().getStartInputValue().equals(startComment)
                && clickOnCont().getContInputValue().equals(continueComment)
                && getTrainerCommentInputValue().equals(trainerComment);
    }

    public boolean isTrainerDisplayed() {
        return driver.findElement(trainerDiv).isDisplayed();
    }

    public boolean checkSaveFeatureWorks(int week, String name, String stopComment, String startComment, String continueComment, String trainerComment) {
        return enterAllComments(stopComment, startComment, continueComment, trainerComment)
                .clickSave()
                .selectTraineeName(week, name)
                .clickOnTrainer()
                .checkAllCommentsHaveBeenInputSuccessfully(stopComment, startComment, continueComment, trainerComment);
    }

    public TrainerHomePageImpl clearCommentsAndSave() {
        clickOnStop();
        driver.findElement(stopTrainerTextField).clear();
        clickOnStart();
        driver.findElement(startTrainerTextField).clear();
        clickOnCont();
        driver.findElement(continueTrainerTextField).clear();
        driver.findElement(trainerCommentsTextField).clear();
        return clickSave();
    }
}
