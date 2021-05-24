package refactor.components.pages.trainer.feedbackpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.components.pages.trainer.TrainerFeedbackFormPage;

public class TrainerTraineeFeedbackFormPageImpl implements TrainerTraineeFeedbackFormPage {

    private final By technicalGradeField = new By.ById("techGrade");
    private final By consultantGradeField = new By.ById("consultGrade");
    private final By consultantGradeTitle = new By.ByLinkText("Consultant Grade");
    private final By saveButton = new By.ById("saveBtn");
    private final By submitButton = new By.ById("submitBtn");
    private final By pageHeading = new By.ByClassName("mt-5 fw-bold text-center");
    private final By trainerCommentsTextField = new By.ById("trainerComments");
    private final By stopButton = new By.ByLinkText("Stop");
    private final By startButton = new By.ByLinkText("Start");
    private final By continueButton = new By.ByLinkText("Cont.");
    private final By trainerButton = new By.ByLinkText("Trainer");

    WebDriver driver;
    private By technicalGrades;
    private By consultantGrades;
    private final String user;

    public TrainerTraineeFeedbackFormPageImpl(WebDriver driver, String user) {
        this.driver = driver;

        this.user = user;
    }

    @Override
    public TrainerFeedbackFormPage enterTrainerComments(String comments) {
        driver.findElement(trainerCommentsTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPage clickOnStop() {
        driver.findElement(stopButton).click();
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPage clickOnStart() {
        driver.findElement(startButton).click();
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPage clickOnCont() {
        driver.findElement(continueButton).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPage clickOnTrainer() {
        driver.findElement(trainerButton).click();
        return new TrainerTrainerFeedbackFormPageImpl(driver, user);
    }

    @Override
    public boolean isTrainerCommentsEditable() {
        return false;
    }

    @Override
    public boolean isTraineeCommentsEditable() {
        return false;
    }

    @Override
    public boolean isTechnicalGradeValid() {
        return false;
    }

    @Override
    public boolean isConsultantGradeValid() {
        return false;
    }

    @Override
    public boolean isSaveButtonPresent() {
        return false;
    }

    @Override
    public boolean isSubmitButtonPresent() {
        return false;
    }

    public String getSimpleName() {
        return user;
    }

    @Override
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
