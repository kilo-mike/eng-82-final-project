package refactor.components.pages.trainee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.components.NavPage;
import refactor.components.pages.ProfilePage;
import refactor.components.pages.other.ChangePasswordPage;
import refactor.components.pages.other.ChangePasswordPageImpl;

import java.util.Arrays;

public class TraineeProfilePageImpl extends NavPage implements ProfilePage {


    private final By technicalGrade = new By.ByXPath("//*[@id=\"main-content\"]/div/div[4]/table/tbody/tr/td[1]");
    private final By consultantGrade = new By.ByXPath("//*[@id=\"main-content\"]/div/div[4]/table/tbody/tr/td[2]");
    private final WebDriver driver;
    private final String user;

    public TraineeProfilePageImpl(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
        this.user = user;
    }

    @Override
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public ChangePasswordPage goToChangePasswordPage() {
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[3]/form/button")).submit();
        return new ChangePasswordPageImpl(driver, user);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean checkNameMatches() {
        return false;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public boolean checkEmailMatches() {
        return false;
    }

    public boolean isTechnicalGradeValid() {
        String[] acceptableGrades = {"A", "B", "C", "D"};
        String grade = driver.findElement(technicalGrade).getText();
        return Arrays.stream(acceptableGrades).anyMatch(s -> s.contains(grade));

    }

    public boolean isConsultantGradeValid() {
        String[] acceptableGrades = {"A", "B", "C", "D"};
        String grade = driver.findElement(consultantGrade).getText();
        return Arrays.stream(acceptableGrades).anyMatch(s -> s.contains(grade));
    }

    public boolean areBothGradesValid() {
        return (isTechnicalGradeValid() && isConsultantGradeValid());
    }
}
