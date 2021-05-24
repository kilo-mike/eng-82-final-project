package refactor.components.pages.trainee;

public interface TraineeHomePage {

    TraineeFeedbackFormPage clickCurrentWeek();

    TraineeFeedbackFormPage clickFeedbackFormForWeek(int week);

    String getCurrentWeek();

    boolean areAllPreviousWeeksShown();

    boolean areAllWeeksPriorToCurrentWeek();

    boolean areAllWeeksDistinct();

    String getCurrentTrafficLight();

    String getTrafficLightForWeek(int week);

    String getName();

    String getStream();

    String getGroup();

    String getTrainer();

    String getMaxWeek();
}
