package refactor.components.pages.trainer.feedbackpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.components.frameworkutil.ActionClicker;
import refactor.components.pages.FeedbackFormPage;
import refactor.components.pages.trainer.TrainerFeedbackFormPage;

public class TrainerTraineeFeedbackFormPageImpl extends FeedbackFormPage implements TrainerTraineeFeedbackFormPage {

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
    private final By trainerButton = new By.ByXPath("/html/body/div[2]/div/div/form/div[1]/label[2]");

    private final WebDriver driver;
    private final String user;

    private By technicalGrades;
    private By consultantGrades;

    public TrainerTraineeFeedbackFormPageImpl(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;

        this.user = user;
    }

    @Override
    public TrainerFeedbackFormPage enterTrainerComments(String comments) {
        driver.findElement(trainerCommentsTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPageImpl clickOnStop() {
        driver.findElement(stopButton).click();
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPageImpl clickOnStart() {
        driver.findElement(startButton).click();
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPageImpl clickOnCont() {
        driver.findElement(continueButton).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl clickOnTrainer() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, trainerButton);
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
