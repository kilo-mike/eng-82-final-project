package refactor.pages.admin;

import com.sparta.eng82.interfaces.pages.navpages.admin.addpages.AddTrainerPage;

public interface AdminHomePage {

    AddTrainerPage addTrainer();

    boolean isTrainerAdded(String firstName, String lastName, String group);

    boolean getAllTrainersAvailable(int howManyTrainers);
}
