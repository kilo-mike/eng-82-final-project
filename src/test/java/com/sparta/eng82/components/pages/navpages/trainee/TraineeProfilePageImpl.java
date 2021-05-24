//package com.sparta.eng82.components.pages.navpages.trainee;
//
//import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeProfilePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import java.util.Arrays;
//
//public class TraineeProfilePageImpl implements TraineeProfilePage {
//
//    private final By technicalGrade = new By.ByXPath("//*[@id=\"main-content\"]/div/div[4]/table/tbody/tr/td[1]");
//    private final By consultantGrade = new By.ByXPath("//*[@id=\"main-content\"]/div/div[4]/table/tbody/tr/td[2]");
//    WebDriver driver;
//
//    public TraineeProfilePageImpl(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    @Override
//    public boolean isTechnicalGradeValid() {
//        String[] acceptableGrades = {"A", "B", "C", "D"};
//        String grade = driver.findElement(technicalGrade).getText();
//        return Arrays.stream(acceptableGrades).anyMatch(s -> s.contains(grade));
//
//    }
//
//    @Override
//    public boolean isConsultantGradeValid() {
//        String[] acceptableGrades = {"A", "B", "C", "D"};
//        String grade = driver.findElement(consultantGrade).getText();
//        return Arrays.stream(acceptableGrades).anyMatch(s -> s.contains(grade));
//    }
//
//    @Override
//    public boolean areBothGradesValid() {
//        return (isTechnicalGradeValid() && isConsultantGradeValid());
//    }
//
//    @Override
//    public boolean isAverageGradeCorrect() {
//        // TODO possible JDBC integration if we have time later
//        return false;
//    }
//
//    @Override
//    public boolean isSubmissionDateCorrect() {
//        // TODO see above
//        return false;
//    }
//}
