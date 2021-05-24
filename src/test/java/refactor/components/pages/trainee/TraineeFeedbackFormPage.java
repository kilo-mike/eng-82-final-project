package refactor.components.pages.trainee;

public interface TraineeFeedbackFormPage {

    boolean doCommentBoxesLockAfterClickingSubmit();

    boolean doGradesLockAfterClickingSubmit(char grade);

    String getTechnicalGrade();

    String getConsultantGrade();

    boolean isTechnicalGradeDisabled();

    boolean isConsultantGradeDisabled();


}
